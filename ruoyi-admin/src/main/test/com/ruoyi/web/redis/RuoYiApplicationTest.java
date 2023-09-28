package com.ruoyi.web.redis;

import com.ruoyi.framework.redis.service.RedisService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.Collection;

/**
 * @author nisang
 * 2023/9/28 10:09
 * @version 1.0
 * Ruoyi-Cloud-Plus开发小组
 */
@SpringBootTest
@Slf4j
public class RuoYiApplicationTest {

    @Resource
    private RedisService redisService;

    /**
     * 测试引入的redis是否正常
     */
    @Test
    public void keys() {

        Collection<String> keys = redisService.keys("sys_config:*");
        if (keys.isEmpty()) {
            log.info("No keys found");
        } else {
            //10:24:58.872 [main] INFO  c.r.w.RuoYiApplicationTest - [keys,32] - Keys found
            log.info("Keys found");
        }

    }
}
