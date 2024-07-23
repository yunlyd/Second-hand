package com.example.service.impl;

import com.example.entity.Posts;
import com.example.mapper.PostsMapper;
import com.example.service.PostsService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @lyd
 * @date 2024/7/22
*/
@Service
public class PostsServiceImpl implements PostsService{

    @Resource
    private PostsMapper postsMapper;

    /**
     * 新增
     */
    public void add(Posts posts) {
        postsMapper.insert(posts);
    }

    /**
     * 删除
     */
    public void deleteById(Integer id) {
        postsMapper.deleteById(id);
    }

    /**
     * 批量删除
     */
    public void deleteBatch(List<Integer> ids) {
        for (Integer id : ids) {
            postsMapper.deleteById(id);
        }
    }

    /**
     * 修改
     */
    public void updateById(Posts posts) {
        postsMapper.updateById(posts);
    }

    /**
     * 根据ID查询
     */
    public Posts selectById(Integer id) {
        return postsMapper.selectById(id);
    }

    /**
     * 查询所有
     */
    public List<Posts> selectAll(Posts posts) {
        return postsMapper.selectAll(posts);
    }

    /**
     * 分页查询
     */
    public PageInfo<Posts> selectPage(Posts posts, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Posts> list = postsMapper.selectAll(posts);
        return PageInfo.of(list);
    }
}




