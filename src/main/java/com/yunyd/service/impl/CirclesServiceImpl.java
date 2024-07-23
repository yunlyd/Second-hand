package com.yunyd.service.impl;

import com.yunyd.entity.Circles;
import com.yunyd.mapper.CirclesMapper;
import com.yunyd.service.CirclesService;
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
public class CirclesServiceImpl implements CirclesService{

    @Resource
    private CirclesMapper circlesMapper;

    /**
     * 新增
     */
    public void add(Circles circles) {
        circlesMapper.insert(circles);
    }

    /**
     * 删除
     */
    public void deleteById(Integer id) {
        circlesMapper.deleteById(id);
    }

    /**
     * 批量删除
     */
    public void deleteBatch(List<Integer> ids) {
        for (Integer id : ids) {
            circlesMapper.deleteById(id);
        }
    }

    /**
     * 修改
     */
    public void updateById(Circles circles) {
        circlesMapper.updateById(circles);
    }

    /**
     * 根据ID查询
     */
    public Circles selectById(Integer id) {
        return circlesMapper.selectById(id);
    }

    /**
     * 查询所有
     */
    public List<Circles> selectAll(Circles circles) {
        return circlesMapper.selectAll(circles);
    }

    /**
     * 分页查询
     */
    public PageInfo<Circles> selectPage(Circles circles, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Circles> list = circlesMapper.selectAll(circles);
        return PageInfo.of(list);
    }
}




