package com.yunyd.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yunyd.entity.Feedback;
import com.yunyd.mapper.FeedbackMapper;
import com.yunyd.service.FeedbackService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @lyd
 * @date 2024/7/24
*/
@Service
public class FeedbackServiceImpl implements FeedbackService{
    @Resource
    private FeedbackMapper feedbackMapper;

    /**
     * 新增
     */
    public void add(Feedback feedback) {
        feedbackMapper.insert(feedback);
    }

    /**
     * 删除
     */
    public void deleteById(Integer id) {
        feedbackMapper.deleteById(id);
    }

    /**
     * 批量删除
     */
    public void deleteBatch(List<Integer> ids) {
        for (Integer id : ids) {
            feedbackMapper.deleteById(id);
        }
    }

    /**
     * 修改
     */
    public void updateById(Feedback feedback) {
        feedbackMapper.updateById(feedback);
    }

    /**
     * 根据ID查询
     */
    public Feedback selectById(Integer id) {
        return feedbackMapper.selectById(id);
    }

    /**
     * 查询所有
     */
    public List<Feedback> selectAll(Feedback feedback) {
        return feedbackMapper.selectAll(feedback);
    }

    /**
     * 分页查询
     */
    public PageInfo<Feedback> selectPage(Feedback feedback, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Feedback> list = feedbackMapper.selectAll(feedback);
        return PageInfo.of(list);
    }
}




