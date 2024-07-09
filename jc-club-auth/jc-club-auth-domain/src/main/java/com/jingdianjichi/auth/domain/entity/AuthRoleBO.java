/**
 * @projectName jc-club
 * @package com.jingdianjichi.auth.domain.entity
 * @className com.jingdianjichi.auth.domain.entity.AuthRoleBO
 * @copyright Copyright 2020 Thunisoft, Inc All rights reserved.
 */
package com.jingdianjichi.auth.domain.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * AuthRoleBO
 * @author zxf
 * @date 2024/7/2 15:27
 * @version 1.0
 */
@Data
public class AuthRoleBO implements Serializable {

    private Long id;

    private String roleName;

    private String roleKey;

}


