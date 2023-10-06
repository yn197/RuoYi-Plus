package com.ruoyi.reflect.spring.user;

import com.ruoyi.reflect.spring.springframework.BeanPostProcessor;
import com.ruoyi.reflect.spring.springframework.Component;

/**
 * @author nisang
 * 2023/10/6 11:51
 * @version 1.0
 * Ruoyi-Cloud-Plus开发小组
 */
@Component
public class AopBeanPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(String beanName, Object bean) {
        if ("userService".equals(beanName)) {
            System.out.println("BeanPostProcessor实现类的postProcessBeforeInitialization()方法");
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(String beanName, Object bean) {
        if ("userService".equals(beanName)) {
            System.out.println("BeanPostProcessor实现类的postProcessAfterInitialization()方法");
        }
        return bean;
    }
}
