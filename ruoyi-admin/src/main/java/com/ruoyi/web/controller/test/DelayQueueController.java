package com.ruoyi.web.controller.test;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author nisang
 * 2023/9/5 11:09
 * @version 1.0
 * Ruoyi-Cloud-Plus开发小组
 */
@Slf4j
@RestController
@RequestMapping("/api/delay/queue")
public class DelayQueueController {

    @Autowired
    RabbitTemplate rabbitTemplate;

    /**
     * 队列TTL-生产者
     *
     * @param msg
     * @return
     */
    @RequestMapping("/ttl/queue/producer/{msg}")
    public String TtlQueueProducer(@PathVariable String msg) {
        log.info("[*] 准备发送消息：{}", msg);

        rabbitTemplate.convertAndSend(DelayQueueConfig.EXCHANGE_NORMAL, DelayQueueConfig.ROUTING_NORMAL_1, msg);
        rabbitTemplate.convertAndSend(DelayQueueConfig.EXCHANGE_NORMAL, DelayQueueConfig.ROUTING_NORMAL_2, msg);

        return JSON.toJSONString("消息发送成功");
    }
}