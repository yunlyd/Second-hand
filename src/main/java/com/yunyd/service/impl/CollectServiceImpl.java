package com.yunyd.service.impl;

import com.yunyd.entity.Account;
import com.yunyd.entity.Collect;
import com.yunyd.mapper.CollectMapper;
import com.yunyd.service.CollectService;
import com.yunyd.utils.TokenUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

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
}




