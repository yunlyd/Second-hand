package com.yunyd.entity;

import java.io.Serializable;
import lombok.Data;

/**
 * 圈子
 * @lyd
 * @date 2024/7/22
 */
@Data
public class Circles implements Serializable {
    /**
     * ID
     */
    private Integer id;

    /**
     * 缩略图
     */
    private String img;

    /**
     * 名称
     */
    private String name;

    private static final long serialVersionUID = 1L;

}