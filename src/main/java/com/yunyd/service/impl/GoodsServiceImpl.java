package com.yunyd.service.impl;

import cn.hutool.core.date.DateUtil;
import com.yunyd.common.enums.StatusEnum;
import com.yunyd.entity.Account;
import com.yunyd.entity.Collect;
import com.yunyd.entity.Goods;
import com.yunyd.entity.Likes;
import com.yunyd.mapper.CollectMapper;
import com.yunyd.mapper.GoodsMapper;
import com.yunyd.mapper.LikesMapper;
import com.yunyd.service.GoodsService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yunyd.utils.TokenUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @lyd
 * @date 2024/7/22
*/
@Service
public class GoodsServiceImpl implements GoodsService{

    @Resource
    private GoodsMapper goodsMapper;
    @Resource
    private LikesMapper likesMapper;
    @Resource
    private CollectMapper collectMapper;

    /**
     * 新增
     */
    @Override
    public void add(Goods goods) {
        goods.setDate(DateUtil.now());
        goods.setUserId(TokenUtils.getCurrentUser().getId());
        goods.setStatus(StatusEnum.NOT_AUDIT.value);
        goods.setReadCount(0);
        goodsMapper.insert(goods);
    }

    /**
     * 删除
     */
    @Override
    public void deleteById(Integer id) {
        goodsMapper.deleteById(id);
    }

    /**
     * 批量删除
     */
    @Override
    public void deleteBatch(List<Integer> ids) {
        for (Integer id : ids) {
            goodsMapper.deleteById(id);
        }
    }

    /**
     * 修改
     */
    @Override
    public void updateById(Goods goods) {
        goodsMapper.updateById(goods);
    }

    /**
     * 根据ID查询
     */
    @Override
    public Goods selectById(Integer id) {
        Goods goods = goodsMapper.selectById(id);

        //查当前用户信息
        Account currentUser = TokenUtils.getCurrentUser();
        //查找对应点赞信息
        Likes likes = likesMapper.selectByUserIdAndFid(currentUser.getId(), id);
        goods.setUserLikes(likes != null);
        int likesCount = likesMapper.selectCountByFid(id);
        goods.setLikesCount(likesCount);
        //查找对应收藏信息
        Collect collect = collectMapper.selectByUserIdAndFid(currentUser.getId(), id);
        goods.setUserCollect(collect != null);
        int collectCount = collectMapper.selectCountByFid(id);
        goods.setCollectCount(collectCount);

        return goods;
    }

    /**
     * 查询所有
     */
    @Override
    public List<Goods> selectAll(Goods goods) {
        return goodsMapper.selectAll(goods);
    }

    /**
     * 后台分页查询
     */
    @Override
    public PageInfo<Goods> selectPage(Goods goods, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Goods> list = goodsMapper.selectAll(goods);
        return PageInfo.of(list);
    }

    /**
     * 前台分页查询
     */
    @Override
    public PageInfo<Goods> selectFrontPage(Goods goods, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Goods> list = goodsMapper.selectFrontAll(goods);
        return PageInfo.of(list);
    }

    /**
     * 浏览量 +1
     */
    @Override
    public void updateReadCount(Integer id) {
        goodsMapper.updateReadCount(id);
    }
}




