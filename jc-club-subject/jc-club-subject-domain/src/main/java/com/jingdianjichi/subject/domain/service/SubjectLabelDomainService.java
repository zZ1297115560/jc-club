/**
 * @projectName jc-club
 * @package com.jingdianjichi.subject.domain.service
 * @className com.jingdianjichi.subject.domain.service.SubjectCategoryDomainService
 * @copyright Copyright 2020 Thunisoft, Inc All rights reserved.
 */
package com.jingdianjichi.subject.domain.service;

import com.jingdianjichi.subject.domain.entity.SubjectLabelBO;

import java.util.List;


/**
 * 标签服务接口
 * @author zxf
 * @date 2024/6/10 21:42
 * @version 1.0
 */
public interface SubjectLabelDomainService {

    /**
     * 新增标签
     * @param subjectLabelBO 标签信息
     * @return 是否新增成功
     */
    Boolean add(SubjectLabelBO subjectLabelBO);

    /**
     * 更新标签
     * @param subjectLabelBO 标签信息
     * @return 是否更新成功
     */
    Boolean update(SubjectLabelBO subjectLabelBO);

    /**
     * 删除标签
     * @param subjectLabelBO 标签信息
     * @return 是否删除成功
     */
    Boolean delete(SubjectLabelBO subjectLabelBO);

    /**
     * 根据分类id查询标签
     * @param subjectLabelBO 标签信息
     * @return 标签列表
     */
    List<SubjectLabelBO> queryLabelByCategoryId(SubjectLabelBO subjectLabelBO);

}

