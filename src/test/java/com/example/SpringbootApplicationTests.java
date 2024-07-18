package com.example;

import com.example.common.Constants;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

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

    @Test
    void testRedisExpired(){
        redisTemplate.opsForValue().set("aaa","aaa", Constants.EXPIRED_TIME, TimeUnit.MINUTES);
        Long aaa = redisTemplate.getExpire("aaa", TimeUnit.MINUTES);
        System.out.println(aaa + "min");
    }
}
