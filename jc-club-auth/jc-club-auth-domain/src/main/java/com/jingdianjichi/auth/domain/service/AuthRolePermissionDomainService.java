/**
 * @projectName jc-club
 * @package com.jingdianjichi.auth.domain.service
 * @className com.jingdianjichi.auth.domain.service.AuthRolePermissionDomainService
 * @copyright Copyright 2020 Thunisoft, Inc All rights reserved.
 */
package com.jingdianjichi.auth.domain.service;

import com.jingdianjichi.auth.domain.entity.AuthRolePermissionBO;

/**
 * 角色领域service
 * @author zxf
 * @date 2024/7/9 20:07
 * @version 1.0
 */
public interface AuthRolePermissionDomainService {

    Boolean add(AuthRolePermissionBO authRolePermissionBO);

}
