package com.tswine.manage.api;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * API模块入口
 *
 * @Author: wei.wang7
 * @Date: 2020/10/8 11:02
 */
@SpringBootApplication(scanBasePackages ={"com.tswine.manage"})
@MapperScan("com.tswine.manage.dao")
public class ManageApiApplication {
    public static void main(String[] args) {
        SpringApplication.run(ManageApiApplication.class, args);
    }
}
