package com.ruoyi.reflect.method;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author nisang
 * 2023/10/5 18:00
 * @version 1.0
 * Ruoyi-Cloud-Plus开发小组
 */
public class MethodTest {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Class classMobilePhone = Class.forName("com.ruoyi.reflect.method.MobilePhone");
        Object phone = classMobilePhone.newInstance();

        // 获取public方法
        Method method = classMobilePhone.getMethod("listenMusic", String.class);
        // 调用方法
        method.invoke(phone, "男儿当自强");
        Method method2 = classMobilePhone.getMethod("call", String.class);
        method2.invoke(phone, "11111111");

        // 获取方法参数类型
        Class<?>[] parameterTypes = method2.getParameterTypes();
        for (Class<?> parameterType : parameterTypes) {
            System.out.println("参数类型:" + parameterType);
        }

        // 获取private方法
        Method method3 = classMobilePhone.getDeclaredMethod("movedPosition");
        // 设置可以访问private方法
        method3.setAccessible(true);
        method3.invoke(phone);
        Method method4 = classMobilePhone.getDeclaredMethod("sendMessage");
        method4.setAccessible(true);
        method4.invoke(phone);
        method4.invoke(null);
    }
}
