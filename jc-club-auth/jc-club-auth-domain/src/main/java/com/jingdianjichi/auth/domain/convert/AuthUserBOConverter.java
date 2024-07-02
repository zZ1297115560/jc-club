/**
 * @projectName jc-club
 * @package com.jingdianjichi.auth.domain.convert
 * @className com.jingdianjichi.auth.domain.convert.AuthUserBOConverter
 * @copyright Copyright 2020 Thunisoft, Inc All rights reserved.
 */
package com.jingdianjichi.auth.domain.convert;

import com.jingdianjichi.auth.domain.entity.AuthUserBO;
import com.jingdianjichi.auth.infra.basic.entity.AuthUser;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * AuthUserBOConverter
 * @author zxf
 * @date 2024/7/2 10:45
 * @version 1.0
 */
@Mapper
public interface AuthUserBOConverter {

    AuthUserBOConverter INSTANCE = Mappers.getMapper(AuthUserBOConverter.class);

    AuthUser convertBOToEntity(AuthUserBO authUserBO);

}