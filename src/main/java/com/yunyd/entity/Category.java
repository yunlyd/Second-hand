package com.yunyd.entity;

import java.io.Serializable;
import lombok.Data;

/**
 * 分类
 * @lyd
 * @date 2024/7/18
 */
@Data
public class Category implements Serializable {
    /**
     * ID
     */
    private Integer id;

    /**
     * 名称
     */
    private String name;

    private static final long serialVersionUID = 1L;

}