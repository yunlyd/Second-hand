package com.yunyd.service;

import com.github.pagehelper.PageInfo;
import com.yunyd.entity.Comment;

import java.util.List;

/**
 * 评论业务处理
 * @lyd
 * @date 2024/8/1
*/
public interface CommentService {

    /**
     * 新增
     */
    void add(Comment comment);

    /**
     * 递归删除
     */
    void deleteById(Integer id);

    /**
     * 递归删除，每次删除子层评论
     */
    void deepDelete(Integer pid);

    /**
     * 批量删除
     */
    void deleteBatch(List<Integer> ids);

    /**
     * 修改
     */
    void updateById(Comment comment);

    /**
     * 根据ID查询
     */
    Comment selectById(Integer id);

    /**
     * 查询所有
     */
    List<Comment> selectAll(Comment comment);

    /**
     * 分页查询
     */
    PageInfo<Comment> selectPage(Comment comment, Integer pageNum, Integer pageSize);

    /**
     * 查询评论树形列表
     */
    PageInfo<Comment> selectTree(Integer fid, String module, Integer pageNum, Integer pageSize);

    /**
     * 查询评论数量
     */
    Integer selectCount(Integer fid, String module);
}
