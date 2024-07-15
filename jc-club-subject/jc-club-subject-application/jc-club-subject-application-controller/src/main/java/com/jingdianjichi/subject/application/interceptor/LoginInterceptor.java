/**
 * @projectName jc-club
 * @package com.jingdianjichi.subject.application.interceptor
 * @className com.jingdianjichi.subject.application.interceptor.LoginInterceptor
 * @copyright Copyright 2020 Thunisoft, Inc All rights reserved.
 */
package com.jingdianjichi.subject.application.interceptor;

import com.jingdianjichi.subject.application.context.LoginContextHolder;
import org.springframework.lang.Nullable;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * LoginInterceptor
 * @author zxf
 * @date 2024/7/15 14:55
 * @version 1.0
 */
public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String loginId = request.getHeader("loginId");
        LoginContextHolder.set("loginId", loginId);
        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) throws Exception {
        LoginContextHolder.remove();
    }

}


