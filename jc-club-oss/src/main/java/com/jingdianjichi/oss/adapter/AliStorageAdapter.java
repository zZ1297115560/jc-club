/**
 * @projectName jc-club
 * @package com.jingdianjichi.oss.service.impl
 * @className com.jingdianjichi.oss.service.impl.MinioStorageServiceImpl
 * @copyright Copyright 2020 Thunisoft, Inc All rights reserved.
 */
package com.jingdianjichi.oss.adapter;

import com.jingdianjichi.oss.entity.FileInfo;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * AliStorageServiceImpl
 * @author zxf
 * @date 2024/6/27 14:57
 * @version 1.0
 */
public class AliStorageAdapter implements StorageAdapter {
    @Override
    public void createBucket(String bucketName) {
        System.out.println("Ali create bucket");
    }

    @Override
    public void uploadFile(MultipartFile uploadFile, String bucketName, String objectName) {

    }

    @Override
    public List<String> getAllBucketName() {
        List<String> list = new ArrayList<>();
        list.add("ali");
        return list;
    }

    @Override
    public List<FileInfo> getAllFile(String bucketName) {
        return null;
    }

    @Override
    public InputStream downloadFile(String bucketName, String objectName) {
        return null;
    }

    @Override
    public void deleteBucket(String bucketName) {

    }

    @Override
    public void deleteFile(String bucketName, String objectName) {

    }
}

