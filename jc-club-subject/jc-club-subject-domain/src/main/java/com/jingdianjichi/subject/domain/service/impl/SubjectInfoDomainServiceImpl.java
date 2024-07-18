/**
 * @projectName jc-club
 * @package com.jingdianjichi.subject.domain.service.impl
 * @className com.jingdianjichi.subject.domain.service.impl.SubjectCategoryDomainServiceImpl
 * @copyright Copyright 2020 Thunisoft, Inc All rights reserved.
 */
package com.jingdianjichi.subject.domain.service.impl;

import com.alibaba.fastjson.JSON;
import com.jingdianjichi.subject.common.entity.PageResult;
import com.jingdianjichi.subject.common.enums.IsDeletedFlagEnum;
import com.jingdianjichi.subject.common.util.IdWorkerUtil;
import com.jingdianjichi.subject.domain.convert.SubjectInfoConverter;
import com.jingdianjichi.subject.domain.entity.SubjectInfoBO;
import com.jingdianjichi.subject.domain.entity.SubjectOptionBO;
import com.jingdianjichi.subject.domain.handler.subject.SubjectTypeHandler;
import com.jingdianjichi.subject.domain.handler.subject.SubjectTypeHandlerFactory;
import com.jingdianjichi.subject.domain.service.SubjectInfoDomainService;
import com.jingdianjichi.subject.infra.basic.entity.*;
import com.jingdianjichi.subject.infra.basic.service.SubjectEsService;
import com.jingdianjichi.subject.infra.basic.service.SubjectInfoService;
import com.jingdianjichi.subject.infra.basic.service.SubjectLabelService;
import com.jingdianjichi.subject.infra.basic.service.SubjectMappingService;
import com.jingdianjichi.subject.infra.rpc.UserRpc;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * SubjectCategoryDomainServiceImpl
 * @author zxf
 * @date 2024/6/10 21:46
 * @version 1.0
 */
@Service
@Slf4j
public class SubjectInfoDomainServiceImpl implements SubjectInfoDomainService {

    @Resource
    private SubjectLabelService subjectLabelService;

    @Resource
    private SubjectInfoService subjectInfoService;

    @Resource
    private SubjectTypeHandlerFactory subjectTypeHandlerFactory;

    @Resource
    private SubjectMappingService subjectMappingService;
    @Resource
    private SubjectEsService subjectEsService;
    @Resource
    private UserRpc userRpc;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean add(SubjectInfoBO subjectInfoBO) {
        // 1. 日志： 打印入参
        if (log.isInfoEnabled()){
            log.info("SubjectInfoDomainServiceImpl.add.subjectLabelBO:{}", JSON.toJSONString(subjectInfoBO));
        }

        // 2. 转换BO对象为DO对象
        SubjectInfo subjectInfo = SubjectInfoConverter.INSTANCE.convertBoToEntity(subjectInfoBO);

        // 3. 新增题目信息，并将新增的题目id设置到BO对象中
        subjectInfo.setIsDeleted(IsDeletedFlagEnum.UN_DELETED.getCode());
        // 3.1 新增题目信息,会返回主键id
        subjectInfoService.insert(subjectInfo);
        // 3.2 将新增的题目id设置到BO对象中
        subjectInfoBO.setId(subjectInfo.getId());

        // 4. 根据题目类型，调用不同的处理器，新增题目答案信息
        SubjectTypeHandler handler = subjectTypeHandlerFactory.getHandler(subjectInfo.getSubjectType());
        handler.add(subjectInfoBO);

        // 5. 新增题目与标签的关联关系
        List<Integer> categoryIds = subjectInfoBO.getCategoryIds();
        List<Integer> labelIds = subjectInfoBO.getLabelIds();
        List<SubjectMapping> mappingList = new LinkedList<>();
        categoryIds.forEach(categoryId->{
            labelIds.forEach(labelId->{
                SubjectMapping subjectMapping = new SubjectMapping();
                subjectMapping.setSubjectId(subjectInfo.getId());
                subjectMapping.setCategoryId(Long.valueOf(categoryId));
                subjectMapping.setLabelId(Long.valueOf(labelId));
                subjectMapping.setIsDeleted(IsDeletedFlagEnum.UN_DELETED.getCode());
                mappingList.add(subjectMapping);
            });
        });
        subjectMappingService.batchInsert(mappingList);
        //同步到es
        SubjectInfoEs subjectInfoEs = new SubjectInfoEs();
        subjectInfoEs.setDocId(new IdWorkerUtil(1, 1, 1).nextId());
        subjectInfoEs.setSubjectId(subjectInfo.getId());
        subjectInfoEs.setSubjectAnswer(subjectInfoBO.getSubjectAnswer());
        subjectInfoEs.setCreateTime(new Date().getTime());
        subjectInfoEs.setCreateUser("鸡翅");
        subjectInfoEs.setSubjectName(subjectInfo.getSubjectName());
        subjectInfoEs.setSubjectType(subjectInfo.getSubjectType());
        subjectEsService.insert(subjectInfoEs);

        // 4. 返回结果
        return null;
    }

    @Override
    public PageResult<SubjectInfoEs> getSubjectPageBySearch(SubjectInfoBO subjectInfoBO) {
        SubjectInfoEs subjectInfoEs = new SubjectInfoEs();
        subjectInfoEs.setPageNo(subjectInfoBO.getPageNo());
        subjectInfoEs.setPageSize(subjectInfoBO.getPageSize());
        subjectInfoEs.setKeyWord(subjectInfoBO.getKeyWord());
        return subjectEsService.querySubjectList(subjectInfoEs);
    }

    @Override
    public PageResult<SubjectInfoBO> getSubjectPage(SubjectInfoBO subjectInfoBO) {

        PageResult<SubjectInfoBO> pageResult = new PageResult<>();
        pageResult.setPageNo(subjectInfoBO.getPageNo());
        pageResult.setPageSize(subjectInfoBO.getPageSize());
        int start = (subjectInfoBO.getPageNo() - 1) * subjectInfoBO.getPageSize();
        SubjectInfo subjectinfo = SubjectInfoConverter.INSTANCE.convertBoToEntity(subjectInfoBO);
        int count = subjectInfoService.countByCondition(subjectinfo, subjectInfoBO.getCategoryId(),subjectInfoBO.getLabelId());
        if (count == 0){
            return pageResult;
        }

        List<SubjectInfo> subjectInfoList = subjectInfoService.queryPage(subjectinfo, subjectInfoBO.getCategoryId(),subjectInfoBO.getLabelIds(),
                start,subjectInfoBO.getPageSize());
        List<SubjectInfoBO> subjectInfoBOList = SubjectInfoConverter.INSTANCE.convertEntityListToBoList(subjectInfoList);
        pageResult.setRecords(subjectInfoBOList);
        pageResult.setTotal(count);
        return pageResult;

    }

    @Override
    public SubjectInfoBO querySubjectInfo(SubjectInfoBO subjectInfoBO) {
        SubjectInfo subjectInfo = subjectInfoService.queryById(subjectInfoBO.getId());
        if (subjectInfo == null){
            if (log.isInfoEnabled()){
                log.info("SubjectInfoDomainServiceImpl.querySubjectInfo.subjectInfo is null,subjectInfoBO:{}", JSON.toJSONString(subjectInfoBO));
            }
            return null;
        }
        Integer subjectType = subjectInfo.getSubjectType();
        SubjectTypeHandler handler = subjectTypeHandlerFactory.getHandler(subjectType);
        SubjectOptionBO optionBO = handler.query(subjectInfo.getId().intValue());
        SubjectInfoBO subjectInfoBO1 = SubjectInfoConverter.INSTANCE.convertOptionBoAndInfoToBo(optionBO,subjectInfo);

        // 查询labelName
        SubjectMapping subjectMapping = new SubjectMapping();
        subjectMapping.setSubjectId(subjectInfoBO.getId());
        subjectMapping.setIsDeleted(IsDeletedFlagEnum.UN_DELETED.getCode());
        List<SubjectMapping> mappingList = subjectMappingService.queryLabelId(subjectMapping);
        List<Long> LabelIdList = mappingList.stream().map(SubjectMapping::getLabelId).collect(Collectors.toList());
        List<SubjectLabel> subjectLabelList = subjectLabelService.batchQueryByIds(LabelIdList);
        List<String> labelNameList = subjectLabelList.stream().map(SubjectLabel::getLabelName).collect(Collectors.toList());

        subjectInfoBO1.setLabelNames(labelNameList);
        return subjectInfoBO1;
    }

    @Override
    public List<SubjectInfoBO> getContributeList() {
        List<SubjectInfo> subjectInfoList = subjectInfoService.getContributeCount();
        if (CollectionUtils.isEmpty(subjectInfoList)) {
            return Collections.emptyList();
        }
        List<SubjectInfoBO> boList = new LinkedList<>();
        subjectInfoList.forEach((subjectInfo -> {
            SubjectInfoBO subjectInfoBO = new SubjectInfoBO();
            subjectInfoBO.setSubjectCount(subjectInfo.getSubjectCount());
            UserInfo userInfo = userRpc.getUserInfo(subjectInfo.getCreatedBy());
            subjectInfoBO.setCreateUser(userInfo.getNickName());
            subjectInfoBO.setCreateUserAvatar(userInfo.getAvatar());
            boList.add(subjectInfoBO);
        }));
        return boList;
    }

}

