package com.ruoyi.framework.kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class MyKafkaListener {

    @KafkaListener(topics = "topic_demo_001")
    void pullMessage(String message) {
        System.out.println(message);
    }
}
