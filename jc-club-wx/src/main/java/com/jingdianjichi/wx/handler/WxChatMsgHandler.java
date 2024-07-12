/**
 * @projectName jc-club
 * @package com.jingdianjichi.wx.handler
 * @className com.jingdianjichi.wx.handler.WxChatMsgHandler
 * @copyright Copyright 2020 Thunisoft, Inc All rights reserved.
 */
package com.jingdianjichi.wx.handler;

import java.util.Map;

/**
 * WxChatMsgHandler
 * @author zxf
 * @date 2024/7/11 22:58
 * @version 1.0
 */
public interface WxChatMsgHandler {

    WxChatMsgTypeEnum getMsgType();

    String dealMsg(Map<String, String> messageMap);

}


