/**
 * @projectName jc-club
 * @package com.jingdianjichi.subject.domain.service.impl
 * @className com.jingdianjichi.subject.domain.service.impl.SubjectCategoryDomainServiceImpl
 * @copyright Copyright 2020 Thunisoft, Inc All rights reserved.
 */
package com.jingdianjichi.subject.domain.service.impl;

import com.alibaba.fastjson.JSON;
import com.jingdianjichi.subject.common.enums.IsDeleteFlagEnum;
import com.jingdianjichi.subject.domain.convert.SubjectLabelConverter;
import com.jingdianjichi.subject.domain.entity.SubjectLabelBO;
import com.jingdianjichi.subject.domain.service.SubjectLabelDomainService;
import com.jingdianjichi.subject.infra.basic.entity.SubjectLabel;
import com.jingdianjichi.subject.infra.basic.entity.SubjectMapping;
import com.jingdianjichi.subject.infra.basic.service.SubjectLabelService;
import com.jingdianjichi.subject.infra.basic.service.SubjectMappingService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.Collections;
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
public class SubjectLabelDomainServiceImpl implements SubjectLabelDomainService {

    @Resource
    private SubjectLabelService subjectLabelService;

    @Resource
    private SubjectMappingService subjectMappingService;

    @Override
    public Boolean add(SubjectLabelBO subjectLabelBO) {
        // 1. 日志： 打印入参
        if (log.isInfoEnabled()){
            log.info("SubjectLabelDomainServiceImpl.add.subjectLabelBO:{}", JSON.toJSONString(subjectLabelBO));
        }

        // 2. 转换BO对象为DO对象
        SubjectLabel subjectLabel = SubjectLabelConverter.INSTANCE.convertBoToEntity(subjectLabelBO);

        // 3. 新增标签
        subjectLabel.setIsDeleted(IsDeleteFlagEnum.UN_DELETED.getCode());
        int result = subjectLabelService.insert(subjectLabel);

        // 4. 返回结果
        return result > 0;
    }

    @Override
    public Boolean update(SubjectLabelBO subjectLabelBO) {

        // 1. 日志： 打印入参
        if (log.isInfoEnabled()){
            log.info("SubjectLabelDomainServiceImpl.update.subjectLabelBO:{}", JSON.toJSONString(subjectLabelBO));
        }

        // 2. 转换BO对象为DO对象
        SubjectLabel subjectLabel = SubjectLabelConverter.INSTANCE.convertBoToEntity(subjectLabelBO);

        // 3. 更新标签
        int result = subjectLabelService.update(subjectLabel);

        // 4. 返回结果
        return result > 0;
    }

    @Override
    public Boolean delete(SubjectLabelBO subjectLabelBO) {

        // 1. 日志： 打印入参
        if (log.isInfoEnabled()){
            log.info("SubjectLabelDomainServiceImpl.delete.subjectLabelBO:{}", JSON.toJSONString(subjectLabelBO));
        }

        // 2. 转换BO对象为DO对象
        SubjectLabel subjectLabel = SubjectLabelConverter.INSTANCE.convertBoToEntity(subjectLabelBO);
        subjectLabel.setIsDeleted(IsDeleteFlagEnum.DELETED.getCode());

        // 3. 删除标签(逻辑删除)
        int result = subjectLabelService.update(subjectLabel);

        // 4. 返回结果
        return result > 0;
    }

    @Override
    public List<SubjectLabelBO> queryLabelByCategoryId(SubjectLabelBO subjectLabelBO) {

        // 1. 取出分类id
        Long categoryId = subjectLabelBO.getCategoryId();

        // 2. 根据分类id查询标签id集合
        SubjectMapping subjectMapping = new SubjectMapping();
        subjectMapping.setSubjectId(categoryId);
        subjectMapping.setIsDeleted(IsDeleteFlagEnum.UN_DELETED.getCode());
        List<SubjectMapping> mappingList = subjectMappingService.queryLabelId(subjectMapping);
        if (CollectionUtils.isEmpty(mappingList)){
            return Collections.emptyList();
        }
        List<Long> labelIdList = mappingList.stream().map(SubjectMapping::getLabelId).collect(Collectors.toList());

        // 3. 根据标签id集合查询标签信息
        List<SubjectLabel> labelList = subjectLabelService.batchQueryByIds(labelIdList);
        LinkedList<SubjectLabelBO> subjectLabelBoList = new LinkedList<>();
        labelList.forEach(label ->{
            SubjectLabelBO bo = SubjectLabelConverter.INSTANCE.convertEntityToBo(label);
            bo.setCategoryId(categoryId);
            subjectLabelBoList.add(bo);
        });

        // 4. 返回结果
        return subjectLabelBoList;

    }
}

