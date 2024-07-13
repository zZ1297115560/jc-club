/**
 * @projectName jc-club
 * @package com.jingdianjichi.auth.domain.service
 * @className com.jingdianjichi.auth.domain.service.AuthUserDomainService
 * @copyright Copyright 2020 Thunisoft, Inc All rights reserved.
 */
package com.jingdianjichi.auth.domain.service;

import cn.dev33.satoken.stp.SaTokenInfo;
import com.jingdianjichi.auth.domain.entity.AuthUserBO;

/**
 * AuthUserDomainService
 * @author zxf
 * @date 2024/7/2 10:42
 * @version 1.0
 */
public interface AuthUserDomainService {

    /**
     * 注册
     */
    Boolean register(AuthUserBO authUserBO);
    /**
     * 更新用户信息
     */
    Boolean update(AuthUserBO authUserBO);

    /**
     * 更新用户信息
     */
    Boolean delete(AuthUserBO authUserBO);

    SaTokenInfo doLogin(String validCode);

    AuthUserBO getUserInfo(AuthUserBO authUserBO);
}

