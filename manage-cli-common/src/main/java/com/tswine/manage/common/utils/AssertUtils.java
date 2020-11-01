package com.tswine.manage.common.utils;

import com.tswine.manage.common.exceptions.VerifyException;

/**
 * 断言工具类
 *
 * @Author: wei.wang7
 * @Date: 2020/10/8 13:38
 */
public class AssertUtils {

    /**
     * 字符串不能为空
     *
     * @param str      字符串
     * @param meeesage 错误提示信息
     */
    public static void isNotBank(String str, String meeesage) {
        if (StringUtils.isBlank(str)) {
            throw new VerifyException(meeesage);
        }
    }
}
