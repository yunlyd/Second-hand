package com.yunyd.mapper;

import com.yunyd.entity.Posts;

import java.util.List;

/**
 * @lyd
 * @date 2024/7/23
*/
public interface PostsMapper {

    /**
     * 新增
     */
    int insert(Posts posts);

    /**
     * 删除
     */
    int deleteById(Integer id);

    /**
     * 修改
     */
    int updateById(Posts posts);

    /**
     * 根据ID查询
     */
    Posts selectById(Integer id);

    /**
     * 查询所有
     */
    List<Posts> selectAll(Posts posts);
}




