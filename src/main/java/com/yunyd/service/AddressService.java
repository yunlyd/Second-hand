package com.yunyd.service;

import com.github.pagehelper.PageInfo;
import com.yunyd.entity.Address;

import java.util.List;

/**
 * 收获地址业务处理
 * @lyd
 * @date 2024/7/24
*/
public interface AddressService {

    /**
     * 新增
     */
    void add(Address address);

    /**
     * 删除
     */
    void deleteById(Integer id);

    /**
     * 批量删除
     */
    void deleteBatch(List<Integer> ids);

    /**
     * 修改
     */
    void updateById(Address address);

    /**
     * 根据ID查询
     */
    Address selectById(Integer id);

    /**
     * 查询所有
     */
    List<Address> selectAll(Address address);

    /**
     * 分页查询
     */
    PageInfo<Address> selectPage(Address address, Integer pageNum, Integer pageSize);
}
