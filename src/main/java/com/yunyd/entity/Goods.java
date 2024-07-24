package com.yunyd.entity;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 二手商品
 * @lyd
 * @date 2024/7/22
 */
@Data
public class Goods implements Serializable {
    /**
     * ID
     */
    private Integer id;

    /**
     * 名称
     */
    private String name;

    /**
     * 价格
     */
    private BigDecimal price;

    /**
     * 详情
     */
    private String content;

    /**
     * 发货地址
     */
    private String address;

    /**
     * 图片
     */
    private String img;

    /**
     * 上架日期
     */
    private String date;

    /**
     * 审核状态
     */
    private String status;

    /**
     * 分类
     */
    private String category;

    /**
     * 所属用户ID
     */
    private Integer userId;

    /**
     * 上架状态
     */
    private String saleStatus;

    /**
     * 用户名
     */
    private String userName;

    /**
     * 浏览量
     */
    private Integer readCount;

    private static final long serialVersionUID = 1L;

}