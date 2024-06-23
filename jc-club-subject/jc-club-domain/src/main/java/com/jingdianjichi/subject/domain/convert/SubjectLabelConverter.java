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
    SubjectLabel convertBoToSubjectLabel(SubjectLabelBO subjectLabelBO);
}

