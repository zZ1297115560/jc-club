/**
 * @projectName jc-club
 * @package com.jingdianjichi.subject.domain.convert
 * @className com.jingdianjichi.subject.domain.convert.SubjectCategoryConverter
 * @copyright Copyright 2020 Thunisoft, Inc All rights reserved.
 */
package com.jingdianjichi.subject.domain.convert;

import com.jingdianjichi.subject.domain.entity.SubjectLabelBO;
import com.jingdianjichi.subject.infra.basic.entity.SubjectLabel;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * 标签分类转换器
 * @author zxf
 * @date 2024/6/10 21:42
 * @version 1.0
 */
@Mapper
public interface SubjectLabelConverter {
    SubjectLabelConverter INSTANCE = Mappers.getMapper(SubjectLabelConverter.class);

    /**
     * 将标签BO转换为实体
     * @param subjectLabelBO 标签BO
     * @return 标签实体
     */
    SubjectLabel convertBoToEntity(SubjectLabelBO subjectLabelBO);

    /**
     * 将标签实体转换为BO
     * @param subjectLabel 标签实体
     * @return
     */
    SubjectLabelBO convertEntityToBo(SubjectLabel subjectLabel);

    /**
     * 将标签实体列表转换为BO列表
     * @param subjectLabelList 标签实体列表
     * @return 标签BO列表
     */
    List<SubjectLabelBO> convertEntityListToBoList(List<SubjectLabel> subjectLabelList);
}

