package com.tswine.manage.api.controller;

import com.tswine.manage.api.service.UserService;
import com.tswine.manage.common.base.BaseResponse;
import com.tswine.manage.common.base.PageResult;
import com.tswine.manage.common.exceptions.VerifyException;
import com.tswine.manage.common.utils.StringUtils;
import com.tswine.manage.domain.entity.User;
import com.tswine.manage.domain.vo.user.UserQuery;
import com.tswine.manage.domain.vo.user.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * 用户操作
 *
 * @Author: tswine
 * @Date: 2020/10/25 9:47
 */
@RequestMapping(value = "/user")
@RestController
public class UserController {


    @Autowired
    private UserService userService;

    /**
     * 获取所有用户信息
     *
     * @return
     */
    @RequestMapping(value = "/list")
    public BaseResponse<PageResult<User>> list(UserQuery query) {
        query.convert();
        PageResult pageResult = userService.list(query);
        return BaseResponse.success(null, pageResult);
    }

    /**
     * 添加用户信息
     *
     * @param userVo
     * @return
     */
    @RequestMapping(value = "/add")
    public BaseResponse<String> add(UserVo userVo) {
        //TODO 校验所有信息
        userService.add(userVo);
        return BaseResponse.success("添加用户成功");
    }

    /**
     * 删除
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/delete/{id}")
    public BaseResponse<String> delete(@PathVariable("id") Long id) {
        userService.delete(id);
        return BaseResponse.success("删除用户成功");
    }

    /**
     * 编辑用户
     *
     * @param userVo
     * @return
     */
    @RequestMapping(value = "/edit")
    public BaseResponse<String> edit(UserVo userVo) {
        //TODO 校验所有信息
        userService.edit(userVo);
        return BaseResponse.success("编辑用户成功");
    }

    /**
     * 更新状态
     *
     * @param id
     * @param status
     * @return
     */
    @RequestMapping(value = "/update/status/{id}")
    public BaseResponse<String> updateStatus(@PathVariable("id") Integer id, Integer status) {
        if (status == null || !(status == 0 || status == 1)) {
            throw new VerifyException("状态值不合法");
        }
        userService.updateStatus(id, status);
        return BaseResponse.success(null);
    }

    /**
     * 校验用户名
     */
    @RequestMapping(value = "/check/userName")
    public BaseResponse<String> checkUserName(String userName, Long id) {
        if (StringUtils.isBlank(userName)) {
            throw new VerifyException("用户名不能为空");
        }
        userService.checkUserName(userName, id);
        return BaseResponse.success(null);
    }

    /**
     * 重置密码
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/resetPassWord/{id}")
    public BaseResponse<String> resetPassWord(@PathVariable("id") Long id) {
        String newPassWord = userService.resetPassWord(id);
        return BaseResponse.success(null, newPassWord);
    }

}
