/**
 * @projectName jc-club
 * @package com.jingdianjichi.subject.application.controller
 * @className com.jingdianjichi.subject.application.controller.TestFeignController
 * @copyright Copyright 2020 Thunisoft, Inc All rights reserved.
 */
package com.jingdianjichi.subject.application.controller;

import com.jingdianjichi.subject.infra.basic.entity.UserInfo;
import com.jingdianjichi.subject.infra.basic.service.SubjectEsService;
import com.jingdianjichi.subject.infra.rpc.UserRpc;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * TestFeignController
 * @author zxf
 * @date 2024/7/15 15:06
 * @version 1.0
 */
@RestController
@RequestMapping("/subject/category")
@Slf4j
public class TestFeignController {

    @Resource
    private UserRpc userRpc;
    @Resource
    private SubjectEsService subjectEsService;

    @GetMapping("testFeign")
    public void testFeign() {
        UserInfo userInfo = userRpc.getUserInfo("jichi");
        log.info("testFeign.userInfo:{}", userInfo);
    }

    @GetMapping("testCreateIndex")
    public void testCreateIndex() {
        subjectEsService.createIndex();
    }

    @GetMapping("addDocs")
    public void addDocs() {
        subjectEsService.addDoc();
    }

    @GetMapping("find")
    public void find() {
        subjectEsService.find();
    }

    @GetMapping("search")
    public void search() {
        subjectEsService.search();
    }

}

