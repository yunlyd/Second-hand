package com.yunyd.entity;

import java.io.Serializable;
import lombok.Data;

/**
 * 收货地址
 * @lyd
 * @date 2024/7/24
 */
@Data
public class Address implements Serializable {
    /**
     * ID
     */
    private Integer id;

    /**
     * 联系人
     */
    private String name;

    /**
     * 联系地址
     */
    private String address;

    /**
     * 联系电话
     */
    private String phone;

    /**
     * 关联用户
     */
    private Integer userId;

    /**
     * 用户名
     */
    private String userName;

    private static final long serialVersionUID = 1L;

}