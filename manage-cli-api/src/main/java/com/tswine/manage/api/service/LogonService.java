package com.tswine.manage.api.service;

import com.alibaba.fastjson.JSON;
import com.tswine.manage.api.provider.RedisProvider;
import com.tswine.manage.common.exceptions.VerifyException;
import com.tswine.manage.common.utils.Md5Utils;
import com.tswine.manage.common.utils.TokenUtils;
import com.tswine.manage.dao.UserMapper;
import com.tswine.manage.domain.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 登录
 *
 * @Author: wei.wang7
 * @Date: 2020/10/8 13:18
 */
@Slf4j
@Service
public class LogonService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private RedisProvider redisProvider;

    /**
     * 登录校验
     *
     * @param userName 用户名
     * @param passWord 密码
     * @return token
     */
    public String login(String userName, String passWord) {
        User user = userMapper.selectByUserName(userName);
        if (user == null) {
            throw new VerifyException("用户信息不存在");
        }
        log.info(Md5Utils.encryptWithSalt(passWord, user.getSalt()));
        if (!Md5Utils.encryptWithSalt(passWord, user.getSalt()).equalsIgnoreCase(user.getPassWord())) {
            throw new VerifyException("用户密码错误");
        }
        String token = TokenUtils.getToken();
        redisProvider.set(TokenUtils.getTokenKey(token), JSON.toJSONString(user), 1000);
        return token;
    }

    /**
     * 登出
     *
     * @param token
     */
    public void logout(String token) {
        redisProvider.delete(TokenUtils.getTokenKey(token));
    }

}
