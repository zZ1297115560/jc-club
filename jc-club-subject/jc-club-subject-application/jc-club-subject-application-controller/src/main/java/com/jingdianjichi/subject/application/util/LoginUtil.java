/**
 * @projectName jc-club
 * @package com.jingdianjichi.subject.application.util
 * @className com.jingdianjichi.subject.application.util.LoginUtil
 * @copyright Copyright 2020 Thunisoft, Inc All rights reserved.
 */
package com.jingdianjichi.subject.application.util;

import com.jingdianjichi.subject.application.context.LoginContextHolder;

/**
 * LoginUtil
 * @author zxf
 * @date 2024/7/15 14:56
 * @version 1.0
 */
public class LoginUtil {
    public static String getLoginId() {
        return LoginContextHolder.getLoginId();
    }
}


