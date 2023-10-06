package com.ruoyi.reflect.spring.springframework;

/**
 * Bean后置处理器接口
 * @author nisang
 * 2023/10/6 11:53
 * @version 1.0
 * Ruoyi-Cloud-Plus开发小组
 */
public interface BeanPostProcessor {
    /**
     * 在Bean 的初始化方法（如 @PostConstruct 注解的方法）被调用之前被自动调用
     * @param beanName
     * @param bean
     * @return
     */
    public Object postProcessBeforeInitialization(String beanName,Object bean);

    /**
     * 在 Bean 的初始化方法被调用之后被自动调用
     * @param beanName
     * @param bean
     * @return
     */
    public Object postProcessAfterInitialization(String beanName,Object bean);
}
