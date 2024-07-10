/**
 * @projectName jc-club
 * @package com.jingdianjichi.subject.domain.convert
 * @className com.jingdianjichi.subject.domain.convert.SubjectCategoryConverter
 * @copyright Copyright 2020 Thunisoft, Inc All rights reserved.
 */
package com.jingdianjichi.subject.application.convert;

import com.jingdianjichi.subject.application.dto.SubjectCategoryDTO;
import com.jingdianjichi.subject.domain.entity.SubjectCategoryBO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * SubjectCategoryDToConverter
 * @author zxf
 * @date 2024/6/10 21:42
 * @version 1.0
 */
@Mapper
public interface SubjectCategoryDTOConverter {
    SubjectCategoryDTOConverter INSTANCE = Mappers.getMapper(SubjectCategoryDTOConverter.class);

    SubjectCategoryBO convertDTOToCategory(SubjectCategoryDTO subjectCategoryDTO);

    List<SubjectCategoryDTO> convertBoToCategoryDTOList(List<SubjectCategoryBO> subjectCategoryBO);

    SubjectCategoryBO convertDtoToCategoryBo(SubjectCategoryDTO subjectCategoryDTO);
}
