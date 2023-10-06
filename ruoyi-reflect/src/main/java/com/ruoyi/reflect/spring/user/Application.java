package com.ruoyi.reflect.spring.user;

import com.ruoyi.reflect.spring.springframework.ApplicationContext;
import com.ruoyi.reflect.spring.user.service.UserService;

import java.io.UnsupportedEncodingException;

/**
 * @author nisang
 * 2023/10/6 10:53
 * @version 1.0
 * Ruoyi-Cloud-Plus开发小组
 */
public class Application {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ApplicationContext(AppConfig.class);
        UserService userService = (UserService) applicationContext.getBean("userService");
        userService.test();
    }
}
