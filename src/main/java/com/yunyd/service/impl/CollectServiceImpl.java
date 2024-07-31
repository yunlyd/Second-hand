package com.yunyd.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yunyd.entity.Account;
import com.yunyd.entity.Collect;
import com.yunyd.entity.Goods;
import com.yunyd.mapper.CollectMapper;
import com.yunyd.service.CollectService;
import com.yunyd.utils.TokenUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @lyd
 * @date 2024/7/31
*/
@Service
public class CollectServiceImpl implements CollectService{

    @Resource
    private CollectMapper collectMapper;

    /**
     * 收藏与取消收藏
     */
    @Override
    public void add(Collect collect) {
        Account currentUser = TokenUtils.getCurrentUser();
        Integer userId = currentUser.getId();
        Integer fid = collect.getFid();
        Collect dbCollect = collectMapper.selectByUserIdAndFid(userId, fid);
        if (dbCollect != null) {
            collectMapper.deleteById(dbCollect.getId());
        } else {
            collect.setUserId(userId);
            collectMapper.insert(collect);
        }
    }

    /**
     * 分页查询
     */
    @Override
    public PageInfo<Collect> selectPage(Integer pageNum, Integer pageSize) {
        Account currentUser = TokenUtils.getCurrentUser();
        PageHelper.startPage(pageNum, pageSize);
        List<Collect> list = collectMapper.selectAll(currentUser.getId());
        return PageInfo.of(list);
    }

    @Override
    public void deleteById(Integer id) {
        collectMapper.deleteById(id);
    }

    @Override
    public void deleteBatch(List<Integer> ids) {
        for (Integer id : ids) {
            collectMapper.deleteById(id);
        }
    }

}




