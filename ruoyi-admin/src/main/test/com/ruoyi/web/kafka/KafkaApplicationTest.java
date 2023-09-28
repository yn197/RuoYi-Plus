package com.ruoyi.web.kafka;

import com.alibaba.fastjson.JSON;
import com.ruoyi.framework.redis.service.RedisService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.core.KafkaTemplate;

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
public class KafkaApplicationTest {

    @Resource
    private KafkaTemplate kafkaTemplate;
    /**
     * 测试引入的kafka是否正常
     */
    @Test
    public void keys() {

        String message = "hello world";
        kafkaTemplate.send("topic_demo_001", JSON.toJSON(message));

    }
}
