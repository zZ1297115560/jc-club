/**
 * @projectName jc-club
 * @package com.jingdianjichi.auth.domain.service.impl
 * @className com.jingdianjichi.auth.domain.service.impl.AuthRoleDomainServiceImpl
 * @copyright Copyright 2020 Thunisoft, Inc All rights reserved.
 */
package com.jingdianjichi.auth.domain.service.impl;

import com.jingdianjichi.auth.common.enums.IsDeletedFlagEnum;
import com.jingdianjichi.auth.domain.convert.AuthRoleBOConverter;
import com.jingdianjichi.auth.domain.entity.AuthRoleBO;
import com.jingdianjichi.auth.domain.service.AuthRoleDomainService;
import com.jingdianjichi.auth.infra.basic.entity.AuthRole;
import com.jingdianjichi.auth.infra.basic.service.AuthRoleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * AuthRoleDomainServiceImpl
 * @author zxf
 * @date 2024/7/2 15:27
 * @version 1.0
 */
@Service
@Slf4j
public class AuthRoleDomainServiceImpl implements AuthRoleDomainService {

    @Resource
    private AuthRoleService authRoleService;

    @Override
    public Boolean add(AuthRoleBO authRoleBO) {
        AuthRole authRole = AuthRoleBOConverter.INSTANCE.convertBOToEntity(authRoleBO);
        authRole.setIsDeleted(IsDeletedFlagEnum.UN_DELETED.getCode());
        Integer count = authRoleService.insert(authRole);
        return count > 0;
    }

    @Override
    public Boolean update(AuthRoleBO authRoleBO) {
        AuthRole authRole = AuthRoleBOConverter.INSTANCE.convertBOToEntity(authRoleBO);
        Integer count = authRoleService.update(authRole);
        return count > 0;
    }

    @Override
    public Boolean delete(AuthRoleBO authRoleBO) {
        AuthRole authRole = new AuthRole();
        authRole.setId(authRoleBO.getId());
        authRole.setIsDeleted(IsDeletedFlagEnum.DELETED.getCode());
        Integer count = authRoleService.update(authRole);
        return count > 0;
    }

}


