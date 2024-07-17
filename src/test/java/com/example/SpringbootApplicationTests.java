package com.example;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

import javax.annotation.Resource;

/**
 * 主类测试
 * @lyd
 * @date 2024/7/17
 */

@SpringBootTest
class SpringbootApplicationTests {

    @Resource
    private RedisTemplate redisTemplate;

    @Test
    void contextLoads() {
        redisTemplate.opsForValue().set("name","Redis测试");
        Object name = redisTemplate.opsForValue().get("name");
        System.out.println("name:" + name);
    }
}
