package com.yunyd.service.impl;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.RandomUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yunyd.common.enums.OrderStatusEnum;
import com.yunyd.entity.Account;
import com.yunyd.entity.Address;
import com.yunyd.entity.Goods;
import com.yunyd.entity.Orders;
import com.yunyd.mapper.OrdersMapper;
import com.yunyd.service.AddressService;
import com.yunyd.service.GoodsService;
import com.yunyd.service.OrdersService;
import com.yunyd.utils.TokenUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @lyd
 * @date 2024/8/8
*/
@Service
public class OrdersServiceImpl implements OrdersService{

    @Resource
    private OrdersMapper ordersMapper;

    @Resource
    private GoodsService goodsService;

    @Resource
    private AddressService addressService;

    /**
     * 新增
     */
    public void add(Orders orders) {
        Integer goodsId = orders.getGoodsId();
        Goods goods = goodsService.selectById(goodsId);
        orders.setGoodsName(goods.getName());
        orders.setGoodsImg(goods.getImg());
        orders.setSaleId(goods.getUserId());  //卖家用户ID
        orders.setTotal(goods.getPrice());

        Integer addressId = orders.getAddressId();
        Address address = addressService.selectById(addressId);
        orders.setUserName(address.getUserName());
        orders.setAddress(address.getAddress());
        orders.setPhone(address.getPhone());

        Account currentUser = TokenUtils.getCurrentUser();
        orders.setUserId(currentUser.getId());  //下单人的ID
        orders.setStatus(OrderStatusEnum.NOTPAY.value); // 订单默认是待支付
        orders.setOrderNo(System.currentTimeMillis() + RandomUtil.randomNumbers(7)); // 20位的订单号
        orders.setTime(DateUtil.now());

        ordersMapper.insert(orders);
    }

    /**
     * 删除
     */
    public void deleteById(Integer id) {
        ordersMapper.deleteById(id);
    }

    /**
     * 批量删除
     */
    public void deleteBatch(List<Integer> ids) {
        for (Integer id : ids) {
            ordersMapper.deleteById(id);
        }
    }

    /**
     * 修改
     */
    public void updateById(Orders orders) {
        ordersMapper.updateById(orders);
    }

    /**
     * 根据ID查询
     */
    public Orders selectById(Integer id) {
        return ordersMapper.selectById(id);
    }

    /**
     * 查询所有
     */
    public List<Orders> selectAll(Orders orders) {
        return ordersMapper.selectAll(orders);
    }

    /**
     * 分页查询
     */
    public PageInfo<Orders> selectPage(Orders orders, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Orders> list = ordersMapper.selectAll(orders);
        return PageInfo.of(list);
    }
}




