/**
 * @projectName jc-club
 * @package com.jingdianjichi.auth.application.dto
 * @className com.jingdianjichi.auth.application.dto.AuthRolePermissionDTO
 * @copyright Copyright 2020 Thunisoft, Inc All rights reserved.
 */
package com.jingdianjichi.auth.application.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * AuthRolePermissionDTO
 * @author zxf
 * @date 2024/7/9 20:09
 * @version 1.0
 */
@Data
public class AuthRolePermissionDTO implements Serializable {
    private static final long serialVersionUID = 459343371709166261L;

    private Long id;

    private Long roleId;

    private Long permissionId;

    private List<Long> permissionIdList;
}


