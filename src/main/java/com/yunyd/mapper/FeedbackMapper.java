package com.yunyd.mapper;

import com.yunyd.entity.Feedback;

import java.util.List;

/**
 * 操作feedback相关数据接口
 * @lyd
 * @date 2024/7/24
*/
public interface FeedbackMapper {

    /**
     * 新增
     */
    int insert(Feedback feedback);

    /**
     * 删除
     */
    int deleteById(Integer id);

    /**
     * 修改
     */
    int updateById(Feedback feedback);

    /**
     * 根据ID查询
     */
    Feedback selectById(Integer id);

    /**
     * 查询所有
     */
    List<Feedback> selectAll(Feedback feedback);
}




