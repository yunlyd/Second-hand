package com.example.service;


import com.example.entity.User;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * @lyd
 * @date 2024/7/15
 */
public interface UserService  {

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
}