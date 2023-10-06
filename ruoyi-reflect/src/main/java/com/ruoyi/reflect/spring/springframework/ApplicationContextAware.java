package com.ruoyi.reflect.spring.springframework;

/**
 * @author nisang
 * 2023/10/6 10:59
 * @version 1.0
 * Ruoyi-Cloud-Plus开发小组
 */
public interface ApplicationContextAware {
    /**
     * Sets application context.
     *
     * @param applicationContext the application context
     */
    void setApplicationContext(ApplicationContext applicationContext);
}
