/**
 * @projectName jc-club
 * @package com.jingdianjichi.subject.domain.convert
 * @className com.jingdianjichi.subject.domain.convert.SubjectCategoryConverter
 * @copyright Copyright 2020 Thunisoft, Inc All rights reserved.
 */
package com.jingdianjichi.subject.domain.convert;

import com.jingdianjichi.subject.domain.entity.SubjectInfoBO;
import com.jingdianjichi.subject.domain.entity.SubjectOptionBO;
import com.jingdianjichi.subject.infra.basic.entity.SubjectInfo;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * 题目信息转换器
 * @author zxf
 * @date 2024/6/10 21:42
 * @version 1.0
 */
@Mapper
public interface SubjectInfoConverter {
    SubjectInfoConverter INSTANCE = Mappers.getMapper(SubjectInfoConverter.class);

    /**
     * 将标签BO转换为实体
     * @param subjectLabelBO 标签BO
     * @return 标签实体
     */
    SubjectInfo convertBoToEntity(SubjectInfoBO subjectInfoBO);

    /**
     * 将标签实体转换为BO
     * @param subjectLabel 标签实体
     * @return
     */
    SubjectInfoBO convertEntityToBo(SubjectInfo subjectInfo);

    /**
     * 将optionBO转换为BO
     * @param subjectOptionBO optionBO
     * @param subjectInfoBO infoBO
     * @return optionBO
     */
    SubjectInfoBO convertOptionBoAndInfoToBo(SubjectOptionBO subjectOptionBO,SubjectInfo subjectInfo);


    List<SubjectInfoBO> convertEntityListToBoList(List<SubjectInfo> subjectInfo);
}

