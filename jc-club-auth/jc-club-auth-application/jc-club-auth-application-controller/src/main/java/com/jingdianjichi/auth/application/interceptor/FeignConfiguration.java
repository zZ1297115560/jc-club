/**
 * @projectName jc-club
 * @package com.jingdianjichi.auth.application.interceptor
 * @className com.jingdianjichi.auth.application.interceptor.FeignConfiguration
 * @copyright Copyright 2020 Thunisoft, Inc All rights reserved.
 */
package com.jingdianjichi.auth.application.interceptor;

import feign.RequestInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * FeignConfiguration
 * @author zxf
 * @date 2024/7/15 15:13
 * @version 1.0
 */
@Configuration
public class FeignConfiguration {

    @Bean
    public RequestInterceptor requestInterceptor(){
        return new FeignRequestInterceptor();
    }

}


