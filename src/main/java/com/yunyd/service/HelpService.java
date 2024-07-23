package com.yunyd.service;

import com.github.pagehelper.PageInfo;
import com.yunyd.entity.Help;

import java.util.List;

/**
 * @lyd
 * @date 2024/7/22
*/
public interface HelpService{

    /**
     * 新增
     */
    void add(Help help);

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
    void updateById(Help help);

    /**
     * 根据ID查询
     */
    Help selectById(Integer id);

    /**
     * 查询所有
     */
    List<Help> selectAll(Help help);

    /**
     * 分页查询
     */
    PageInfo<Help> selectPage(Help help, Integer pageNum, Integer pageSize);
}
