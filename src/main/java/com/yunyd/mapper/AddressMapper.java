package com.yunyd.mapper;

import com.yunyd.entity.Address;

import java.util.List;

/**
 * 操作address相关数据接口
 * @lyd
 * @date 2024/7/24
*/
public interface AddressMapper{

    /**
     * 新增
     */
    int insert(Address address);

    /**
     * 删除
     */
    int deleteById(Integer id);

    /**
     * 修改
     */
    int updateById(Address address);

    /**
     * 根据ID查询
     */
    Address selectById(Integer id);

    /**
     * 查询所有
     */
    List<Address> selectAll(Address address);
}




