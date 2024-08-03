package com.yunyd.controller;

import com.github.pagehelper.PageInfo;
import com.yunyd.common.Result;
import com.yunyd.entity.Comment;
import com.yunyd.service.CommentService;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import java.util.List;

/**
 * 评论表前端操作接口
 **/
@RestController
@RequestMapping("/comment")
public class CommentController {

    @Resource
    private CommentService commentService;

    /**
     * 新增
     */
    @PostMapping("/add")
    public Result add(@RequestBody Comment comment) {
        commentService.add(comment);
        return Result.success();
    }

    /**
     * 递归删除，给管理员使用
     */
    @DeleteMapping("/delete/{id}")
    public Result deleteById(@PathVariable Integer id) {
        commentService.deleteById(id);
        return Result.success();
    }

    /**
     * 批量删除
     */
    @DeleteMapping("/delete/batch")
    public Result deleteBatch(@RequestBody List<Integer> ids) {
        commentService.deleteBatch(ids);
        return Result.success();
    }

    /**
     * 修改
     */
    @PutMapping("/update")
    public Result updateById(@RequestBody Comment comment) {
        commentService.updateById(comment);
        return Result.success();
    }

    /**
     * 根据ID查询
     */
    @GetMapping("/selectById/{id}")
    public Result selectById(@PathVariable Integer id) {
        Comment comment = commentService.selectById(id);
        return Result.success(comment);
    }

    /**
     * 查询所有
     */
    @GetMapping("/selectAll")
    public Result selectAll(Comment comment) {
        List<Comment> list = commentService.selectAll(comment);
        return Result.success(list);
    }

    /**
     * 分页查询
     */
    @GetMapping("/selectPage")
    public Result selectPage(Comment comment,
                             @RequestParam(defaultValue = "1") Integer pageNum,
                             @RequestParam(defaultValue = "10") Integer pageSize) {
        PageInfo<Comment> page = commentService.selectPage(comment, pageNum, pageSize);
        return Result.success(page);
    }

    /**
     * 查询评论树形列表
     */
    @GetMapping("/selectTree/{fid}/{module}")
    public Result selectTree(@PathVariable Integer fid, @PathVariable String module,
                             @RequestParam(defaultValue = "1") Integer pageNum,
                             @RequestParam(defaultValue = "5") Integer pageSize) {
        PageInfo<Comment> pageInfo = commentService.selectTree(fid, module, pageNum, pageSize);
        return Result.success(pageInfo);
    }

    /**
     * 查询评论数量
     */
    @GetMapping("/selectCount/{fid}/{module}")
    public Result selectCount(@PathVariable Integer fid, @PathVariable String module) {
        Integer count = commentService.selectCount(fid, module);
        return Result.success(count);
    }

}