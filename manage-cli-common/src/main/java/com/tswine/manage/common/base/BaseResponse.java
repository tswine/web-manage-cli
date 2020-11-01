package com.tswine.manage.common.base;

import com.tswine.manage.common.enums.CodeEnum;
import lombok.*;

/**
 * 接口公共返回定义
 *
 * @Author: wei.wang7
 * @Date: 2020/10/8 13:07
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BaseResponse<T> {

    /**
     * 响应码
     */
    Integer code;
    /**
     * 提示信息
     */
    String msg;
    /**
     * 返回数据
     */
    T data;

    public static BaseResponse success(String msg, Object data) {
        return BaseResponse.builder().code(CodeEnum.OK.getKey())
                .msg(msg)
                .data(data).build();
    }

    public static BaseResponse success(String msg) {
        return success(msg, null);
    }

}
