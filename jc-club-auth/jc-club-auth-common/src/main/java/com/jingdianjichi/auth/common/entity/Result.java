/**
 * @projectName jc-club
 * @package com.jingdianjichi.subject.common.entity
 * @className com.jingdianjichi.subject.common.entity.Result
 * @copyright Copyright 2020 Thunisoft, Inc All rights reserved.
 */
package com.jingdianjichi.auth.common.entity;

import com.jingdianjichi.auth.common.enums.ResultCodeEnum;
import lombok.Data;

/**
 * Result
 * @author zxf
 * @date 2024/6/10 23:44
 * @version 1.0
 */
@Data
public class Result <T> {

    private boolean success;

    private Integer code;

    private String message;

    private T data;

    public static <T> Result<T> ok() {
        return ok(null);
    }

    public static <T> Result<T> ok(T data) {
        Result<T> result = new Result<>();
        result.setSuccess(true);
        result.setCode(ResultCodeEnum.SUCCESS.getCode());
        result.setMessage(ResultCodeEnum.SUCCESS.getMessage());
        result.setData(data);
        return result;
    }

    public static <T> Result<T> fail() {
        return fail(ResultCodeEnum.FAIL.getMessage());
    }

    public static <T> Result<T> fail(String message) {
        Result<T> result = new Result<>();
        result.setSuccess(false);
        result.setCode(ResultCodeEnum.FAIL.getCode());
        result.setMessage(message);
        return result;
    }

}

