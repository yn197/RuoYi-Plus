package com.ruoyi.reflect.field;

import java.lang.reflect.Field;

/**
 * @author nisang
 * 2023/10/5 17:58
 * @version 1.0
 * Ruoyi-Cloud-Plus开发小组
 */
public class FieldTest {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        // 加载类
        Class<?> classAsianPerson = Class.forName("com.ruoyi.reflect.field.AsianPerson");
        // 创建类实例
        Object person = classAsianPerson.newInstance();

        // 获取public属性对象
        Field field = classAsianPerson.getField("weight");
        System.out.println("修改前weight:" + field.get(person));
        field.set(person, 120);
        System.out.println("修改后weight:" + field.get(person));
        System.out.println();

        // 获取属性类型
        System.out.println("weight变量类型:" + field.getType());
        System.out.println();

        // 获取private属性对象
        Field field2 = classAsianPerson.getDeclaredField("height");
        // 设置允许访问field2
        field2.setAccessible(true);
        System.out.println("修改前height:" + field2.get(person));
        field2.set(person, 175);
        System.out.println("修改后height:" + field2.get(person));
        System.out.println();

        // 获取静态属性对象
        Field field3 = classAsianPerson.getDeclaredField("IQ");
        // 设置允许访问field3
        field3.setAccessible(true);
        System.out.println("修改前IQ:" + field3.get(person));
        field3.set(person, 201);
        System.out.println("修改后IQ:" + field3.get(person));
        // 静态属性可以使用null
        field3.set(null, 250);
        System.out.println("修改后IQ:" + field3.get(null));
        System.out.println();
    }
}
