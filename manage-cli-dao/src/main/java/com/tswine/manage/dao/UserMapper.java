package com.tswine.manage.dao;

import com.tswine.manage.domain.entity.User;
import com.tswine.manage.domain.vo.user.UserQuery;
import com.tswine.manage.domain.vo.user.UserVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * mapper层
 *
 * @Author: wei.wang7
 * @Date: 2020/7/26 17:09
 */
@Mapper
public interface UserMapper {

    /**
     * 根据主键获取实体对象
     *
     * @param id 主键自增
     * @return 获取的实体对象
     */
    User selectByPrimaryKey(@Param("id") Long id);

    /**
     * 通过主键删除数据
     *
     * @param id 主键自增
     * @return 数据库受影响行数
     */
    Integer deleteByPrimaryKey(@Param("id") Long id);

    /***
     * 插入实体对象
     * @param entity
     * @return 插入的条数
     */
    Integer insert(User entity);

    /**
     * 通过用户名查询
     *
     * @param userName
     * @return
     */
    User selectByUserName(String userName);

    /**
     * 按照条件分页查询
     *
     * @param query
     * @return
     */
    List<User> selectByQuery(UserQuery query);

    /**
     * 更新状态
     *
     * @param id
     * @param status
     * @return
     */
    int updateStatus(Integer id, Integer status);

    /**
     * 更新用户
     *
     * @param userVo
     * @return
     */
    int update(UserVo userVo);

    /**
     * 更新密码
     *
     * @param id
     * @param passWord
     * @param salt
     * @return
     */
    int updatePassWord(Long id, String passWord, String salt);
}