package com.yunyd.common;

/**
 * 常量类
 * @lyd
 * @date 2024/7/12
 */
public interface Constants {

    String TOKEN = "token";

    String USER_DEFAULT_PASSWORD = "123";

    String REDIS_TOKEN_USER = "token:user:";

    String REDIS_TOKEN_ADMIN = "token:admin:";

    //过期时间阈值
    double THRESHOLD = 0.2;

    //过期时间 30min
    int EXPIRED_TIME = 30;

}
