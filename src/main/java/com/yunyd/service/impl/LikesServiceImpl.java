package com.yunyd.service.impl;

import com.yunyd.entity.Account;
import com.yunyd.entity.Likes;
import com.yunyd.mapper.LikesMapper;
import com.yunyd.service.LikesService;
import com.yunyd.utils.TokenUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @lyd
 * @date 2024/7/31
*/
@Service
public class LikesServiceImpl implements LikesService{

    @Resource
    private LikesMapper likesMapper;

    /**
     * 点赞与取消点赞
     */
    @Override
    public void add(Likes likes) {
        Account currentUser = TokenUtils.getCurrentUser();
        Integer userId = currentUser.getId();
        Integer fid = likes.getFid();
        Likes dbLikes = likesMapper.selectByUserIdAndFid(userId, fid);
        if (dbLikes != null) {
            likesMapper.deleteById(dbLikes.getId());
        } else {
            likes.setUserId(userId);
            likesMapper.insert(likes);
        }
    }
}




