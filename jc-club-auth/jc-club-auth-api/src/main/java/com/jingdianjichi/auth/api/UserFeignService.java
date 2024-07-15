/**
 * @projectName jc-club
 * @package com.jingdianjichi.auth.api
 * @className com.jingdianjichi.auth.api.UserFeignService
 * @copyright Copyright 2020 Thunisoft, Inc All rights reserved.
 */
package com.jingdianjichi.auth.api;

import com.jingdianjichi.auth.dto.AuthUserDTO;
import com.jingdianjichi.auth.entity.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * UserFeignService
 * @author zxf
 * @date 2024/7/15 15:02
 * @version 1.0
 */
@FeignClient("jc-club-auth-dev")
public interface UserFeignService {

    @RequestMapping("/user/getUserInfo")
    Result<AuthUserDTO> getUserInfo(@RequestBody AuthUserDTO authUserDTO);


}
