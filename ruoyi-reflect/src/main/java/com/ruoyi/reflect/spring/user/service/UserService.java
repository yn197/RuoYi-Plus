package com.ruoyi.reflect.spring.user.service;

import com.ruoyi.reflect.spring.springframework.*;

/**
 * @author nisang
 * 2023/10/6 10:56
 * @version 1.0
 * Ruoyi-Cloud-Plus开发小组
 */
@Component
@Transactional
public class UserService implements BeanNameAware, ApplicationContextAware,InitializingBean {

    @Autowired
    private OrderService orderService;

    private ApplicationContext applicationContext;
    private String beanName;

    public void test(){
        System.out.println(orderService);
        System.out.println(applicationContext);
        System.out.println(beanName);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    @Override
    public void setBeanName(String name) {
        this.beanName = name;
    }

    @Override
    public void afterPropertiesSet() {
        System.out.println("初始化之前执行的InitializingBean方法");
    }
}