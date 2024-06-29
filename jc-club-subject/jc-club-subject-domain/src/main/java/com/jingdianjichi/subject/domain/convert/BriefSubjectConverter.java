/**
 * @projectName jc-club
 * @package com.jingdianjichi.subject.domain.convert
 * @className com.jingdianjichi.subject.domain.convert.SubjectCategoryConverter
 * @copyright Copyright 2020 Thunisoft, Inc All rights reserved.
 */
package com.jingdianjichi.subject.domain.convert;

import com.jingdianjichi.subject.domain.entity.SubjectInfoBO;
import com.jingdianjichi.subject.infra.basic.entity.SubjectBrief;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * 简答题目转换器
 * @author zxf
 * @date 2024/6/24 13:21
 * @version 1.0
 */
@Mapper
public interface BriefSubjectConverter {
    BriefSubjectConverter INSTANCE = Mappers.getMapper(BriefSubjectConverter.class);

    /**
     * 将标签BO转换为实体
     * @param subjectAnswerBO 题目答案BO
     * @return 标签实体
     */
    SubjectBrief convertBoToEntity(SubjectInfoBO subjectInfoBO);

}

