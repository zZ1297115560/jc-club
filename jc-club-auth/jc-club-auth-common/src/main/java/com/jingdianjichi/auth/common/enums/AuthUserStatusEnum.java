/**
 * @projectName jc-club
 * @package com.jingdianjichi.auth.common.enums
 * @className com.jingdianjichi.auth.common.enums.AuthUserStatusEnum
 * @copyright Copyright 2020 Thunisoft, Inc All rights reserved.
 */
package com.jingdianjichi.auth.common.enums;

import lombok.Getter;

/**
 * AuthUserStatusEnum
 * @author zxf
 * @date 2024/7/2 10:46
 * @version 1.0
 */
@Getter
public enum AuthUserStatusEnum {

    OPEN(0,"启用"),
    CLOSE(1,"禁用");

    public int code;

    public String desc;

    AuthUserStatusEnum(int code, String desc){
        this.code = code;
        this.desc = desc;
    }

    public static AuthUserStatusEnum getByCode(int codeVal){
        for(AuthUserStatusEnum resultCodeEnum : AuthUserStatusEnum.values()){
            if(resultCodeEnum.code == codeVal){
                return resultCodeEnum;
            }
        }
        return null;
    }

}

