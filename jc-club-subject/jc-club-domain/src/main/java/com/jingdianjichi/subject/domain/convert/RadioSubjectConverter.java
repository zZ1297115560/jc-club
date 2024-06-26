/**
 * @projectName jc-club
 * @package com.jingdianjichi.subject.domain.convert
 * @className com.jingdianjichi.subject.domain.convert.SubjectCategoryConverter
 * @copyright Copyright 2020 Thunisoft, Inc All rights reserved.
 */
package com.jingdianjichi.subject.domain.convert;

import com.jingdianjichi.subject.domain.entity.SubjectAnswerBO;
import com.jingdianjichi.subject.infra.basic.entity.SubjectRadio;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * 单选题目转换器
 * @author zxf
 * @date 2024/6/24 13:21
 * @version 1.0
 */
@Mapper
public interface RadioSubjectConverter {
    RadioSubjectConverter INSTANCE = Mappers.getMapper(RadioSubjectConverter.class);

    /**
     * 将标签BO转换为实体
     * @param subjectAnswerBO 题目答案BO
     * @return 标签实体
     */
    SubjectRadio convertBoToEntity(SubjectAnswerBO subjectAnswerBO);

    /**
     * 将选择题实体转换为答案BO
     * @param subjectRadioList 选择题实体列表
     * @return 答案BO列表
     */
    List<SubjectAnswerBO> convertEntityListToBoList(List<SubjectRadio> subjectRadioList);

}

