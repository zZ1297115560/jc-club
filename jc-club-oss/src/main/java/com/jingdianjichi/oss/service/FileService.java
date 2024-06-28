/**
 * @projectName jc-club
 * @package com.jingdianjichi.oss.service
 * @className com.jingdianjichi.oss.service.FileService
 * @copyright Copyright 2020 Thunisoft, Inc All rights reserved.
 */
package com.jingdianjichi.oss.service;

import com.jingdianjichi.oss.adapter.StorageAdapter;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * FileService
 * @author zxf
 * @date 2024/6/27 15:50
 * @version 1.0
 */
@Service
public class FileService {

    private final StorageAdapter storageAdapter;

    public FileService(StorageAdapter storageAdapter) {
        this.storageAdapter = storageAdapter;
    }

    /**
     * 列出所有桶
     */
    public List<String> getAllBucketName() {
        return storageAdapter.getAllBucketName();
    }

    public void createBucket(String bucketName) {
        storageAdapter.createBucket(bucketName);
    }

}


