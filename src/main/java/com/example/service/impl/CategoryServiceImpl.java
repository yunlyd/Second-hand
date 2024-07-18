package com.example.service.impl;

import com.example.entity.Category;
import com.example.mapper.CategoryMapper;
import com.example.service.CategoryService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @lyd
 * @date 2024/7/18
 */
@Service
public class CategoryServiceImpl implements CategoryService{

    @Resource
    private CategoryMapper categoryMapper;

    /**
     * 新增
     */
    @Override
    public void add(Category category) {
        categoryMapper.insert(category);
    }

    /**
     * 删除
     */
    @Override
    public void deleteById(Integer id) {
        categoryMapper.deleteById(id);
    }

    /**
     * 批量删除
     */
    @Override
    public void deleteBatch(List<Integer> ids) {
        for (Integer id : ids) {
            categoryMapper.deleteById(id);
        }
    }

    /**
     * 修改
     */
    @Override
    public void updateById(Category category) {
        categoryMapper.updateById(category);
    }

    /**
     * 根据ID查询
     */
    @Override
    public Category selectById(Integer id) {
        return categoryMapper.selectById(id);
    }

    /**
     * 查询所有
     */
    @Override
    public List<Category> selectAll(Category category) {
        return categoryMapper.selectAll(category);
    }

    /**
     * 分页查询
     */
    @Override
    public PageInfo<Category> selectPage(Category category, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Category> list = categoryMapper.selectAll(category);
        return PageInfo.of(list);
    }
}




