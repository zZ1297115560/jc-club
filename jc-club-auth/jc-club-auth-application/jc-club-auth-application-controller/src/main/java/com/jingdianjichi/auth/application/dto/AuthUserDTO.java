/**
 * @projectName jc-club
 * @package com.jingdianjichi.auth.application.dto
 * @className com.jingdianjichi.auth.application.dto.AuthUserDTO
 * @copyright Copyright 2020 Thunisoft, Inc All rights reserved.
 */
package com.jingdianjichi.auth.application.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * AuthUserDTO
 * @author zxf
 * @date 2024/7/2 10:37
 * @version 1.0
 */
@Data
public class AuthUserDTO implements Serializable {

    private Long id;

    private String userName;

    private String nickName;

    private String email;

    private String phone;

    private String password;

    private Integer sex;

    private String avatar;

    private Integer status;

    private String introduce;

    private String extJson;

}



