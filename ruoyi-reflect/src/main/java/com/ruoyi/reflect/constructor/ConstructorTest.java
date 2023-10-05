package com.ruoyi.reflect.constructor;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @author nisang
 * 2023/10/5 18:00
 * @version 1.0
 * Ruoyi-Cloud-Plus开发小组
 */
public class ConstructorTest {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Class<?> classApple = Class.forName("com.ruoyi.reflect.constructor.Apple");

        // 获取无参构造
        Constructor<?> declaredConstructor = classApple.getDeclaredConstructor();
        Object apple = declaredConstructor.newInstance();
        System.out.println(apple);

        // 获取public构造
        Constructor<?> declaredConstructor2 = classApple.getDeclaredConstructor(double.class, String.class);
        Object apple2 = declaredConstructor2.newInstance(14, "黄元帅");
        System.out.println(apple2);

        // 获取参数列表
        Class<?>[] parameterTypes = declaredConstructor2.getParameterTypes();
        for (Class<?> parameterType : parameterTypes) {
            System.out.println("\t\t参数类型:" + parameterType);
        }

        // 获取private构造
        Constructor<?> declaredConstructor3 = classApple.getDeclaredConstructor(double.class);
        // 设置可以访问构造器
        declaredConstructor3.setAccessible(true);
        Object apple3 = declaredConstructor3.newInstance(19);
        System.out.println(apple3);
    }
}
