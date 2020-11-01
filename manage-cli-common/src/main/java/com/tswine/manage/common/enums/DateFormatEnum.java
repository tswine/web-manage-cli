package com.tswine.manage.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 日期格式枚举
 *
 * @Author: tswine
 * @Date: 2020/10/25 10:57
 */
@Getter
@AllArgsConstructor
public enum DateFormatEnum {

    FORMAT_4(4, "yyyyMM"),
    FORMAT_5(5, "yyyy-MM"),
    FORMAT_8(8, "yyyyMMdd"),
    FORMAT_10(10, "yyyy-MM-dd"),
    FORMAT_14(14, "yyyyMMddHHmmss"),
    FORMAT_19(19, "yyyy-MM-dd HH:mm:ss"),
    ;


    private int code;
    private String format;

}
