/**
 * @projectName jc-club
 * @package com.jingdianjichi.subject.domain.convert
 * @className com.jingdianjichi.subject.domain.convert.SubjectCategoryConverter
 * @copyright Copyright 2020 Thunisoft, Inc All rights reserved.
 */
package com.jingdianjichi.subject.application.convert;

import com.jingdianjichi.subject.application.dto.SubjectInfoDTO;
import com.jingdianjichi.subject.domain.entity.SubjectInfoBO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * SubjectCategoryDToConverter
 * @author zxf
 * @date 2024/6/10 21:42
 * @version 1.0
 */
@Mapper
public interface SubjectInfoDTOConverter {
    SubjectInfoDTOConverter INSTANCE = Mappers.getMapper(SubjectInfoDTOConverter.class);


   SubjectInfoDTO convertBoToSubjectInfDTOList(SubjectInfoBO subjectInfoBO);

    /**
     *
     * @param subjectInfoDTO
     * @return
     */
    SubjectInfoBO convertDtoToBO(SubjectInfoDTO subjectInfoDTO);

    /**
     *
     * @param subjectInfoBO
     * @return
     */
    SubjectInfoDTO convertBoToDto(SubjectInfoBO subjectInfoBO);
}

