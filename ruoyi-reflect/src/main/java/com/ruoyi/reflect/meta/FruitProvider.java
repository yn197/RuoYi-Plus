package com.ruoyi.reflect.meta;

import java.lang.annotation.*;
/**
 * @author nisang
 * 2023/10/5 20:34
 * @version 1.0
 * Ruoyi-Cloud-Plus开发小组
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface FruitProvider {
    //供应商编号
    public int id() default -1;
    //供应商名称
    public String name() default "";
    //供应商地址
    public String address() default "";
}
