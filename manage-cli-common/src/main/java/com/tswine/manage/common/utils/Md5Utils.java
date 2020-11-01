package com.tswine.manage.common.utils;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @Author: wei.wang7
 * @Date: 2020/10/8 13:20
 */
public class Md5Utils {


    /**
     * 带盐加密
     *
     * @param str  需要加密的字符串
     * @param salt 盐
     * @return 加密后的字符串
     */
    public static String encryptWithSalt(String str, String salt) {
        return encrypt(salt + str + salt);
    }

    /**
     * 加密
     *
     * @param str 需要加密的字符串
     * @return 加密后的字符串
     */
    public static String encrypt(String str) {
        MessageDigest messageDigest = null;
        try {
            messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.reset();
            messageDigest.update(str.getBytes("UTF-8"));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        byte[] byteArray = messageDigest.digest();

        StringBuffer md5StrBuff = new StringBuffer();

        for (int i = 0; i < byteArray.length; i++) {
            if (Integer.toHexString(0xFF & byteArray[i]).length() == 1) {
                md5StrBuff.append("0").append(Integer.toHexString(0xFF & byteArray[i]));
            } else {
                md5StrBuff.append(Integer.toHexString(0xFF & byteArray[i]));
            }
        }
        return md5StrBuff.toString().toUpperCase();
    }
}
