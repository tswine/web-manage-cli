package com.tswine.manage.common.enums;

import com.sun.org.apache.bcel.internal.classfile.Code;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 响应状态码枚举
 *
 * @Author: wei.wang7
 * @Date: 2020/10/8 13:09
 */
public enum CodeEnum {

    OK(200, "请求成功"),
    BAD_REQUEST(400, "参数不合法"),
    UNAUTHORIZED(401, "未授权"),
    ERROR(500, "内部错误");

    Integer key;
    String value;

    CodeEnum(Integer key, String value){
        this.key =key;
        this.value=value;
    }

    public Integer getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }
}
