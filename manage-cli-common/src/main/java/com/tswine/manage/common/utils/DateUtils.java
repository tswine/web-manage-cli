package com.tswine.manage.common.utils;

import com.tswine.manage.common.enums.DateFormatEnum;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 日期工具类
 *
 * @Author: tswine
 * @Date: 2020/10/25 10:55
 */
public class DateUtils {
    private DateUtils() {
        throw new AssertionError("DateUtils不允许被实例化");
    }


    /**
     * 日期字符串格式转换
     *
     * @param dateStr      日期字符串
     * @param sourceFormat 原格式
     * @param targetFormat 目标格式
     * @return
     */
    public static String transformDate(String dateStr, DateFormatEnum sourceFormat, DateFormatEnum targetFormat) {
        return formatDate(parseDate(dateStr, sourceFormat), targetFormat);
    }


    /**
     * 字符串转成日期
     *
     * @param dateStr
     * @param format
     * @return
     */
    public static Date parseDate(String dateStr, DateFormatEnum format) {
//        AssertUtils.requireNonNull(format, "日期格式化不能为空");
//        AssertUtils.isNotBank(dateStr, "需要转换的日期字符串不能为空");
        DateFormat formatter = new SimpleDateFormat(format.getFormat());
        try {
            return formatter.parse(dateStr);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }


    /**
     * 日期格式化
     *
     * @param date
     * @param format
     * @return
     */
    public static String formatDate(Date date, DateFormatEnum format) {
//        AssertUtils.requireNonNull(date, "日期不能为空");
        if (format == null) {
            format = DateFormatEnum.FORMAT_19;
        }
        DateFormat formatter = new SimpleDateFormat(format.getFormat());
        return formatter.format(date);
    }

}
