/**
 * @projectName jc-club
 * @package com.jingdianjichi.subject.application.controller
 * @className com.jingdianjichi.subject.application.controller.SubjectLikedController
 * @copyright Copyright 2020 Thunisoft, Inc All rights reserved.
 */
package com.jingdianjichi.subject.application.controller;

import com.alibaba.fastjson.JSON;
import com.google.common.base.Preconditions;
import com.jingdianjichi.subject.application.convert.SubjectLikedDTOConverter;
import com.jingdianjichi.subject.application.dto.SubjectLikedDTO;
import com.jingdianjichi.subject.common.entity.Result;
import com.jingdianjichi.subject.domain.entity.SubjectLikedBO;
import com.jingdianjichi.subject.domain.service.SubjectLikedDomainService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * SubjectLikedController
 * @author zxf
 * @date 2024/7/19 2:08
 * @version 1.0
 */
@RestController
@RequestMapping("/subjectLiked/")
@Slf4j
public class SubjectLikedController {

    @Resource
    private SubjectLikedDomainService subjectLikedDomainService;

    /**
     * 新增题目点赞表
     */
    @RequestMapping("add")
    public Result<Boolean> add(@RequestBody SubjectLikedDTO subjectLikedDTO) {

        try {
            if (log.isInfoEnabled()) {
                log.info("SubjectLikedController.add.dto:{}", JSON.toJSONString(subjectLikedDTO));
            }
            Preconditions.checkNotNull(subjectLikedDTO.getId(), "主键不能为空");
            Preconditions.checkNotNull(subjectLikedDTO.getSubjectId(), "题目id不能为空");
            Preconditions.checkNotNull(subjectLikedDTO.getLikeUserId(), "点赞人id不能为空");
            Preconditions.checkNotNull(subjectLikedDTO.getStatus(), "点赞状态 1点赞 0不点赞不能为空");
            Preconditions.checkNotNull(subjectLikedDTO.getCreatedBy(), "创建人不能为空");
            Preconditions.checkNotNull(subjectLikedDTO.getCreatedTime(), "创建时间不能为空");
            Preconditions.checkNotNull(subjectLikedDTO.getUpdateBy(), "修改人不能为空");
            Preconditions.checkNotNull(subjectLikedDTO.getUpdateTime(), "修改时间不能为空");
            Preconditions.checkNotNull(subjectLikedDTO.getIsDeleted(), "不能为空");
            SubjectLikedBO SubjectLikedBO = SubjectLikedDTOConverter.INSTANCE.convertDTOToBO(subjectLikedDTO);
            return Result.ok(subjectLikedDomainService.add(SubjectLikedBO));
        } catch (Exception e) {
            log.error("SubjectLikedController.register.error:{}", e.getMessage(), e);
            return Result.fail("新增题目点赞表失败");
        }

    }

    /**
     * 修改题目点赞表
     */
    @RequestMapping("update")
    public Result<Boolean> update(@RequestBody SubjectLikedDTO subjectLikedDTO) {

        try {
            if (log.isInfoEnabled()) {
                log.info("SubjectLikedController.update.dto:{}", JSON.toJSONString(subjectLikedDTO));
            }
            Preconditions.checkNotNull(subjectLikedDTO.getId(), "主键不能为空");
            Preconditions.checkNotNull(subjectLikedDTO.getSubjectId(), "题目id不能为空");
            Preconditions.checkNotNull(subjectLikedDTO.getLikeUserId(), "点赞人id不能为空");
            Preconditions.checkNotNull(subjectLikedDTO.getStatus(), "点赞状态 1点赞 0不点赞不能为空");
            Preconditions.checkNotNull(subjectLikedDTO.getCreatedBy(), "创建人不能为空");
            Preconditions.checkNotNull(subjectLikedDTO.getCreatedTime(), "创建时间不能为空");
            Preconditions.checkNotNull(subjectLikedDTO.getUpdateBy(), "修改人不能为空");
            Preconditions.checkNotNull(subjectLikedDTO.getUpdateTime(), "修改时间不能为空");
            Preconditions.checkNotNull(subjectLikedDTO.getIsDeleted(), "不能为空");
            SubjectLikedBO subjectLikedBO = SubjectLikedDTOConverter.INSTANCE.convertDTOToBO(subjectLikedDTO);
            return Result.ok(subjectLikedDomainService.update(subjectLikedBO));
        } catch (Exception e) {
            log.error("SubjectLikedController.update.error:{}", e.getMessage(), e);
            return Result.fail("更新题目点赞表信息失败");
        }

    }

    /**
     * 删除题目点赞表
     */
    @RequestMapping("delete")
    public Result<Boolean> delete(@RequestBody SubjectLikedDTO subjectLikedDTO) {

        try {
            if (log.isInfoEnabled()) {
                log.info("SubjectLikedController.delete.dto:{}", JSON.toJSONString(subjectLikedDTO));
            }
            Preconditions.checkNotNull(subjectLikedDTO.getId(), "主键不能为空");
            Preconditions.checkNotNull(subjectLikedDTO.getSubjectId(), "题目id不能为空");
            Preconditions.checkNotNull(subjectLikedDTO.getLikeUserId(), "点赞人id不能为空");
            Preconditions.checkNotNull(subjectLikedDTO.getStatus(), "点赞状态 1点赞 0不点赞不能为空");
            Preconditions.checkNotNull(subjectLikedDTO.getCreatedBy(), "创建人不能为空");
            Preconditions.checkNotNull(subjectLikedDTO.getCreatedTime(), "创建时间不能为空");
            Preconditions.checkNotNull(subjectLikedDTO.getUpdateBy(), "修改人不能为空");
            Preconditions.checkNotNull(subjectLikedDTO.getUpdateTime(), "修改时间不能为空");
            Preconditions.checkNotNull(subjectLikedDTO.getIsDeleted(), "不能为空");
            SubjectLikedBO subjectLikedBO = SubjectLikedDTOConverter.INSTANCE.convertDTOToBO(subjectLikedDTO);
            return Result.ok(subjectLikedDomainService.delete(subjectLikedBO));
        } catch (Exception e) {
            log.error("SubjectLikedController.delete.error:{}", e.getMessage(), e);
            return Result.fail("删除题目点赞表信息失败");
        }

    }

}

