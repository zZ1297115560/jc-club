/**
 * @projectName jc-club
 * @package com.jingdianjichi.subject.infra.config
 * @className com.jingdianjichi.subject.infra.config.MybatisConfiguration
 * @copyright Copyright 2020 Thunisoft, Inc All rights reserved.
 */
package com.jingdianjichi.subject.infra.config;

import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * MybatisConfiguration
 * @author zxf
 * @date 2024/6/26 13:37
 * @version 1.0
 */
@Configuration
public class MybatisConfiguration {

    @Bean
    public MybatisPlusInterceptor mybatisPlusInterceptor(){
        MybatisPlusInterceptor mybatisPlusInterceptor = new MybatisPlusInterceptor();
        mybatisPlusInterceptor.addInnerInterceptor(new MybatisPlusAllSqlLog());
        return mybatisPlusInterceptor;
    }

}


