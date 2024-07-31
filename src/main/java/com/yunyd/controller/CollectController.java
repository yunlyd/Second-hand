package com.yunyd.controller;

import com.github.pagehelper.PageInfo;
import com.yunyd.common.Result;
import com.yunyd.entity.Collect;
import com.yunyd.entity.Goods;
import com.yunyd.service.CollectService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/collect")
public class CollectController {

    @Resource
    private CollectService collectService;

    /**
     * 收藏与取消收藏
     */
    @PostMapping("/add")
    public Result add(@RequestBody Collect collect) {
        collectService.add(collect);
        return Result.success();
    }

    /**
     * 分页查询
     */
    @GetMapping("/selectPage")
    public Result selectPage(@RequestParam(defaultValue = "1") Integer pageNum,
                             @RequestParam(defaultValue = "10") Integer pageSize) {
        PageInfo<Collect> page = collectService.selectPage( pageNum, pageSize);
        return Result.success(page);
    }

    /**
     * 删除
     */
    @DeleteMapping("/delete/{id}")
    public Result deleteById(@PathVariable Integer id) {
        collectService.deleteById(id);
        return Result.success();
    }

    /**
     * 批量删除
     */
    @DeleteMapping("/delete/batch")
    public Result deleteBatch(@RequestBody List<Integer> ids) {
        collectService.deleteBatch(ids);
        return Result.success();
    }
}