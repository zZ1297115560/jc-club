/**
 * @projectName jc-club
 * @package com.jingdianjichi.subject.common.enums
 * @className com.jingdianjichi.subject.common.enums.Result
 * @copyright Copyright 2020 Thunisoft, Inc All rights reserved.
 */
package com.jingdianjichi.auth.common.enums;

import lombok.Getter;

/**
 * 删除状态枚举类
 * @author zxf
 * @date 2024/6/17 11:56:55
 * @version 1.0
 */
@Getter
public enum IsDeletedFlagEnum {
    /**
     * 已删除
     */
    DELETED(1, "已删除"),
    /**
     * 未删除
     */
    UN_DELETED(0, "未删除");

    private final int code;
    private final String message;

    IsDeletedFlagEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public static IsDeletedFlagEnum getByCode(int codeVal) {
        for (IsDeletedFlagEnum resultCodeEnum : IsDeletedFlagEnum.values()) {
            if (resultCodeEnum.code == codeVal) {
                return resultCodeEnum;
            }
        }
        return null;
    }

}