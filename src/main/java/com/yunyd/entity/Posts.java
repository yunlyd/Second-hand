package com.yunyd.entity;

import java.io.Serializable;
import lombok.Data;

/**
 * 帖子
 * @lyd
 * @date 2024/7/22
 */
@Data
public class Posts implements Serializable {
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
     * 用户ID
     */
    private Integer userId;

    /**
     * 发布时间
     */
    private String time;

    /**
     * 圈子
     */
    private String circle;

    /**
     * 简介
     */
    private String descr;

    /**
     * 浏览量
     */
    private Integer readCount;

    /**
     * 审核状态
     */
    private String status;

    private static final long serialVersionUID = 1L;

}