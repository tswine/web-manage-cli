package com.tswine.manage.common.utils;

/**
 * @Author: wei.wang7
 * @Date: 2020/10/24 11:39
 */
public class TokenUtils {

    /**
     * 生成token值
     *
     * @return
     */
    public static String getToken() {
        return StringUtils.getUUID();
    }

    /**
     * 生成token存入redis的key
     *
     * @param token
     * @return
     */
    public static String getTokenKey(String token) {
        return "token:" + token;
    }
}
