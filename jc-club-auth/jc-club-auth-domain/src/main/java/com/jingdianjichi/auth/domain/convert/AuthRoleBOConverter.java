/**
 * @projectName jc-club
 * @package com.jingdianjichi.auth.domain.convert
 * @className com.jingdianjichi.auth.domain.convert.AuthRoleBOConverter
 * @copyright Copyright 2020 Thunisoft, Inc All rights reserved.
 */
package com.jingdianjichi.auth.domain.convert;

import com.jingdianjichi.auth.domain.entity.AuthRoleBO;
import com.jingdianjichi.auth.infra.basic.entity.AuthRole;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * AuthRoleBOConverter
 * @author zxf
 * @date 2024/7/2 15:30
 * @version 1.0
 */
@Mapper
public interface AuthRoleBOConverter {

    AuthRoleBOConverter INSTANCE = Mappers.getMapper(AuthRoleBOConverter.class);

    AuthRole convertBOToEntity(AuthRoleBO authRoleBO);

}
