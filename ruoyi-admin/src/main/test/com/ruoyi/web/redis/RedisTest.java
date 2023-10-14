package com.ruoyi.web.redis;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

import javax.annotation.Resource;
import java.util.Set;

/**
 * @author nisang
 * 2023/10/14 10:17
 * @version 1.0
 * Ruoyi-Cloud-Plus开发小组
 */
@SpringBootTest
@Slf4j
public class RedisTest {

    @Resource
    public RedisTemplate redisTemplate;

    @Test
    public void test() {
        Set keys = redisTemplate.keys("sys_config:*");
        if (keys.isEmpty()) {
            log.info("No keys");
        } else {
            log.info("keys is exists");
        }
    }
}
