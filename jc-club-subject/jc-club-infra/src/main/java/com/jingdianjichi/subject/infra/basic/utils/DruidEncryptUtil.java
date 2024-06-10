/**
 * @projectName jc-club
 * @package com.jingdianjichi.subject.infra.basic.utils
 * @className com.jingdianjichi.subject.infra.basic.utils.DruidEncryptUtil
 * @copyright Copyright 2020 Thunisoft, Inc All rights reserved.
 */
package com.jingdianjichi.subject.infra.basic.utils;

import com.alibaba.druid.filter.config.ConfigTools;

import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;

/**
 * 数据库加密util
 * @author zxf
 * @date 2024/6/10 20:33
 * @version 1.0
 */
public class DruidEncryptUtil {
    private static String publicKey;

    private static String privateKey;

    static {
        try {
            String[] keyPair = ConfigTools.genKeyPair(512);
            privateKey = keyPair[0];
            System.out.println("privateKey: " + privateKey);
            publicKey = keyPair[1];
            System.out.println("publicKey: " + publicKey);
        } catch (NoSuchAlgorithmException | NoSuchProviderException e) {
            e.printStackTrace();
        }
    }

    public static String encrypt(String originPassword) {
        try {
            String encryptPassword = ConfigTools.encrypt(privateKey, originPassword);
            System.out.println(originPassword+"加密后为："+encryptPassword);
            return encryptPassword;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String decrypt(String encryptPassword) {
        try {
            String originPassword = ConfigTools.decrypt(publicKey, encryptPassword);
            System.out.println(encryptPassword+"解密后为："+originPassword);
            return originPassword;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        String originPassword = "root";

        String encryptPassword = encrypt(originPassword);
        System.out.println("main:"+encryptPassword);
        originPassword = decrypt(encryptPassword);
        System.out.println("main:"+originPassword);

    }
}

