package com.example.service;

import com.example.entity.Circles;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * @lyd
 * @date 2024/7/22
*/
public interface CirclesService{

    /**
     * 新增
     */
    void add(Circles circles);

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
    void updateById(Circles circles);

    /**
     * 根据ID查询
     */
    Circles selectById(Integer id);

    /**
     * 查询所有
     */
    List<Circles> selectAll(Circles circles);

    /**
     * 分页查询
     */
    PageInfo<Circles> selectPage(Circles circles, Integer pageNum, Integer pageSize);
}
