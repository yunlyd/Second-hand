package com.yunyd.mapper;

import com.yunyd.entity.Circles;

import java.util.List;

/**
 * 操作circles相关数据接口
 * @lyd
 * @date 2024/7/22
*/
public interface CirclesMapper{

    /**
     * 新增
     */
    int insert(Circles circles);

    /**
     * 删除
     */
    int deleteById(Integer id);

    /**
     * 修改
     */
    int updateById(Circles circles);

    /**
     * 根据ID查询
     */
    Circles selectById(Integer id);

    /**
     * 查询所有
     */
    List<Circles> selectAll(Circles circles);
}




