package com.yunyd.service;

import com.yunyd.entity.Posts;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * @lyd
 * @date 2024/7/22
*/
public interface PostsService {

    /**
     * 新增
     */
    void add(Posts posts);

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
    void updateById(Posts posts);

    /**
     * 根据ID查询
     */
    Posts selectById(Integer id);

    /**
     * 查询所有
     */
    List<Posts> selectAll(Posts posts);

    /**
     * 分页查询
     */
    PageInfo<Posts> selectPage(Posts posts, Integer pageNum, Integer pageSize);
}
