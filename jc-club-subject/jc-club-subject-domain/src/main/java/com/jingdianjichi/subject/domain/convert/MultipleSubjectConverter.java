/**
 * @projectName jc-club
 * @package com.jingdianjichi.subject.domain.convert
 * @className com.jingdianjichi.subject.domain.convert.SubjectCategoryConverter
 * @copyright Copyright 2020 Thunisoft, Inc All rights reserved.
 */
package com.jingdianjichi.subject.domain.convert;

import com.jingdianjichi.subject.domain.entity.SubjectAnswerBO;
import com.jingdianjichi.subject.domain.entity.SubjectInfoBO;
import com.jingdianjichi.subject.infra.basic.entity.SubjectBrief;
import com.jingdianjichi.subject.infra.basic.entity.SubjectMultiple;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * 简答题目转换器
 * @author zxf
 * @date 2024/6/24 13:21
 * @version 1.0
 */
@Mapper
public interface MultipleSubjectConverter {
    MultipleSubjectConverter INSTANCE = Mappers.getMapper(MultipleSubjectConverter.class);

    /**
     * 将标签BO转换为实体
     * @param subjectAnswerBO 题目答案BO
     * @return 标签实体
     */
    SubjectBrief convertBoToEntity(SubjectInfoBO subjectInfoBO);

    /**
     * 将简答答案实体转换为BO
     * @param subjectMultipleList 简答答案实体列表
     * @return 简答答案BO列表
     */
    List<SubjectAnswerBO> convertEntityListToBoList(List<SubjectMultiple> subjectMultipleList);

    /**
     * 将标签BO转换为多选题目实体
     * @param subjectAnswerBO 题目答案BO
     * @return 多选题目实体
     */
    SubjectMultiple convertBoToEntity(SubjectAnswerBO subjectAnswerBO);
}

