package com.yunyd.service;

import com.github.pagehelper.PageInfo;
import com.yunyd.entity.Orders;

import java.util.List;

/**
 * 订单业务处理
 * @lyd
 * @date 2024/8/8
*/
public interface OrdersService{

    /**
     * 新增
     */
    void add(Orders orders);

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
    void updateById(Orders orders);

    /**
     * 根据ID查询
     */
    Orders selectById(Integer id);

    /**
     * 查询所有
     */
    List<Orders> selectAll(Orders orders);

    /**
     * 分页查询
     */
    PageInfo<Orders> selectPage(Orders orders, Integer pageNum, Integer pageSize);
}
