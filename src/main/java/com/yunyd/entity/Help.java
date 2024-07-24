package com.yunyd.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * 商品求购
 * @lyd
 * @date 2024/7/22
 */
@Data
public class Help implements Serializable {
    /**
     * ID
     */
    private Integer id;

    /**
     * 标题
     */
    private String title;

    /**
     * 内容
     */
    private String content;

    /**
     * 图片
     */
    private String img;

    /**
     * 状态
     */
    private String status;

    /**
     * 用户ID
     */
    private Integer userId;

    /**
     * 发布时间
     */
    private String time;

    /**
     * 是否解决
     */
    private String solved;

    /**
     * 用户名
     */
    private String userName;

    private static final long serialVersionUID = 1L;
}