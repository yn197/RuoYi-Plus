package com.ruoyi.reflect.demo;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author nisang
 * 2023/10/5 17:37
 * @version 1.0
 * Ruoyi-Cloud-Plus开发小组
 */
public class DemoTest {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        // 加载类
        Class<Dog> classDog = test1();
        Class<?> classDog2 = test2();
        Class<? extends Dog> classDog3 = test3();
        // 创建类对象
        Object dog = classDog.newInstance();
        // 获取bark方法对象
        Method method = classDog.getDeclaredMethod("bark");
        // 调用方法
        method.invoke(dog);
    }

    static Class<Dog> test1() {
        //1使用Class对象
        Class<Dog> dogClass = Dog.class;
        return dogClass;
    }

    static Class<?> test2() throws ClassNotFoundException {
        //2使用Class.forName()
        return Class.forName("com.ruoyi.reflect.demo.Dog");
    }

    static Class<? extends Dog> test3() {
        //3使用类加载器
        Dog dog = new Dog();
        Class<? extends Dog> dogClass = dog.getClass();
        return dogClass;
    }

}
