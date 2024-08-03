package com.yunyd.entity;

import java.io.Serializable;
import java.util.List;

import lombok.Data;

/**
 * 评论表
 * @lyd
 * @date 2024/8/1
 */
@Data
public class Comment implements Serializable {
    /**
     * ID
     */
    private Integer id;

    /**
     * 内容
     */
    private String content;

    /**
     * 评论人
     */
    private Integer userId;

    /**
     * 父级ID
     */
    private Integer pid;

    /**
     * 评论时间
     */
    private String time;

    /**
     * 关联ID
     */
    private Integer fid;

    /**
     * 模块
     */
    private String module;

    /**
     * 根节点ID
     */
    private Integer rootId;

    /**
     * 用户名
     */
    private String userName;

    /**
     * 头像
     */
    private String avatar;

    /**
     * 父名字
     */
    private String parentUserName;

    /**
     * 子集评论
     */
    private List<Comment> children;

    private static final long serialVersionUID = 1L;
}