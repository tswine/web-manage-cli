package com.tswine.manage.api.controller;

import com.tswine.manage.api.service.LogonService;
import com.tswine.manage.common.base.BaseResponse;
import com.tswine.manage.common.utils.AssertUtils;
import com.tswine.manage.common.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 登录控制器
 *
 * @Author: wei.wang7
 * @Date: 2020/10/8 13:02
 */
@RestController
@RequestMapping(value = "/logon")
public class LogonController {

    @Autowired
    LogonService logonService;


    /**
     * 登录
     *
     * @return
     */
    @RequestMapping(value = "/login")
    public BaseResponse<String> login(String userName, String passWord) {
        AssertUtils.isNotBank(userName, "用户名不能为空");
        AssertUtils.isNotBank(passWord, "密码不能为空");
        String token = logonService.login(userName, passWord);
        return BaseResponse.success("登录成功", token);
    }

    /**
     * 登出
     *
     * @return
     */
    @RequestMapping(value = "/logout")
    public BaseResponse<String> logout(@RequestHeader("Authorization") String token) {
        if (StringUtils.isNotBlank(token)){
            logonService.logout(token);
        }
        return BaseResponse.success("登出成功", null);
    }
}
