package com.tswine.manage.api.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.tswine.manage.common.base.PageResult;
import com.tswine.manage.common.enums.DateFormatEnum;
import com.tswine.manage.common.exceptions.VerifyException;
import com.tswine.manage.common.utils.DateUtils;
import com.tswine.manage.common.utils.Md5Utils;
import com.tswine.manage.common.utils.StringUtils;
import com.tswine.manage.dao.UserMapper;
import com.tswine.manage.domain.entity.User;
import com.tswine.manage.domain.vo.user.UserQuery;
import com.tswine.manage.domain.vo.user.UserVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 用户信息
 *
 * @Author: tswine
 * @Date: 2020/10/25 10:05
 */
@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    /**
     * 查询用户信息
     *
     * @param query
     * @return
     */
    public PageResult<UserVo> list(UserQuery query) {
        PageHelper.startPage(query.getCurrentPage(), query.getPageSize());
        Page<Object> localPage = PageHelper.getLocalPage();
        List<User> list = userMapper.selectByQuery(query);
        List<UserVo> userVoList = new ArrayList<>();
        for (User user : list) {
            UserVo userVo = new UserVo();
            BeanUtils.copyProperties(user, userVo);
            //清空密码
            userVo.setPassWord(null);
            if (user.getBirthday() != null) {
                userVo.setBirthday(DateUtils.formatDate(user.getBirthday(), DateFormatEnum.FORMAT_10));
            }
            userVoList.add(userVo);
        }
        PageResult<UserVo> pageResult = new PageResult<>();
        pageResult.setResults(userVoList);
        pageResult.setCurrentPage(query.getCurrentPage());
        pageResult.setPageSize(query.getPageSize());
        pageResult.setTotalRecord(localPage.getTotal());
        return pageResult;
    }

    /**
     * 添加用户信息
     *
     * @param userVo
     */
    public void add(UserVo userVo) {
        String salt = StringUtils.getUUID();
        User user = new User();
        BeanUtils.copyProperties(userVo, user);
        user.setSalt(salt);
        if (StringUtils.isNotBlank(userVo.getBirthday())) {
            user.setBirthday(DateUtils.parseDate(userVo.getBirthday(), DateFormatEnum.FORMAT_10));
        }
        user.setPassWord(Md5Utils.encryptWithSalt(user.getPassWord(), salt));
        userMapper.insert(user);
    }

    /**
     * 编辑用户
     */
    public void edit(UserVo userVo) {
        userMapper.update(userVo);
    }

    /**
     * 更新状态
     *
     * @param id
     * @param status
     */
    public void updateStatus(Integer id, Integer status) {
        userMapper.updateStatus(id, status);
    }

    /**
     * 删除用户
     *
     * @param id
     */
    public void delete(Long id) {
        User user = userMapper.selectByPrimaryKey(id);
        if (user == null) {
            throw new RuntimeException("删除用户信息不存在");
        }
        userMapper.deleteByPrimaryKey(id);
    }

    /**
     * 校验用户名
     *
     * @param userName
     * @param id
     */
    public void checkUserName(String userName, Long id) {
        User user = userMapper.selectByUserName(userName);
        if (user == null) {
            return;
        }
        if (id != null && user.getId().longValue() == id.longValue()) {
            return;
        }
        throw new VerifyException("用户名已经存在");
    }

    /**
     * 重置密码
     *
     * @param id
     * @return
     */
    public String resetPassWord(Long id) {
        User user = userMapper.selectByPrimaryKey(id);
        if (user == null) {
            throw new VerifyException("用户信息不存在");
        }
        //随机生成盐
        String salt = StringUtils.getUUID();
        String newPassword = StringUtils.getRandomStr(8);
        String encrypt = Md5Utils.encryptWithSalt(newPassword, salt);
        int flag = userMapper.updatePassWord(id, encrypt, salt);
        if (flag != 1) {
            throw new VerifyException("更新用户密码错误");
        }
        return newPassword;
    }
}
