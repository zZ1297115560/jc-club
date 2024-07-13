/**
 * @projectName jc-club
 * @package com.jingdianjichi.oss.util
 * @className com.jingdianjichi.oss.util.MinioUtil
 * @copyright Copyright 2020 Thunisoft, Inc All rights reserved.
 */
package com.jingdianjichi.oss.util;

import com.jingdianjichi.oss.entity.FileInfo;
import io.minio.*;
import io.minio.http.Method;
import io.minio.messages.Bucket;
import io.minio.messages.Item;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Minio工具类，提供了一系列方法来管理和操作Minio存储服务。
 * 包括创建和删除桶（Bucket），上传和下载文件，以及列出所有桶和文件等功能。
 * 这个类使用Spring框架的@Resource注解自动注入MinioClient对象。
 * 所有操作都具有异常处理，以抛出运行时异常的形式反馈操作失败的信息。
 *
 * @author zxf
 * @date 2024/6/27 13:17
 * @version 1.0
 */
@Component
public class MinioUtil {
    @Resource
    private MinioClient minioClient;

    /**
     * 创建一个新的存储桶（Bucket），如果它不存在。
     *
     * @param bucketName 存储桶的名称
     */
    public void createBucket(String bucketName){
        boolean exists;
        try {
            exists = minioClient.bucketExists(BucketExistsArgs.builder().bucket(bucketName).build());
            if (!exists){
                minioClient.makeBucket(MakeBucketArgs.builder().bucket(bucketName).build());
            }
        } catch (Exception e) {
            throw new RuntimeException("创建bucket失败", e);
        }
    }

    /**
     * 上传文件到指定的存储桶中。
     *
     * @param inputStream 文件的输入流
     * @param bucketName 存储桶的名称
     * @param objectName 对象名称，即文件的目标存储名称
     */
    public void uploadFile(InputStream inputStream,String bucketName, String objectName){
        try {
            minioClient.putObject(PutObjectArgs
                    .builder()
                    .bucket(bucketName)
                    .object(objectName)
                    .stream(inputStream,-1,5242889L)
                    .build());
        } catch (Exception e) {
            throw new RuntimeException("上传文件失败", e);
        }
    }

    /**
     * 获取所有存储桶的名称。
     *
     * @return 存储桶名称列表
     */
    public List<String> getAllBucketName(){
        try {
            return minioClient.listBuckets().stream().map(Bucket::name).collect(Collectors.toList());
        } catch (Exception e) {
            throw new RuntimeException("获取所有bucket名称失败", e);
        }
    }

    /**
     * 列出指定存储桶中的所有文件信息。
     *
     * @param bucketName 存储桶的名称
     * @return 文件信息列表
     * @throws Exception 抛出所有可能的异常
     */
    public List<FileInfo> getAllFile(String bucketName) throws Exception{

        Iterable<Result<Item>> results = minioClient.listObjects(
                ListObjectsArgs.builder().bucket(bucketName).build());
        List<FileInfo> fileInfoList = new ArrayList<>();
        for (Result<Item> result : results) {
            FileInfo fileInfo = new FileInfo();

            Item item = result.get();
            fileInfo.setFileName(item.objectName());
            fileInfo.setDirectoryFlag(item.isDir());
            fileInfo.setEtag(item.etag());
            fileInfoList.add(fileInfo);
        }

        return fileInfoList;
    }

    /**
     * 下载指定存储桶中的文件。
     *
     * @param bucketName 存储桶的名称
     * @param objectName 文件的名称
     * @return 文件的输入流
     */
    public InputStream downloadFile(String bucketName, String objectName) {
        try {
            return minioClient.getObject(GetObjectArgs.builder().bucket(bucketName).object(objectName).build());
        } catch (Exception e) {
            throw new RuntimeException("下载文件失败", e);
        }
    }

    /**
     * 删除指定的存储桶。
     *
     * @param bucketName 存储桶的名称
     */
    public void deleteBucket(String bucketName) {
        try {
            minioClient.removeBucket(RemoveBucketArgs.builder().bucket(bucketName).build());
        } catch (Exception e) {
            throw new RuntimeException("删除bucket失败", e);
        }
    }

    /**
     * 删除存储桶中的指定文件。
     *
     * @param bucketName 存储桶的名称
     * @param objectName 文件的名称
     */
    public void deleteFile(String bucketName, String objectName) {
        try {
            minioClient.removeObject(RemoveObjectArgs.builder().bucket(bucketName).object(objectName).build());
        } catch (Exception e) {
            throw new RuntimeException("删除文件失败", e);
        }
    }

    /**
     * 获取文件url
     */
    public String getPreviewFileUrl(String bucketName, String objectName) throws Exception{
        GetPresignedObjectUrlArgs args = GetPresignedObjectUrlArgs.builder()
                .method(Method.GET)
                .bucket(bucketName).object(objectName).build();
        return minioClient.getPresignedObjectUrl(args);
    }

}

