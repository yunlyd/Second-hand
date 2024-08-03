package com.yunyd.service.impl;

import cn.hutool.core.date.DateUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yunyd.entity.Comment;
import com.yunyd.mapper.CommentMapper;
import com.yunyd.service.CommentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @lyd
 * @date 2024/8/1
*/
@Service
public class CommentServiceImpl implements CommentService{

    @Resource
    private CommentMapper commentMapper;

    /**
     * 新增
     */
    @Override
    public void add(Comment comment) {
        comment.setTime(DateUtil.now());
        commentMapper.insert(comment);

        Integer id = comment.getId();
        //更新 root_id
        if (comment.getPid() == null){
            comment.setRootId(id);
        }else {
            Comment parentComment = commentMapper.selectById(comment.getPid());
            comment.setRootId(parentComment.getRootId());
        }
        this.updateById(comment);
    }

    /**
     * 递归删除
     */
    @Override
    public void deleteById(Integer id) {
        this.deepDelete(id);
    }

    /**
     * 递归删除，每次删除子层评论
     */
    @Override
    public void deepDelete(Integer pid) {
        List<Comment> children = commentMapper.selectByPid(pid);
        commentMapper.deleteById(pid); //变量pid的值，传过来的是id
        for (Comment child : children) {
            this.deepDelete(child.getId());
        }
    }

    /**
     * 批量删除
     */
    @Override
    public void deleteBatch(List<Integer> ids) {
        for (Integer id : ids) {
            commentMapper.deleteById(id);
        }
    }

    /**
     * 修改
     */
    @Override
    public void updateById(Comment comment) {
        commentMapper.updateById(comment);
    }

    /**
     * 根据ID查询
     */
    @Override
    public Comment selectById(Integer id) {
        return commentMapper.selectById(id);
    }

    /**
     * 查询所有
     */
    @Override
    public List<Comment> selectAll(Comment comment) {
        return commentMapper.selectAll(comment);
    }

    /**
     * 分页查询
     */
    @Override
    public PageInfo<Comment> selectPage(Comment comment, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Comment> list = commentMapper.selectAll(comment);
        return PageInfo.of(list);
    }

    /**
     * 查询评论树形列表
     */
    @Override
    public PageInfo<Comment> selectTree(Integer fid, String module, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Comment> comments = commentMapper.selectTree(fid, module);
        PageInfo<Comment> pageInfo = PageInfo.of(comments);
        for (Comment comment : comments) {
            Integer rootId = comment.getRootId();
            List<Comment> children = commentMapper.selectByRootId(rootId);
            comment.setChildren(children);
        }
        return pageInfo;
    }

    /**
     * 查询评论数量
     */
    public Integer selectCount(Integer fid, String module) {
        return commentMapper.selectCount(fid, module);
    }
}




