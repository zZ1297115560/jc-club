/**
 * @projectName jc-club
 * @package com.jingdianjichi.subject.common.enums
 * @className com.jingdianjichi.subject.common.enums.Result
 * @copyright Copyright 2020 Thunisoft, Inc All rights reserved.
 */
package com.jingdianjichi.subject.common.enums;

import lombok.Getter;

/**
 * Result
 * @author zxf
 * @date 2024/6/10 23:40
 * @version 1.0
 */
@Getter
public enum ResultCodeEnum{
    /**
     * 成功
     */
    SUCCESS(200, "成功"),
    /**
     * 失败
     */
    FAIL(500, "失败");

    private final int code;
    private final String message;

    ResultCodeEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public static ResultCodeEnum getByCode(int codeVal) {
        for (ResultCodeEnum resultCodeEnum : ResultCodeEnum.values()) {
            if (resultCodeEnum.code == codeVal) {
                return resultCodeEnum;
            }
        }
        return null;
    }

}