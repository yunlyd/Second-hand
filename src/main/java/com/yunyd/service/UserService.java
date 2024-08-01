package com.yunyd.service;


import cn.hutool.core.util.ObjectUtil;
import com.yunyd.common.enums.ResultCodeEnum;
import com.yunyd.entity.Account;
import com.yunyd.entity.Admin;
import com.yunyd.entity.User;
import com.github.pagehelper.PageInfo;
import com.yunyd.exception.CustomException;
import com.yunyd.mapper.UserMapper;

import java.util.List;

/**
 * 用户业务处理
 * @lyd
 * @date 2024/7/15
 */
public interface UserService  {

    /**
     * 登录
     */
    Account login(Account account);

    /**
     * 注册
     */
    void register(Account account);

    /**
     * 新增
     */
    void add(User user);

    /**
     * 删除
     */
    void deleteById(Integer id);

    /**
     * 批量删除
     */
    void deleteBatch(List<Integer> ids);

    /**
     * 修改
     */
    void updateById(User user);

    /**
     * 根据ID查询
     */
    User selectById(Integer id);

    /**
     * 查询所有
     */
    List<User> selectAll(User user);

    /**
     * 分页查询
     */
    PageInfo<User> selectPage(User user, Integer pageNum, Integer pageSize);

    /**
     * 修改密码
     */
    void updatePassword(Account account);
}
