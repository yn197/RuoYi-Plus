package com.ruoyi.web.controller.test;

import com.ruoyi.web.service.TestAsyncService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author nisang
 * 2023/8/30 14:05
 * @version 1.0
 * Ruoyi-Cloud-Plus开发小组
 */
@RequestMapping("api/test")
@RestController
public class TestAsyncController {
    @Resource
    private TestAsyncService testAsyncService;

    @GetMapping("/asyn")
    public void testAsync() throws InterruptedException {
        testAsyncService.service1();
        testAsyncService.service2();

    }
}
