package com.tswine.manage.api.provider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * redis 工具类
 *
 * @Author: wei.wang7
 * @Date: 2020/10/24 11:17
 */
@Component
public class RedisProvider {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    /**
     * 存储数据
     *
     * @param key
     * @param value
     * @param time
     */
    public void set(String key, String value, int time) {
        stringRedisTemplate.opsForValue().set(key, value, time, TimeUnit.SECONDS);
    }

    /**
     * 删除数据
     * @param key
     */
    public  void  delete(String key){
        stringRedisTemplate.delete(key);
    }
}
