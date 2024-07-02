/**
 * @projectName jc-club
 * @package com.jingdianjichi.auth.application.convert
 * @className com.jingdianjichi.auth.application.convert.AuthUserDTOConverter
 * @copyright Copyright 2020 Thunisoft, Inc All rights reserved.
 */
package com.jingdianjichi.auth.application.convert;

import com.jingdianjichi.auth.application.dto.AuthUserDTO;
import com.jingdianjichi.auth.domain.entity.AuthUserBO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * AuthUserDTOConverter
 * @author zxf
 * @date 2024/7/2 10:40
 * @version 1.0
 */
@Mapper
public interface AuthUserDTOConverter {
    AuthUserDTOConverter INSTANCE = Mappers.getMapper(AuthUserDTOConverter.class);

    AuthUserBO convertDTOToBO(AuthUserDTO authUserDTO);
}

