package com.yunyd.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yunyd.common.enums.RoleEnum;
import com.yunyd.entity.Account;
import com.yunyd.entity.Address;
import com.yunyd.mapper.AddressMapper;
import com.yunyd.service.AddressService;
import com.yunyd.utils.TokenUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @lyd
 * @date 2024/7/24
*/
@Service
public class AddressServiceImpl implements AddressService{

    @Resource
    private AddressMapper addressMapper;

    /**
     * 新增
     */
    @Override
    public void add(Address address) {
        Account currentUser = TokenUtils.getCurrentUser();
        address.setUserId(currentUser.getId());
        addressMapper.insert(address);
    }

    /**
     * 删除
     */
    @Override
    public void deleteById(Integer id) {
        addressMapper.deleteById(id);
    }

    /**
     * 批量删除
     */
    @Override
    public void deleteBatch(List<Integer> ids) {
        for (Integer id : ids) {
            addressMapper.deleteById(id);
        }
    }

    /**
     * 修改
     */
    @Override
    public void updateById(Address address) {
        addressMapper.updateById(address);
    }

    /**
     * 根据ID查询
     */
    @Override
    public Address selectById(Integer id) {
        return addressMapper.selectById(id);
    }

    /**
     * 查询所有
     */
    @Override
    public List<Address> selectAll(Address address) {
        Account currentUser = TokenUtils.getCurrentUser();
        if (RoleEnum.USER.name().equals(currentUser.getRole())) {
            address.setUserId(currentUser.getId());
        }
        return addressMapper.selectAll(address);
    }

    /**
     * 分页查询
     */
    @Override
    public PageInfo<Address> selectPage(Address address, Integer pageNum, Integer pageSize) {
        Account currentUser = TokenUtils.getCurrentUser();
        if (RoleEnum.USER.name().equals(currentUser.getRole())) {
            address.setUserId(currentUser.getId());
        }
        PageHelper.startPage(pageNum, pageSize);
        List<Address> list = addressMapper.selectAll(address);
        return PageInfo.of(list);
    }
}




