/**
 * @projectName jc-club
 * @package com.jingdianjichi.subject.application.convert
 * @className com.jingdianjichi.subject.application.convert.SubjectLikedDTOConverter
 * @copyright Copyright 2020 Thunisoft, Inc All rights reserved.
 */
package com.jingdianjichi.subject.application.convert;

import com.jingdianjichi.subject.application.dto.SubjectLikedDTO;
import com.jingdianjichi.subject.domain.entity.SubjectLikedBO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * SubjectLikedDTOConverter
 * @author zxf
 * @date 2024/7/19 2:08
 * @version 1.0
 */
@Mapper
public interface SubjectLikedDTOConverter {

    SubjectLikedDTOConverter INSTANCE = Mappers.getMapper(SubjectLikedDTOConverter.class);

    SubjectLikedBO convertDTOToBO(SubjectLikedDTO subjectLikedDTO);

}


