package com.ruoyi.web.controller.test;

import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * @author nisang
 * 2023/9/5 11:06
 * @version 1.0
 * Ruoyi-Cloud-Plus开发小组
 */
@Configuration
public class DelayQueueConfig {
    // 定义交换机名
    public static final String EXCHANGE_NORMAL = "exchange_normal";
    public static final String EXCHANGE_DEAD = "exchange_dead";

    // 定义队列名
    public static final String QUEUE_NORMAL_1 = "queue_normal_1";
    public static final String QUEUE_NORMAL_2 = "queue_normal_2";
    public static final String QUEUE_DEAD = "queue_dead";

    // 定义路由key
    public static final String ROUTING_NORMAL_1 = "routing_normal_1";
    public static final String ROUTING_NORMAL_2 = "routing_normal_2";
    public static final String ROUTING_DEAD = "routing_dead";

    // 声明交换机
    @Bean
    public DirectExchange ExchangeNormal() {
        return new DirectExchange(EXCHANGE_NORMAL);
    }

    @Bean
    public DirectExchange ExchangeDead() {
        return new DirectExchange(EXCHANGE_DEAD);
    }

    // 声明队列
    @Bean
    public Queue QueueNormal1() {
        Map<String, Object> arguments = new HashMap<>();
        arguments.put("x-dead-letter-exchange", EXCHANGE_DEAD);
        arguments.put("x-dead-letter-routing-key", ROUTING_DEAD);
        arguments.put("x-message-ttl", 10000);
        return new Queue(QUEUE_NORMAL_1, true, false, false, arguments);
    }

    @Bean
    public Queue QueueNormal2() {
        Map<String, Object> arguments = new HashMap<>();
        arguments.put("x-dead-letter-exchange", EXCHANGE_DEAD);
        arguments.put("x-dead-letter-routing-key", ROUTING_DEAD);
        arguments.put("x-message-ttl", 30000);
        return new Queue(QUEUE_NORMAL_2, true, false, false, arguments);
    }

    @Bean
    public Queue QueueDead() {
        return new Queue(QUEUE_DEAD, true, false, false, null);
    }

    // 绑定队列、交换机、路由key
    @Bean
    public Binding QueueNormal1BindingExchangeNormal(
            @Qualifier("QueueNormal1") Queue queueNormal1,
            @Qualifier("ExchangeNormal") Exchange exchangeNormal
    ) {
        return BindingBuilder.bind(queueNormal1).to(exchangeNormal).with(ROUTING_NORMAL_1).noargs();
    }

    @Bean
    public Binding QueueNormal2BindingExchangeNormal(
            @Qualifier("QueueNormal2") Queue queueNormal2,
            @Qualifier("ExchangeNormal") Exchange exchangeNormal
    ) {
        return BindingBuilder.bind(queueNormal2).to(exchangeNormal).with(ROUTING_NORMAL_2).noargs();
    }

    @Bean
    public Binding QueueDeadBindingExchangeDead(
            @Qualifier("QueueDead") Queue queueDead,
            @Qualifier("ExchangeDead") Exchange exchangeDead
    ) {
        return BindingBuilder.bind(queueDead).to(exchangeDead).with(ROUTING_DEAD).noargs();
    }

}