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
public enum SubjectInfoTypeEnum {
    /**
     * 单选
     */
    RADIO(1, "单选"),
    /**
     * 多选
     */
    MULTIPLE(2, "多选"),
    /**
     * 判断
     */
    JUDGE(3, "判断"),
    /**
     * 简答
     */
    BRIEF(4, "简答");

    /**
     * 枚举值
     */
    private final int code;
    /**
     * 枚举描述
     */
    private final String message;

    SubjectInfoTypeEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public static SubjectInfoTypeEnum getByCode(int codeVal) {
        for (SubjectInfoTypeEnum resultCodeEnum : SubjectInfoTypeEnum.values()) {
            if (resultCodeEnum.code == codeVal) {
                return resultCodeEnum;
            }
        }
        return null;
    }

}