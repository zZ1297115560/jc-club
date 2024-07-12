/**
 * @projectName jc-club
 * @package com.jingdianjichi.wx.handler
 * @className com.jingdianjichi.wx.handler.SubscribeMsgHandler
 * @copyright Copyright 2020 Thunisoft, Inc All rights reserved.
 */
package com.jingdianjichi.wx.handler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * SubscribeMsgHandler
 * @author zxf
 * @date 2024/7/11 22:57
 * @version 1.0
 */
@Component
@Slf4j
public class SubscribeMsgHandler implements WxChatMsgHandler {

    @Override
    public WxChatMsgTypeEnum getMsgType() {
        return WxChatMsgTypeEnum.SUBSCRIBE;
    }

    @Override
    public String dealMsg(Map<String, String> messageMap) {
        log.info("触发用户关注事件！");
        String fromUserName = messageMap.get("FromUserName");
        String toUserName = messageMap.get("ToUserName");
        String subscribeContent = "感谢您的关注，我是经典鸡翅！欢迎来学习从0到1社区项目";
        String content = "<xml>\n" +
                "  <ToUserName><![CDATA[" + fromUserName + "]]></ToUserName>\n" +
                "  <FromUserName><![CDATA[" + toUserName + "]]></FromUserName>\n" +
                "  <CreateTime>12345678</CreateTime>\n" +
                "  <MsgType><![CDATA[text]]></MsgType>\n" +
                "  <Content><![CDATA[" + subscribeContent + "]]></Content>\n" +
                "</xml>";
        return content;
    }

}

