/**
 * @projectName jc-club
 * @package com.jingdianjichi.subject.domain.convert
 * @className com.jingdianjichi.subject.domain.convert.SubjectCategoryConverter
 * @copyright Copyright 2020 Thunisoft, Inc All rights reserved.
 */
package com.jingdianjichi.subject.application.convert;

import com.jingdianjichi.subject.application.dto.SubjectLabelDTO;
import com.jingdianjichi.subject.domain.entity.SubjectLabelBO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * 标签DTO与BO转换器
 * @author zxf
 * @date 2024/6/10 21:42
 * @version 1.0
 */
@Mapper
public interface SubjectLabelDTOConverter {
    SubjectLabelDTOConverter INSTANCE = Mappers.getMapper(SubjectLabelDTOConverter.class);

    /**
     * 将标签DTO转换为BO
     * @param subjectLabelDTO 标签DTO
     * @return 标签BO
     */
    SubjectLabelBO convertDTOToLabelBo(SubjectLabelDTO subjectLabelDTO);
}

