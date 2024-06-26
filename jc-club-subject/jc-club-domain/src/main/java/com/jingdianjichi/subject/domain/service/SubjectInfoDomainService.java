/**
 * @projectName jc-club
 * @package com.jingdianjichi.subject.domain.service
 * @className com.jingdianjichi.subject.domain.service.SubjectCategoryDomainService
 * @copyright Copyright 2020 Thunisoft, Inc All rights reserved.
 */
package com.jingdianjichi.subject.domain.service;

import com.jingdianjichi.subject.common.entity.PageResult;
import com.jingdianjichi.subject.domain.entity.SubjectInfoBO;


/**
 * 标签服务接口
 * @author zxf
 * @date 2024/6/10 21:42
 * @version 1.0
 */
public interface SubjectInfoDomainService {

    /**
     * 新增标签
     * @param subjectLabelBO 标签信息
     * @return 是否新增成功
     */
    Boolean add(SubjectInfoBO subjectInfoBO);

    /**
     * 分页查询题目
     * @param subjectInfoBO 题目信息BO
     * @return 题目信息分页
     */
    PageResult<SubjectInfoBO> getSubjectPage(SubjectInfoBO subjectInfoBO);

    /**
     * 查询题目信息
     * @param subjectInfoBO 题目信息BO
     * @return 题目信息
     */
    SubjectInfoBO querySubjectInfo(SubjectInfoBO subjectInfoBO);
}

