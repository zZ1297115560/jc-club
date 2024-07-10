/**
 * @projectName jc-club
 * @package com.jingdianjichi.auth.domain.entity
 * @className com.jingdianjichi.auth.domain.entity.AuthRolePermissionBO
 * @copyright Copyright 2020 Thunisoft, Inc All rights reserved.
 */
package com.jingdianjichi.auth.domain.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * (AuthRolePermission)BO
 * @author zxf
 * @date 2024/7/9 20:08
 * @version 1.0
 */
@Data
public class AuthRolePermissionBO implements Serializable {
    private static final long serialVersionUID = 459343371709166261L;

    private Long id;

    private Long roleId;

    private Long permissionId;

    private List<Long> permissionIdList;
}

