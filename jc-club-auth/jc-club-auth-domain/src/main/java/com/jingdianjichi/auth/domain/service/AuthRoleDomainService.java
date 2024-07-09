/**
 * @projectName jc-club
 * @package com.jingdianjichi.auth.domain.service
 * @className com.jingdianjichi.auth.domain.service.AuthRoleDomainService
 * @copyright Copyright 2020 Thunisoft, Inc All rights reserved.
 */
package com.jingdianjichi.auth.domain.service;

import com.jingdianjichi.auth.domain.entity.AuthRoleBO;

/**
 * AuthRoleDomainService
 * @author zxf
 * @date 2024/7/2 15:26
 * @version 1.0
 */
public interface AuthRoleDomainService {

    Boolean add(AuthRoleBO authRoleBO);

    Boolean update(AuthRoleBO authRoleBO);

    Boolean delete(AuthRoleBO authRoleBO);

}
