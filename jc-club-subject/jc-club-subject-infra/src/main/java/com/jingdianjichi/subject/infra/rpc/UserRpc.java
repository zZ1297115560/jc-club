/**
 * @projectName jc-club
 * @package com.jingdianjichi.subject.infra.rpc
 * @className com.jingdianjichi.subject.infra.rpc.UserRpc
 * @copyright Copyright 2020 Thunisoft, Inc All rights reserved.
 */
package com.jingdianjichi.subject.infra.rpc;

import com.jingdianjichi.auth.api.UserFeignService;
import com.jingdianjichi.auth.dto.AuthUserDTO;
import com.jingdianjichi.auth.entity.Result;
import com.jingdianjichi.subject.infra.basic.entity.UserInfo;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * UserRpc
 * @author zxf
 * @date 2024/7/15 15:07
 * @version 1.0
 */
@Component
public class UserRpc {

    @Resource
    private UserFeignService userFeignService;

    public UserInfo getUserInfo(String userName) {
        AuthUserDTO authUserDTO = new AuthUserDTO();
        authUserDTO.setUserName(userName);
        Result<AuthUserDTO> result = userFeignService.getUserInfo(authUserDTO);
        UserInfo userInfo = new UserInfo();
        if (!result.getSuccess()) {
            return userInfo;
        }
        AuthUserDTO data = result.getData();
        userInfo.setUserName(data.getUserName());
        userInfo.setNickName(data.getNickName());
        return userInfo;
    }

}


