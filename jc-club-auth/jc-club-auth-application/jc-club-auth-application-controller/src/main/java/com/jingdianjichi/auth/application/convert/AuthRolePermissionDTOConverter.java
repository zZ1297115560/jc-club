/**
 * @projectName jc-club
 * @package com.jingdianjichi.auth.application.convert
 * @className com.jingdianjichi.auth.application.convert.AuthRolePermissionDTOConverter
 * @copyright Copyright 2020 Thunisoft, Inc All rights reserved.
 */
package com.jingdianjichi.auth.application.convert;

import com.jingdianjichi.auth.application.dto.AuthRolePermissionDTO;
import com.jingdianjichi.auth.domain.entity.AuthRolePermissionBO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * AuthRolePermissionDTOConverter
 * @author zxf
 * @date 2024/7/9 20:10
 * @version 1.0
 */
@Mapper
public interface AuthRolePermissionDTOConverter {

    AuthRolePermissionDTOConverter INSTANCE = Mappers.getMapper(AuthRolePermissionDTOConverter.class);

    AuthRolePermissionBO convertDTOToBO(AuthRolePermissionDTO authRolePermissionDTO);

}


