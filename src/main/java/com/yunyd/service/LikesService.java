package com.yunyd.service;

import com.yunyd.entity.Likes;

/**
 * 商品点赞业务处理
 * @lyd
 * @date 2024/7/31
*/
public interface LikesService {

    /**
     * 点赞与取消点赞
     */
    void add(Likes likes);
}
