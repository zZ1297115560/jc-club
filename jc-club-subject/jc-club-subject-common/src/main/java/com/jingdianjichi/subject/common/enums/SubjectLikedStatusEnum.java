/**
 * @projectName jc-club
 * @package com.jingdianjichi.subject.common.enums
 * @className com.jingdianjichi.subject.common.enums.SubjectLikedStatusEnum
 * @copyright Copyright 2020 Thunisoft, Inc All rights reserved.
 */
package com.jingdianjichi.subject.common.enums;

import lombok.Getter;

/**
 * SubjectLikedStatusEnum
 * @author zxf
 * @date 2024/7/19 2:16
 * @version 1.0
 */
@Getter
public enum SubjectLikedStatusEnum {

    LIKED(1, "点赞"),
    UN_LIKED(0, "取消点赞");

    public int code;

    public String desc;

    SubjectLikedStatusEnum(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public static SubjectLikedStatusEnum getByCode(int codeVal) {
        for (SubjectLikedStatusEnum resultCodeEnum : SubjectLikedStatusEnum.values()) {
            if (resultCodeEnum.code == codeVal) {
                return resultCodeEnum;
            }
        }
        return null;
    }

}


