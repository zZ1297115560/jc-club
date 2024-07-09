/**
 * @projectName jc-club
 * @package com.jingdianjichi.auth.application.dto
 * @className com.jingdianjichi.auth.application.dto.AuthRoleDTO
 * @copyright Copyright 2020 Thunisoft, Inc All rights reserved.
 */
package com.jingdianjichi.auth.application.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * AuthRoleDTO
 * @author zxf
 * @date 2024/7/2 15:28
 * @version 1.0
 */
@Data
public class AuthRoleDTO implements Serializable {

    private Long id;

    private String roleName;

    private String roleKey;

}


