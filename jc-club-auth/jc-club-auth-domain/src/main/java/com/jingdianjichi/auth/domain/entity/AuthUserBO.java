/**
 * @projectName jc-club
 * @package com.jingdianjichi.auth.domain.entity
 * @className com.jingdianjichi.auth.domain.entity.AuthUserBO
 * @copyright Copyright 2020 Thunisoft, Inc All rights reserved.
 */
package com.jingdianjichi.auth.domain.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * AuthUserBO
 * @author zxf
 * @date 2024/7/2 10:39
 * @version 1.0
 */
@Data
public class AuthUserBO implements Serializable {

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



