package com.tswine.manage.domain.vo.user;

import com.tswine.manage.common.base.Query;
import com.tswine.manage.common.exceptions.VerifyException;
import com.tswine.manage.common.utils.StringUtils;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

/**
 * 用户查询条件
 *
 * @Author: tswine
 * @Date: 2020/10/25 10:08
 */
@Getter
@Setter
public class UserQuery extends Query {
    /**
     * 用户名
     */
    private String userName;
    /**
     * 真实姓名
     */
    private String name;

    /**
     * 性别
     */
    private String sex;

    /**
     * 性别集合
     */
    private List<Integer> sexList;

    /**
     * 生日
     */
    private String birthday;

    /**
     * 开始时间
     */
    private String startDay;

    /**
     * 开始时间
     */
    private String endDay;

    /**
     * 电话号码
     */
    private String phone;

    /**
     * 数据转换
     */
    public void convert() {
        if (StringUtils.isNotBlank(birthday)) {
            try {
                String[] strBirthday = birthday.split(",");
                startDay = strBirthday[0];
                endDay = strBirthday[1];
            } catch (Exception ex) {
                throw new VerifyException("生日日期格式错误");
            }
        }
        if (StringUtils.isNotBlank(sex)) {
            try {
                sexList = new ArrayList<>();
                String[] strSex = sex.split(",");
                for (String str : strSex) {
                    sexList.add(Integer.parseInt(str));
                }
            } catch (Exception ex) {
                throw new VerifyException("性别数据格式错误");
            }
        }
    }
}
