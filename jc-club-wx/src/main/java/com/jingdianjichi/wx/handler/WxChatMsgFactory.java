/**
 * @projectName jc-club
 * @package com.jingdianjichi.wx.handler
 * @className com.jingdianjichi.wx.handler.WxChatMsgFactory
 * @copyright Copyright 2020 Thunisoft, Inc All rights reserved.
 */
package com.jingdianjichi.wx.handler;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * WxChatMsgFactory
 * @author zxf
 * @date 2024/7/11 22:58
 * @version 1.0
 */
@Component
public class WxChatMsgFactory implements InitializingBean {

    @Resource
    private List<WxChatMsgHandler> wxChatMsgHandlerList;

    private Map<WxChatMsgTypeEnum, WxChatMsgHandler> handlerMap = new HashMap<>();

    public WxChatMsgHandler getHandlerByMsgType(String msgType) {
        WxChatMsgTypeEnum msgTypeEnum = WxChatMsgTypeEnum.getByMsgType(msgType);
        return handlerMap.get(msgTypeEnum);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        for (WxChatMsgHandler wxChatMsgHandler : wxChatMsgHandlerList) {
            handlerMap.put(wxChatMsgHandler.getMsgType(), wxChatMsgHandler);
        }
    }

}

