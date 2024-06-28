/**
 * @projectName jc-club
 * @package com.jingdianjichi.oss.controller
 * @className com.jingdianjichi.oss.controller.FileController
 * @copyright Copyright 2020 Thunisoft, Inc All rights reserved.
 */
package com.jingdianjichi.oss.controller;

import com.jingdianjichi.oss.service.FileService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * FileController
 * @author zxf
 * @date 2024/6/27 14:07
 * @version 1.0
 */
@RestController
@RequestMapping
public class FileController {

    @Resource
    private FileService fileService;

    @RequestMapping("/testGetAllBucketName")
    public String testGetAllBucketName(){
        return fileService.getAllBucketName().get(0);
    }

//    @RequestMapping("/testNacos")
//    public String testNacos(){
//        return storageType;
//    }

    @RequestMapping("/testCreateBucket")
    public String testCreateBucket(){
        String bucketName = "test";
        fileService.createBucket(bucketName);
        return "success";
    }
}

