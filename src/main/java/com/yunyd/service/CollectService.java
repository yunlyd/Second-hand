package com.yunyd.service;

import com.yunyd.entity.Collect;

/**
 * 商品收藏业务处理
 * @lyd
 * @date 2024/7/31
*/
public interface CollectService {

    /**
     * 收藏与取消收藏
     */
    void add(Collect collect);
}
