/**
 * @projectName jc-club
 * @package com.jingdianjichi.auth.domain.entity
 * @className com.jingdianjichi.auth.domain.entity.AuthPermissionBO
 * @copyright Copyright 2020 Thunisoft, Inc All rights reserved.
 */
package com.jingdianjichi.auth.domain.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * AuthPermissionBO
 * @author zxf
 * @date 2024/7/9 11:23
 * @version 1.0
 */
@Data
public class AuthPermissionBO implements Serializable {

    private Long id;

    private String name;

    private Long parentId;

    private Integer type;

    private String menuUrl;

    private Integer status;

    private Integer show;

    private String icon;

    private String permissionKey;
}


