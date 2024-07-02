/**
 * @projectName jc-club
 * @package com.jingdianjichi.auth.domain.service.impl
 * @className com.jingdianjichi.auth.domain.service.impl.AuthUserDomainServiceImpl
 * @copyright Copyright 2020 Thunisoft, Inc All rights reserved.
 */
package com.jingdianjichi.auth.domain.service.impl;

import cn.dev33.satoken.secure.SaSecureUtil;
import com.jingdianjichi.auth.common.enums.AuthUserStatusEnum;
import com.jingdianjichi.auth.common.enums.IsDeletedFlagEnum;
import com.jingdianjichi.auth.domain.convert.AuthUserBOConverter;
import com.jingdianjichi.auth.domain.entity.AuthUserBO;
import com.jingdianjichi.auth.domain.service.AuthUserDomainService;
import com.jingdianjichi.auth.infra.basic.entity.AuthUser;
import com.jingdianjichi.auth.infra.basic.service.AuthUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * AuthUserDomainServiceImpl
 * @author zxf
 * @date 2024/7/2 10:44
 * @version 1.0
 */
@Service
@Slf4j
public class AuthUserDomainServiceImpl implements AuthUserDomainService {

    @Resource
    private AuthUserService authUserService;

    @Value("${rsa.publicKey}")
    private static String PUBLIC_KEY;

    @Override
    public Boolean register(AuthUserBO authUserBO) {

        AuthUser authUser = AuthUserBOConverter.INSTANCE.convertBOToEntity(authUserBO);
        authUser.setStatus(AuthUserStatusEnum.OPEN.getCode());
        authUser.setIsDeleted(IsDeletedFlagEnum.UN_DELETED.getCode());
        authUser.setPassword(SaSecureUtil.rsaEncryptByPublic(PUBLIC_KEY, authUser.getPassword()));
        Integer count = authUserService.insert(authUser);
        //建立一个初步的角色的关联
        //要把当前用户的角色和权限都刷到我们的redis里
        return count > 0;
    }

    @Override
    public Boolean update(AuthUserBO authUserBO) {
        AuthUser authUser = AuthUserBOConverter.INSTANCE.convertBOToEntity(authUserBO);
        Integer count = authUserService.update(authUser);
        //有任何的更新，都要与缓存进行同步的修改
        return count > 0;
    }

    @Override
    public Boolean delete(AuthUserBO authUserBO) {
        AuthUser authUser = new AuthUser();
        authUser.setId(authUserBO.getId());
        authUser.setIsDeleted(IsDeletedFlagEnum.DELETED.getCode());
        Integer count = authUserService.update(authUser);
        //有任何的更新，都要与缓存进行同步的修改
        return count > 0;
    }
}

