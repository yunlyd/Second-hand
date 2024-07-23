package com.yunyd.service.impl;

import cn.hutool.core.date.DateUtil;
import com.yunyd.entity.Account;
import com.yunyd.entity.Posts;
import com.yunyd.mapper.PostsMapper;
import com.yunyd.service.PostsService;
import com.yunyd.utils.TokenUtils;
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
        posts.setTime(DateUtil.now());
        Account currentUser = TokenUtils.getCurrentUser();
        posts.setUserId(currentUser.getId());
        posts.setStatus("待审核");
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




