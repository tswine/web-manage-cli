package com.tswine.manage.domain.vo.user;

import lombok.Getter;
import lombok.Setter;

/**
 * 用户信息视图
 *
 * @Author: tswine
 * @Date: 2020/10/25 10:48
 */
@Getter
@Setter
public class UserVo {

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
     * 手机号码annao
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
    private String birthday;
    /**
     * 是否有效 1：有效 0：无效
     */
    private Integer status;

}
