package com.yunyd.entity;

import java.io.Serializable;
import lombok.Data;

/**
 * 反馈信息
 * @lyd
 * @date 2024/7/24
 */
@Data
public class Feedback implements Serializable {
    /**
     * ID
     */
    private Integer id;

    /**
     * 主题
     */
    private String title;

    /**
     * 内容
     */
    private String content;

    /**
     * 联系方式
     */
    private String phone;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 回复
     */
    private String reply;

    /**
     * 创建时间
     */
    private String createtime;

    /**
     * 提交人ID
     */
    private Integer userId;

    /**
     * 用户名
     */
    private String userName;

    private static final long serialVersionUID = 1L;
}