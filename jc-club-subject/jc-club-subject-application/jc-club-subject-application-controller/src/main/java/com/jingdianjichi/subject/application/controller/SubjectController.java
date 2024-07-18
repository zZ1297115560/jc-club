/**
 * @projectName jc-club
 * @package com.jingdianjichi.subject.application.controller
 * @className com.jingdianjichi.subject.application.controller.SubjectController
 * @copyright Copyright 2020 Thunisoft, Inc All rights reserved.
 */
package com.jingdianjichi.subject.application.controller;

import com.alibaba.fastjson.JSON;
import com.google.common.base.Preconditions;
import com.jingdianjichi.subject.application.convert.SubjectAnswerDTOConverter;
import com.jingdianjichi.subject.application.convert.SubjectInfoDTOConverter;
import com.jingdianjichi.subject.application.dto.SubjectInfoDTO;
import com.jingdianjichi.subject.common.entity.PageResult;
import com.jingdianjichi.subject.common.entity.Result;
import com.jingdianjichi.subject.domain.entity.SubjectAnswerBO;
import com.jingdianjichi.subject.domain.entity.SubjectInfoBO;
import com.jingdianjichi.subject.domain.service.SubjectInfoDomainService;
import com.jingdianjichi.subject.infra.basic.entity.SubjectInfoEs;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;


@RestController
@Slf4j
@RequestMapping("/subject")
public class SubjectController {

    @Resource
    private SubjectInfoDomainService subjectInfoDomainService;

    /**
     * 新增题目
     * @param subjectInfoDTO 题目信息
     * @return 返回 Result对象，包括操作的成功（true）或失败（false）状态。失败时Result包含错误消息。
     */
    @PostMapping("/add")
    public Result<Boolean> add(@RequestBody SubjectInfoDTO subjectInfoDTO){
        try {
            // 1. 日志：打印入参
            if (log.isInfoEnabled()){
                log.info("SubjectController.add.SubjectInfoDTO:{}", JSON.toJSONString(subjectInfoDTO));
            }

            // 2. 参数校验: 题目名称，题目难度，题目类型，题目分数，分类id，标签id
            Preconditions.checkArgument(!StringUtils.isBlank(subjectInfoDTO.getSubjectName()),
                        "题目名称不能为空");
            Preconditions.checkNotNull(subjectInfoDTO.getSubjectDifficult(),
                        "题目难度不能为空");
            Preconditions.checkNotNull(subjectInfoDTO.getSubjectType(),
                        "题目类型不能为空");
            Preconditions.checkNotNull(subjectInfoDTO.getSubjectScore(),
                        "题目分数不能为空");
            Preconditions.checkArgument(!CollectionUtils.isEmpty(subjectInfoDTO.getCategoryIds()),
                        "分类id不能为空");
            Preconditions.checkArgument(!CollectionUtils.isEmpty(subjectInfoDTO.getLabelIds()),
                        "标签id不能为空");

            // 3. 转换DTO为BO
            SubjectInfoBO subjectInfoBO = SubjectInfoDTOConverter.INSTANCE.convertDtoToBO(subjectInfoDTO);
            List<SubjectAnswerBO> optionList =
                    SubjectAnswerDTOConverter.INSTANCE.convertDtoListToSubjectAnswerBoList(subjectInfoDTO.getOptionList());
            subjectInfoBO.setOptionList(optionList);

            // 4. 调用题目信息领域服务新增题目
            subjectInfoDomainService.add(subjectInfoBO);
            return Result.ok(true);
        } catch (Exception e) {
            log.error("SubjectController.add.error:{}",e.getMessage(),e);
            return Result.fail();
        }

    }

    /**
     * 查询题目列表
     * @param subjectInfoDTO 题目信息
     * @return 返回 Result对象，包括操作的成功（true）或失败（false）状态。失败时Result包含错误消息。
     */
    @PostMapping("/getSubjectPage")
    public Result<PageResult<SubjectInfoBO>> getSubjectPage(@RequestBody SubjectInfoDTO subjectInfoDTO){
        try {
            // 1. 日志：打印入参
            if (log.isInfoEnabled()){
                log.info("SubjectController.getSubjectPage.SubjectInfoDTO:{}", JSON.toJSONString(subjectInfoDTO));
            }

            // 2. 参数校验: 分类id，标签id
            Preconditions.checkNotNull(subjectInfoDTO.getCategoryId(),
                    "分类id不能为空");
            Preconditions.checkNotNull(subjectInfoDTO.getLabelId(),
                    "标签id不能为空");

            // 3. 转换DTO为BO
            SubjectInfoBO subjectInfoBO = SubjectInfoDTOConverter.INSTANCE.convertDtoToBO(subjectInfoDTO);
            subjectInfoBO.setPageNo(subjectInfoDTO.getPageNo());
            subjectInfoBO.setPageSize(subjectInfoDTO.getPageSize());

            // 4. 调用题目信息领域服务新增题目
            PageResult<SubjectInfoBO> subjectInfoBOPageResult = subjectInfoDomainService.getSubjectPage(subjectInfoBO);
            return Result.ok(subjectInfoBOPageResult);
        } catch (Exception e) {
            log.error("SubjectController.getSubjectPage.error:{}",e.getMessage(),e);
            return Result.fail();
        }
    }

    /**
     * 查询题目信息
     * @param subjectInfoDTO 题目信息
     * @return 返回 Result对象，包括操作的成功（true）或失败（false）状态。失败时Result包含错误消息。
     */
    @PostMapping("/querySubjectInfo")
    public Result<SubjectInfoDTO> querySubjectInfo(@RequestBody SubjectInfoDTO subjectInfoDTO){
        try {
            // 1. 日志：打印入参
            if (log.isInfoEnabled()){
                log.info("SubjectController.querySubjectInfo.subjectInfoDTO:{}", JSON.toJSONString(subjectInfoDTO));
            }

            // 2. 参数校验: 题目id，分类id，标签id
            Preconditions.checkNotNull(subjectInfoDTO.getId(),
                    "题目id不能为空");
//            Preconditions.checkNotNull(subjectInfoDTO.getCategoryId(),
//                    "分类id不能为空");
//            Preconditions.checkNotNull(subjectInfoDTO.getLabelId(),
//                    "标签id不能为空");

            // 3. 转换DTO为BO
            SubjectInfoBO subjectInfoBO = SubjectInfoDTOConverter.INSTANCE.convertDtoToBO(subjectInfoDTO);

            // 4. 调用题目信息领域服务新增题目
            SubjectInfoBO subjectInfoBoResult = subjectInfoDomainService.querySubjectInfo(subjectInfoBO);

            // 5. 转换BO为DTO
            SubjectInfoDTO subjectInfoDTOResult = SubjectInfoDTOConverter.INSTANCE.convertBoToDto(subjectInfoBoResult);

            // 6. 返回结果
            return Result.ok(subjectInfoDTOResult);
        } catch (Exception e) {
            log.error("SubjectController.getSubjectPage.error:{}",e.getMessage(),e);
            return Result.fail();
        }

    }
    /**
     * 全文检索
     */
    @PostMapping("/getSubjectPageBySearch")
    public Result<PageResult<SubjectInfoEs>> getSubjectPageBySearch(@RequestBody SubjectInfoDTO subjectInfoDTO) {
        try {
            if (log.isInfoEnabled()) {
                log.info("SubjectController.getSubjectPageBySearch.dto:{}", JSON.toJSONString(subjectInfoDTO));
            }
            Preconditions.checkArgument(StringUtils.isNotBlank(subjectInfoDTO.getKeyWord()), "关键词不能为空");
            SubjectInfoBO subjectInfoBO = SubjectInfoDTOConverter.INSTANCE.convertDtoToBO(subjectInfoDTO);
            subjectInfoBO.setPageNo(subjectInfoDTO.getPageNo());
            subjectInfoBO.setPageSize(subjectInfoDTO.getPageSize());
            PageResult<SubjectInfoEs> boPageResult = subjectInfoDomainService.getSubjectPageBySearch(subjectInfoBO);
            return Result.ok(boPageResult);
        } catch (Exception e) {
            log.error("SubjectCategoryController.getSubjectPageBySearch.error:{}", e.getMessage(), e);
            return Result.fail("全文检索失败");
        }
    }

}

