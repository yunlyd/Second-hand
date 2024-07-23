package com.yunyd.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yunyd.entity.Help;
import com.yunyd.mapper.HelpMapper;
import com.yunyd.service.HelpService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @lyd
 * @date 2024/7/22
*/
@Service
public class HelpServiceImpl implements HelpService{

    @Resource
    private HelpMapper helpMapper;

    /**
     * 新增
     */
    public void add(Help help) {
        helpMapper.insert(help);
    }

    /**
     * 删除
     */
    public void deleteById(Integer id) {
        helpMapper.deleteById(id);
    }

    /**
     * 批量删除
     */
    public void deleteBatch(List<Integer> ids) {
        for (Integer id : ids) {
            helpMapper.deleteById(id);
        }
    }

    /**
     * 修改
     */
    public void updateById(Help help) {
        helpMapper.updateById(help);
    }

    /**
     * 根据ID查询
     */
    public Help selectById(Integer id) {
        return helpMapper.selectById(id);
    }

    /**
     * 查询所有
     */
    public List<Help> selectAll(Help help) {
        return helpMapper.selectAll(help);
    }

    /**
     * 分页查询
     */
    public PageInfo<Help> selectPage(Help help, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Help> list = helpMapper.selectAll(help);
        return PageInfo.of(list);
    }
}




