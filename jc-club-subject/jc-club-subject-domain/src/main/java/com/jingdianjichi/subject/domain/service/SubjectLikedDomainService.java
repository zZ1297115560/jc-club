/**
 * @projectName jc-club
 * @package com.jingdianjichi.subject.domain.service
 * @className com.jingdianjichi.subject.domain.service.SubjectLikedDomainService
 * @copyright Copyright 2020 Thunisoft, Inc All rights reserved.
 */
package com.jingdianjichi.subject.domain.service;

import com.jingdianjichi.subject.domain.entity.SubjectLikedBO;

/**
 * SubjectLikedDomainService
 * @author zxf
 * @date 2024/7/19 2:10
 * @version 1.0
 */
public interface SubjectLikedDomainService {

    /**
     * 添加 题目点赞表 信息
     */
    Boolean add(SubjectLikedBO subjectLikedBO);

    /**
     * 更新 题目点赞表 信息
     */
    Boolean update(SubjectLikedBO subjectLikedBO);

    /**
     * 删除 题目点赞表 信息
     */
    Boolean delete(SubjectLikedBO subjectLikedBO);

}

