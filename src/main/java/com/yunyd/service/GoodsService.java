package com.yunyd.service;

import com.yunyd.entity.Goods;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * @lyd
 * @date 2024/7/22
*/
public interface GoodsService {

    /**
     * 新增
     */
    void add(Goods goods);

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
    void updateById(Goods goods);

    /**
     * 根据ID查询
     */
    Goods selectById(Integer id);

    /**
     * 查询所有
     */
    List<Goods> selectAll(Goods goods);

    /**
     * 分页查询
     */
    PageInfo<Goods> selectPage(Goods goods, Integer pageNum, Integer pageSize);
}
