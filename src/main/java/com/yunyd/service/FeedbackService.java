package com.yunyd.service;

import com.github.pagehelper.PageInfo;
import com.yunyd.entity.Feedback;

import java.util.List;

/**
 * 反馈信息业务处理
 * @lyd
 * @date 2024/7/24
*/
public interface FeedbackService {

    /**
     * 新增
     */
    void add(Feedback feedback);

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
    void updateById(Feedback feedback);

    /**
     * 根据ID查询
     */
    Feedback selectById(Integer id);

    /**
     * 查询所有
     */
    List<Feedback> selectAll(Feedback feedback);

    /**
     * 分页查询
     */
    PageInfo<Feedback> selectPage(Feedback feedback, Integer pageNum, Integer pageSize);
}
