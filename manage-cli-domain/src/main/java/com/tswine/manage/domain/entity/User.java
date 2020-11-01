package com.tswine.manage.domain.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author silly
 * @Date 2020-10-24 9:46:40
 */
@Data
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键自增
     */
    private Long id;
    /**
     * 用户名
     */
    private String userName;
    /**
     * 密码
     */
    private String passWord;
    /**
     * 真实姓名
     */
    private String name;
    /**
     * 手机号码
     */
    private String phone;
    /**
     * 邮箱
     */
    private String email;
    /**
     * 性别  1：男 2:女 3：保密
     */
    private Integer sex;
    /**
     * 生日
     */
    private Date birthday;
    /**
     * 秘钥
     */
    private String salt;
    /**
     * 是否有效 1：有效 0：无效
     */
    private Integer status;

}