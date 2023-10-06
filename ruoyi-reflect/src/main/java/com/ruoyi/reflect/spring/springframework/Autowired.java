package com.ruoyi.reflect.spring.springframework;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author nisang
 * 2023/10/6 10:57
 * @version 1.0
 * Ruoyi-Cloud-Plus开发小组
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Autowired {
    boolean required() default true;
}