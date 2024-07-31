package com.yunyd.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yunyd.entity.Collect;
import com.yunyd.entity.Goods;

import java.util.List;

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

    /**
     * 分页查询
     */
    PageInfo<Collect> selectPage(Integer pageNum, Integer pageSize);

    /**
     * 删除
     */
    void deleteById(Integer id);

    /**
     * 批量删除
     */
    void deleteBatch(List<Integer> ids);
}
