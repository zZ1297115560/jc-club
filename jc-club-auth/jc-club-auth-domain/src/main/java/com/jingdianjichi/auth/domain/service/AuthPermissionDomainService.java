/**
 * @projectName jc-club
 * @package com.jingdianjichi.auth.domain.service
 * @className com.jingdianjichi.auth.domain.service.AuthPermissionDomainService
 * @copyright Copyright 2020 Thunisoft, Inc All rights reserved.
 */
package com.jingdianjichi.auth.domain.service;

import com.jingdianjichi.auth.domain.entity.AuthPermissionBO;

import java.util.List;

/**
 * AuthPermissionDomainService
 * @author zxf
 * @date 2024/7/9 11:25
 * @version 1.0
 */
public interface AuthPermissionDomainService {

    Boolean add(AuthPermissionBO authPermissionBO);

    Boolean update(AuthPermissionBO authPermissionBO);

    Boolean delete(AuthPermissionBO authPermissionBO);

    List<String> getPermission(String userName);
}
