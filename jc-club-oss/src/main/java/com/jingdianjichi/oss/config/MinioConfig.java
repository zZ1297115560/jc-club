/**
 * @projectName jc-club
 * @package com.jingdianjichi.oss.config
 * @className com.jingdianjichi.oss.config.MinioConfig
 * @copyright Copyright 2020 Thunisoft, Inc All rights reserved.
 */
package com.jingdianjichi.oss.config;

import io.minio.MinioClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Minio配置
 * @author zxf
 * @date 2024/6/27 13:11
 * @version 1.0
 */
@Configuration
public class MinioConfig {
    /**
     * Minio服务的URL，用于连接Minio服务器。
     * 配置项示例: minio.url=http://localhost:9000
     */
    @Value("${minio.url}")
    private String url;

    /**
     * 用于访问Minio服务的Access Key。
     * 类似于用户ID，用于标识访问账户。
     * 配置项示例: minio.accessKey=yourAccessKey
     */
    @Value("${minio.accessKey}")
    private String accessKey;

    /**
     * 用于访问Minio服务的Secret Key。
     * 用于验证用户的Access Key。
     * 配置项示例: minio.secretKey=yourSecretKey
     */
    @Value("${minio.secretKey}")
    private String secretKey;

    /**
     * 创建并返回一个配置好的MinioClient实例。
     * 使用类内部注入的URL、Access Key和Secret Key来构建Minio客户端。
     * 这个方法提供了一个现成的MinioClient，可以用来执行对Minio服务的各种操作，例如上传文件、下载文件等。
     *
     * @return MinioClient 返回配置好的MinioClient实例。
     */
    @Bean
    public MinioClient getMinioClient() {
        return MinioClient.builder()
                // Minio服务的URL
                .endpoint(url)
                // 使用Access Key和Secret Key进行身份验证
                .credentials(accessKey, secretKey)
                .build();
    }
}

