package com.yunyd.mapper;

import com.yunyd.entity.Goods;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * 操作goods相关数据接口
 * @lyd
 * @date 2024/7/22
*/
public interface GoodsMapper {

    /**
     * 新增
     */
    int insert(Goods goods);

    /**
     * 删除
     */
    int deleteById(Integer id);

    /**
     * 修改
     */
    int updateById(Goods goods);

    /**
     * 根据ID查询
     */
    Goods selectById(Integer id);

    /**
     * 查询所有
     */
    List<Goods> selectAll(Goods goods);

    /**
     * 前台分页查询
     */
    List<Goods> selectFrontAll(Goods goods);

    /**
     * 浏览量 +1
     */
    @Update("update goods set read_count = read_count + 1 where id = #{id}")
    void updateReadCount(Integer id);
}




