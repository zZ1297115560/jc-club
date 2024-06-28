/**
 * @projectName jc-club
 * @package com.jingdianjichi.subject
 * @className com.jingdianjichi.subject.SubjectApplication
 * @copyright Copyright 2020 Thunisoft, Inc All rights reserved.
 */
package com.jingdianjichi.oss;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * minio , oss 启动类
 * @author zxf
 * @date 2024/6/27 13:05
 * @version 1.0
 */
@SpringBootApplication
@ComponentScan("com.jingdianjichi")
public class OssApplication {
    public static void main(String[] args) {
        SpringApplication.run(OssApplication.class, args);
    }
}

