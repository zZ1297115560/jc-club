/**
 * @projectName jc-club
 * @package com.jingdianjichi.oss.entity
 * @className com.jingdianjichi.oss.entity.ResultCodeEnum
 * @copyright Copyright 2020 Thunisoft, Inc All rights reserved.
 */
package com.jingdianjichi.oss.entity;

import lombok.Getter;

/**
 * ResultCodeEnum
 * @author zxf
 * @date 2024/7/13 20:07
 * @version 1.0
 */
@Getter
public enum ResultCodeEnum {

    SUCCESS(200,"成功"),
    FAIL(500,"失败");

    public int code;

    public String desc;

    ResultCodeEnum(int code,String desc){
        this.code = code;
        this.desc = desc;
    }

    public static ResultCodeEnum getByCode(int codeVal){
        for(ResultCodeEnum resultCodeEnum : ResultCodeEnum.values()){
            if(resultCodeEnum.code == codeVal){
                return resultCodeEnum;
            }
        }
        return null;
    }

}


