/**
 * @projectName jc-club
 * @package com.jingdianjichi.auth.application.dto
 * @className com.jingdianjichi.auth.application.dto.AuthPermissionDTO
 * @copyright Copyright 2020 Thunisoft, Inc All rights reserved.
 */
package com.jingdianjichi.auth.application.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * AuthPermissionDTO
 * @author zxf
 * @date 2024/7/9 11:22
 * @version 1.0
 */
@Data
public class AuthPermissionDTO implements Serializable {

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



