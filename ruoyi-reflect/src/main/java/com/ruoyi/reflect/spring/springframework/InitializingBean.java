package com.ruoyi.reflect.spring.springframework;

/**
 * 初始化Bean的接口，有个方法，
 * @author nisang
 * 2023/10/6 12:49
 * @version 1.0
 * Ruoyi-Cloud-Plus开发小组
 */
public interface InitializingBean {
    /**
     * 在属性填充后执行
     */
    public void afterPropertiesSet();

}
