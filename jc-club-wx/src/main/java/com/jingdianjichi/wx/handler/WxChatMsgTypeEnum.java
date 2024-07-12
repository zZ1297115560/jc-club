/**
 * @projectName jc-club
 * @package com.jingdianjichi.wx.handler
 * @className com.jingdianjichi.wx.handler.WxChatMsgTypeEnum
 * @copyright Copyright 2020 Thunisoft, Inc All rights reserved.
 */
package com.jingdianjichi.wx.handler;

/**
 * WxChatMsgTypeEnum
 * @author zxf
 * @date 2024/7/11 22:58
 * @version 1.0
 */
public enum WxChatMsgTypeEnum {

    SUBSCRIBE("event.subscribe", "用户关注事件"),
    TEXT_MSG("text", "接收用户文本消息");

    private String msgType;

    private String desc;

    WxChatMsgTypeEnum(String msgType, String desc) {
        this.msgType = msgType;
        this.desc = desc;
    }

    public static WxChatMsgTypeEnum getByMsgType(String msgType) {
        for (WxChatMsgTypeEnum wxChatMsgTypeEnum : WxChatMsgTypeEnum.values()) {
            if (wxChatMsgTypeEnum.msgType.equals(msgType)) {
                return wxChatMsgTypeEnum;
            }
        }
        return null;
    }

}


