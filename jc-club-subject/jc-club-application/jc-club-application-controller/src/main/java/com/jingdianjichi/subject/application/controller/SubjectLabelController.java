/**
 * @projectName jc-club
 * @package com.jingdianjichi.subject.application.controller
 * @className com.jingdianjichi.subject.application.controller.SubjectLabelController
 * @copyright Copyright 2020 Thunisoft, Inc All rights reserved.
 */
package com.jingdianjichi.subject.application.controller;

import com.alibaba.fastjson.JSON;
import com.google.common.base.Preconditions;
import com.jingdianjichi.subject.application.convert.SubjectLabelDTOConverter;
import com.jingdianjichi.subject.application.dto.SubjectLabelDTO;
import com.jingdianjichi.subject.common.entity.Result;
import com.jingdianjichi.subject.domain.entity.SubjectLabelBO;
import com.jingdianjichi.subject.domain.service.SubjectLabelDomainService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * SubjectLabelController
 * @author zxf
 * @date 2024/6/23 8:29
 * @version 1.0
 */
@RestController
@RequestMapping("/subject/label")
@Slf4j
public class SubjectLabelController {

    @Resource
    private SubjectLabelDomainService subjectLabelDomainService;

    /**
     * 新增标签
     * @param subjectLabelDTO 标签信息
     * @return 返回 Result对象，包括操作的成功（true）或失败（false）状态。失败时Result包含错误消息。
     */
    @PostMapping("/add")
    public Result<Boolean> add(@RequestBody SubjectLabelDTO subjectLabelDTO){
        try {
            // 1. 输出日志：打印入参
            if (log.isInfoEnabled()){
                log.info("SubjectLabelController.add.subjectLabelDTO:{}", JSON.toJSONString(subjectLabelDTO));
            }
            // 2. 校验参数: 标签名称不能为空
            Preconditions.checkNotNull(subjectLabelDTO.getLabelName(),"标签名称不能为空");

            // 3. 转换DTO为BO
            SubjectLabelBO subjectLabelBO = SubjectLabelDTOConverter.INSTANCE.convertDtoToLabelBo(subjectLabelDTO);

            // 4. 调用领域服务新增标签
            Boolean result = subjectLabelDomainService.add(subjectLabelBO);

            // 5. 返回结果
            return Result.ok(result);
        } catch (Exception e) {
            log.error("SubjectLabelController.add.error:{}",e.getMessage(),e);
            return Result.fail("新增标签失败");
        }
    }

    /**
     * 更新分类
     * @param subjectLabelDTO 更新条件
     * @return 返回 Result对象，包括操作的成功（true）或失败（false）状态。失败时Result包含错误消息。
     */
    @PostMapping("/update")
    public Result<Boolean> update(@RequestBody SubjectLabelDTO subjectLabelDTO){
        try {
            // 1. 输出日志：打印入参
            if (log.isInfoEnabled()) {
                log.info("SubjectLabelController.update.SubjectLabelDTO:{}",JSON.toJSONString(subjectLabelDTO));
            }

            // 2. 校验参数
            Preconditions.checkNotNull(subjectLabelDTO.getId(),"标签id不能为空");

            // 3. 转换DTO为BO
            SubjectLabelBO subjectLabelBO = SubjectLabelDTOConverter.INSTANCE.
                    convertDtoToLabelBo(subjectLabelDTO);

            // 4. 调用领域服务更新标签
            Boolean result = subjectLabelDomainService.update(subjectLabelBO);

            // 5. 返回结果
            return Result.ok(result);
        }catch (Exception e){
            log.error("SubjectLabelController.update.error:{}",e.getMessage(),e);
            return Result.fail("更新标签失败");
        }
    }

    /**
     * 删除标签
     * @param subjectLabelDTO 标签信息
     * @return 返回 Result对象，包括操作的成功（true）或失败（false）状态。失败时Result包含错误消息。
     */
    @PostMapping("/delete")
    public Result<Boolean> delete(@RequestBody SubjectLabelDTO subjectLabelDTO){
        try {
            // 1. 输出日志：打印入参
            if (log.isInfoEnabled()) {
                log.info("SubjectLabelController.delete.SubjectLabelDTO:{}",JSON.toJSONString(subjectLabelDTO));
            }

            // 2. 校验参数
            Preconditions.checkNotNull(subjectLabelDTO.getId(),"标签id不能为空");

            // 3. 转换DTO为BO
            SubjectLabelBO subjectLabelBO = SubjectLabelDTOConverter.INSTANCE.
                    convertDtoToLabelBo(subjectLabelDTO);

            // 4. 调用领域服务删除标签
            Boolean result = subjectLabelDomainService.delete(subjectLabelBO);

            // 5. 返回结果
            return Result.ok(result);
        }catch (Exception e){
            log.error("SubjectLabelController.update.error:{}",e.getMessage(),e);
            return Result.fail("更新标签失败");
        }
    }

    /**
     * 根据分类id查询标签
     * @param subjectLabelDTO 标签信息
     * @return 返回 Result对象，包括操作的成功（true）或失败（false）状态。失败时Result包含错误消息。
     */
    @PostMapping("/queryLabelByCategoryId")
    public Result<List<SubjectLabelDTO>> queryLabelByCategoryId(@RequestBody SubjectLabelDTO subjectLabelDTO){
        try {
            // 1. 输出日志：打印入参
            if (log.isInfoEnabled()) {
                log.info("SubjectLabelController.queryLabelByCategoryId.SubjectLabelDTO:{}",JSON.toJSONString(subjectLabelDTO));
            }

            // 2. 校验参数：分类id不能为空
            Preconditions.checkNotNull(subjectLabelDTO.getCategoryId(),"分类id不能为空");

            // 3. 转换DTO为BO
            SubjectLabelBO subjectLabelBO = SubjectLabelDTOConverter.INSTANCE.
                    convertDtoToLabelBo(subjectLabelDTO);

            // 4. 调用领域服务查询标签
            List<SubjectLabelBO> subjectLabelBOList = subjectLabelDomainService.queryLabelByCategoryId(subjectLabelBO);

            // 5. 转换BO为DTO
            List<SubjectLabelDTO> result = SubjectLabelDTOConverter.INSTANCE.convertBoToLabelDTO(subjectLabelBOList);

            // 6. 返回结果
            return Result.ok(result);
        }catch (Exception e){
            log.error("SubjectLabelController.queryLabelByCategoryId.error:{}",e.getMessage(),e);
            return Result.fail("根据分类id查询标签失败");
        }
    }
}

