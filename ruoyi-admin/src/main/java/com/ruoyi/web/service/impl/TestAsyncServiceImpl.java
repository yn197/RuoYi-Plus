package com.ruoyi.web.service.impl;

import com.ruoyi.web.service.TestAsyncService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * @author nisang
 * 2023/8/30 11:16
 * @version 1.0
 * Ruoyi-Cloud-Plus开发小组
 */
@Service
public class TestAsyncServiceImpl implements TestAsyncService {
    Logger log = LoggerFactory.getLogger(TestAsyncService.class);

    // 发送提醒短信 1
    @Async("threadPoolTaskExecutor")
    public void service1() throws InterruptedException {
        log.info("--------start-service1------------");
        Thread.sleep(5000); // 模拟耗时
        log.info("--------end-service1------------");
    }

    // 发送提醒短信 2
    @Async("threadPoolTaskExecutor")
    public void service2() throws InterruptedException {

        log.info("--------start-service2------------");
        Thread.sleep(2000); // 模拟耗时
        log.info("--------end-service2------------");

    }
}
