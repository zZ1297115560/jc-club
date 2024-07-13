/**
 * @projectName jc-club
 * @package com.jingdianjichi.oss.service
 * @className com.jingdianjichi.oss.service.StorageService
 * @copyright Copyright 2020 Thunisoft, Inc All rights reserved.
 */
package com.jingdianjichi.oss.adapter;

import com.jingdianjichi.oss.entity.FileInfo;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.List;

/**
 * 文件存储适配器
 *
 * @author zxf
 * @version 1.0
 * @date 2024/6/27 14:54
 */
public interface StorageAdapter {


    /**
     * 创建一个新的存储桶（Bucket），如果它不存在。
     *
     * @param bucketName 存储桶的名称
     */
    void createBucket(String bucketName);

    /**
     * 上传文件到指定的存储桶中。
     *
     * @param uploadFile 文件的输入流
     * @param bucketName  存储桶的名称
     * @param objectName  对象名称，即文件的目标存储名称
     */
    void uploadFile(MultipartFile uploadFile,
                    String bucketName,
                    String objectName
                    );

    /**
     * 获取所有存储桶的名称。
     *
     * @return 存储桶名称列表
     */
    List<String> getAllBucketName();

    /**
     * 列出指定存储桶中的所有文件信息。
     *
     * @param bucketName 存储桶的名称
     * @return 文件信息列表
     * @throws Exception 抛出所有可能的异常
     */
    List<FileInfo> getAllFile(String bucketName);

    /**
     * 下载指定存储桶中的文件。
     *
     * @param bucketName 存储桶的名称
     * @param objectName 文件的名称
     * @return 文件的输入流
     */
    InputStream downloadFile(String bucketName, String objectName);

    /**
     * 删除指定的存储桶。
     *
     * @param bucketName 存储桶的名称
     */
    void deleteBucket(String bucketName);

    /**
     * 删除存储桶中的指定文件。
     *
     * @param bucketName 存储桶的名称
     * @param objectName 文件的名称
     */
    void deleteFile(String bucketName, String objectName);

    public String getUrl(String bucket, String objectName);
}



