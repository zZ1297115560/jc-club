/**
 * @projectName jc-club
 * @package com.jingdianjichi.subject
 * @className com.jingdianjichi.subject.SubjectApplication
 * @copyright Copyright 2020 Thunisoft, Inc All rights reserved.
 */
package com.jingdianjichi.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * minio , oss 启动类
 * @author zxf
 * @date 2024/6/29 17:05
 * @version 1.0
 */
@SpringBootApplication
@ComponentScan("com.jingdianjichi")
public class GatewayApplication {
    public static void main(String[] args) {
        SpringApplication.run(GatewayApplication.class, args);
    }
}

