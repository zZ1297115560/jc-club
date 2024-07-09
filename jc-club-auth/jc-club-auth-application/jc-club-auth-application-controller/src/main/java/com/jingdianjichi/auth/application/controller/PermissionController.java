/**
 * @projectName jc-club
 * @package com.jingdianjichi.auth.application.controller
 * @className com.jingdianjichi.auth.application.controller.PermissionController
 * @copyright Copyright 2020 Thunisoft, Inc All rights reserved.
 */
package com.jingdianjichi.auth.application.controller;

import com.alibaba.fastjson.JSON;
import com.google.common.base.Preconditions;
import com.jingdianjichi.auth.application.convert.AuthPermissionDTOConverter;
import com.jingdianjichi.auth.application.dto.AuthPermissionDTO;
import com.jingdianjichi.auth.common.entity.Result;
import com.jingdianjichi.auth.domain.entity.AuthPermissionBO;
import com.jingdianjichi.auth.domain.service.AuthPermissionDomainService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 权限controller
 * @author zxf
 * @date 2024/7/9 11:21
 * @version 1.0
 */
@RestController
@RequestMapping("/permission/")
@Slf4j
public class PermissionController {

    @Resource
    private AuthPermissionDomainService authPermissionDomainService;

    /**
     * 新增权限
     */
    @RequestMapping("add")
    public Result<Boolean> add(@RequestBody AuthPermissionDTO authPermissionDTO) {
        try {
            if (log.isInfoEnabled()) {
                log.info("PermissionController.add.dto:{}", JSON.toJSONString(authPermissionDTO));
            }
            Preconditions.checkArgument(!StringUtils.isBlank(authPermissionDTO.getName()), "权限名称不能为空");
            Preconditions.checkNotNull(authPermissionDTO.getParentId(), "权限父id不能为空");
            AuthPermissionBO permissionBO = AuthPermissionDTOConverter.INSTANCE.convertDTOToBO(authPermissionDTO);
            return Result.ok(authPermissionDomainService.add(permissionBO));
        } catch (Exception e) {
            log.error("PermissionController.add.error:{}", e.getMessage(), e);
            return Result.fail("新增权限失败");
        }
    }

    /**
     * 修改权限
     */
    @RequestMapping("update")
    public Result<Boolean> update(@RequestBody AuthPermissionDTO authPermissionDTO) {
        try {
            if (log.isInfoEnabled()) {
                log.info("PermissionController.update.dto:{}", JSON.toJSONString(authPermissionDTO));
            }
            Preconditions.checkNotNull(authPermissionDTO.getId(), "权限id不能为空");
            AuthPermissionBO permissionBO = AuthPermissionDTOConverter.INSTANCE.convertDTOToBO(authPermissionDTO);
            return Result.ok(authPermissionDomainService.update(permissionBO));
        } catch (Exception e) {
            log.error("PermissionController.update.error:{}", e.getMessage(), e);
            return Result.fail("更新权限信息失败");
        }
    }

    /**
     * 删除权限
     */
    @RequestMapping("delete")
    public Result<Boolean> delete(@RequestBody AuthPermissionDTO authPermissionDTO) {
        try {
            if (log.isInfoEnabled()) {
                log.info("PermissionController.delete.dto:{}", JSON.toJSONString(authPermissionDTO));
            }
            Preconditions.checkNotNull(authPermissionDTO.getId(), "权限id不能为空");
            AuthPermissionBO permissionBO = AuthPermissionDTOConverter.INSTANCE.convertDTOToBO(authPermissionDTO);
            return Result.ok(authPermissionDomainService.delete(permissionBO));
        } catch (Exception e) {
            log.error("PermissionController.delete.error:{}", e.getMessage(), e);
            return Result.fail("删除权限信息失败");
        }
    }

}


