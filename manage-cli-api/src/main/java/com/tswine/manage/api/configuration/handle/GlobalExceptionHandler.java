package com.tswine.manage.api.configuration.handle;

import com.tswine.manage.common.base.BaseResponse;
import com.tswine.manage.common.enums.CodeEnum;
import com.tswine.manage.common.exceptions.VerifyException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 全局异常处理
 *
 * @Author: wei.wang7
 * @Date: 2020/8/30 13:14
 */
@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    @ResponseBody
    @ExceptionHandler(VerifyException.class)
    public BaseResponse verify(VerifyException ex) {
        return BaseResponse.builder()
                .code(CodeEnum.BAD_REQUEST.getKey())
                .msg(ex.getMessage())
                .build();
    }


    @ResponseBody
    @ExceptionHandler(Exception.class)
    public BaseResponse ex(Exception ex) {
        log.error("未知异常", ex);
        return BaseResponse.builder()
                .code(CodeEnum.ERROR.getKey())
                .msg(ex.getMessage())
                .build();
    }
}
