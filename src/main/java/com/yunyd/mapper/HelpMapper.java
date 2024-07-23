package com.yunyd.mapper;

import com.yunyd.entity.Help;

import java.util.List;

/**
 * @lyd
 * @date 2024/7/22
*/
public interface HelpMapper{
    /**
     * 新增
     */
    int insert(Help help);

    /**
     * 删除
     */
    int deleteById(Integer id);

    /**
     * 修改
     */
    int updateById(Help help);

    /**
     * 根据ID查询
     */
    Help selectById(Integer id);

    /**
     * 查询所有
     */
    List<Help> selectAll(Help help);
}




