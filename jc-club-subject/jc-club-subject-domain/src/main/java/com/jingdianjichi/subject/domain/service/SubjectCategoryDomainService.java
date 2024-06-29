/**
 * @projectName jc-club
 * @package com.jingdianjichi.subject.domain.service
 * @className com.jingdianjichi.subject.domain.service.SubjectCategoryDomainService
 * @copyright Copyright 2020 Thunisoft, Inc All rights reserved.
 */
package com.jingdianjichi.subject.domain.service;

import com.jingdianjichi.subject.domain.entity.SubjectCategoryBO;

import java.util.List;

/**
 * SubjectCategoryDomainService
 * @author zxf
 * @date 2024/6/10 21:42
 * @version 1.0
 */
public interface SubjectCategoryDomainService {

    void add(SubjectCategoryBO subjectCategoryBO);

    /**
     * 查询岗位大类
     * @param subjectCategoryBO 查询条件
     * @return
     */
    List<SubjectCategoryBO> queryCategory(SubjectCategoryBO subjectCategoryBO);

    /**
     * 更新分类
     * @param subjectCategoryBO 分类信息
     * @return
     */
    Boolean update(SubjectCategoryBO subjectCategoryBO);

    /**
     * 删除分类
     * @param subjectCategoryBO 分类信息
     * @return
     */
    Boolean delete(SubjectCategoryBO subjectCategoryBO);

}

