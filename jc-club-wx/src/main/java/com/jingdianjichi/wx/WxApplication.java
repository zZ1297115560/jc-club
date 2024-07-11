/**
 * @projectName jc-club
 * @package com.jingdianjichi.wx
 * @className com.jingdianjichi.wx.WxApplication
 * @copyright Copyright 2020 Thunisoft, Inc All rights reserved.
 */
package com.jingdianjichi.wx;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * WxApplication
 * @author zxf
 * @date 2024/7/11 11:31
 * @version 1.0
 */
@SpringBootApplication
@ComponentScan("com.jingdianjichi")
public class WxApplication {

    public static void main(String[] args) {
        SpringApplication.run(WxApplication.class);
    }

}

