/**
 * @projectName jc-club
 * @package com.jingdianjichi.subject.common.enums
 * @className com.jingdianjichi.subject.common.enums.Result
 * @copyright Copyright 2020 Thunisoft, Inc All rights reserved.
 */
package com.jingdianjichi.subject.common.enums;

import lombok.Getter;

/**
 * 分类类型枚举类
 * @author zxf
 * @date 2024/6/17 11:56:55
 * @version 1.0
 */
@Getter
public enum CategoryTypeEnum {
    /**
     * 岗位大类
     */
    PRIMARY(1, "岗位大类"),
    /**
     * 二级分类
     */
    SECOND(2, "二级分类");

    private final int code;
    private final String message;

    CategoryTypeEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public static CategoryTypeEnum getByCode(int codeVal) {
        for (CategoryTypeEnum resultCodeEnum : CategoryTypeEnum.values()) {
            if (resultCodeEnum.code == codeVal) {
                return resultCodeEnum;
            }
        }
        return null;
    }

}