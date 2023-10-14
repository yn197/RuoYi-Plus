package com.ruoyi.common.kafka;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * @author 16074
 */
@Component
public class MyKafkaListener {

    @KafkaListener(topics = "topic_demo_001")
    void pullMessage(String message) {
        System.out.println(message);
    }
}
