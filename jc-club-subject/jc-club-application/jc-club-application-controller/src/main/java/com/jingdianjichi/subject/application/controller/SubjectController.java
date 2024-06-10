/**
 * @projectName jc-club
 * @package com.jingdianjichi.subject.application.controller
 * @className com.jingdianjichi.subject.application.controller.SubjectController
 * @copyright Copyright 2020 Thunisoft, Inc All rights reserved.
 */
package com.jingdianjichi.subject.application.controller;

import com.jingdianjichi.subject.infra.basic.entity.SubjectCategory;
import com.jingdianjichi.subject.infra.basic.mapper.SubjectCategoryDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * SubjectController
 * @author zxf
 * @date 2024/6/10 16:01
 * @version 1.0
 */
@RestController
public class SubjectController {

    @Resource
    private SubjectCategoryDao subjectCategoryDao;

    @GetMapping("/test")
    public String test(){
        SubjectCategory category = subjectCategoryDao.queryById(1L);

        return category.getCategoryName();
    }
}

