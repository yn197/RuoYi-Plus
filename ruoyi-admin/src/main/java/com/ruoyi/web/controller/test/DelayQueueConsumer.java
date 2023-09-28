package com.ruoyi.web.controller.test;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author nisang
 * 2023/9/5 11:08
 * @version 1.0
 * Ruoyi-Cloud-Plus开发小组
 */
@Slf4j
@Component
public class DelayQueueConsumer {
    /**
     * 队列TTL-消费者
     *
     * @param data
     */
    @RabbitListener(queues = DelayQueueConfig.QUEUE_DEAD)
    public void ddlQueueConsumer(String data) {
        log.info("[*] [{}] 死信队列接收到消息：{}", new Date().toString(), data);
    }
}