/**
 * @projectName jc-club
 * @package com.jingdianjichi.oss.config
 * @className com.jingdianjichi.oss.config.StorageConfig
 * @copyright Copyright 2020 Thunisoft, Inc All rights reserved.
 */
package com.jingdianjichi.oss.config;

import com.jingdianjichi.oss.adapter.AliStorageAdapter;
import com.jingdianjichi.oss.adapter.MinioStorageAdapter;
import com.jingdianjichi.oss.adapter.StorageAdapter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * StorageConfig
 * @author zxf
 * @date 2024/6/27 15:45
 * @version 1.0
 */
@Configuration
@RefreshScope
@EnableAutoConfiguration
public class StorageConfig {

    @Value("${storage.service.type}")
    private String storageType;

    @Bean
    @RefreshScope
    public StorageAdapter storageService() {
        if ("minio".equals(storageType)) {
            return new MinioStorageAdapter();
        } else if ("aliyun".equals(storageType)) {
            return new AliStorageAdapter();
        } else {
            throw new IllegalArgumentException("未找到对应的文件存储处理器");
        }
    }

}


