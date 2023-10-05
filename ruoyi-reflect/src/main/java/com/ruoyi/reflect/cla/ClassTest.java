package com.ruoyi.reflect.cla;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author nisang
 * 2023/10/5 17:37
 * @version 1.0
 * Ruoyi-Cloud-Plus开发小组
 */
public class ClassTest {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, NoSuchFieldException {
        // 加载类
        Class classSon = Class.forName("com.ruoyi.reflect.cla.Son");

        /***
         * 方法示例
         */

        // 1. 获取全类名
        System.out.println("全类名: " + classSon.getName());
        System.out.println();

        // 2. 获取类名
        System.out.println("类名: " + classSon.getSimpleName());
        System.out.println();

        // 3. 获取所有public修饰的属性,包括父类
        Field[] fields = classSon.getFields();
        for (Field field : fields) {
            System.out.println("public属性: " + field);
        }
        System.out.println();

        // 4. 获取当前类所有属性
        Field[] fields2 = classSon.getDeclaredFields();
        for (Field field : fields2) {
            System.out.println("所有属性: " + field);
        }
        System.out.println();

        // 5. 根据属性名获取public属性,包括父类属性
        Field field = classSon.getField("height");
        System.out.println(field);
        Field field2 = classSon.getField("name");
        System.out.println(field2);
        System.out.println();

        // 6.根据属性名获取本类中任意权限修饰符修饰的属性
        Field field3 = classSon.getDeclaredField("weight");
        System.out.println(field3);
        System.out.println();

        // 7. 获取所有public方法,包括父类
        Method[] methods = classSon.getMethods();
        for (Method method : methods) {
            System.out.println("public方法:" + method);
        }
        System.out.println();

        // 8. 获取本类中所有方法
        Method[] methods2 = classSon.getDeclaredMethods();
        for (Method method : methods2) {
            System.out.println("本类中方法:" + method);
        }
        System.out.println();

        // 9. 根据方法名获取public方法，包括父类
        Method dutyMethod = classSon.getMethod("duty");
        System.out.println(dutyMethod);
        Method addElectiveCourceMethod = classSon.getMethod("addElectiveCourse", String.class);
        System.out.println(addElectiveCourceMethod);
        System.out.println();

        // 10. 根据方法名获取本类任意权限修饰符修饰的方法
        Method growMethod = classSon.getDeclaredMethod("grow");
        System.out.println(growMethod);
        Method learnMethod = classSon.getDeclaredMethod("learn");
        System.out.println(learnMethod);
        System.out.println();

        // 11. 获取本类所有public构造方法
        Constructor[] constructors = classSon.getConstructors();
        for (Constructor constructor : constructors) {
            System.out.println("public构造方法:" + constructor);
        }
        System.out.println();

        // 12. 获取本类所有权限修饰符修饰的构造方法
        Constructor[] declaredConstructors = classSon.getDeclaredConstructors();
        for (Constructor declaredConstructor : declaredConstructors) {
            System.out.println("所有构造方法:" + declaredConstructor);
        }
        System.out.println();

        // 13. 根据参数类型获取public构造方法
        Constructor constructor = classSon.getConstructor();
        System.out.println("public构造方法:" + constructor);
        Constructor constructor2 = classSon.getConstructor(String.class, int.class, int.class, int.class);
        System.out.println("public构造方法:" + constructor2);
        System.out.println();

        //14. 根据参数类型获取所有权限修饰符修饰的构造方法
        Constructor declaredConstructor = classSon.getDeclaredConstructor(int.class, int.class);
        System.out.println("所有权限修饰符修饰的构造方法:" + declaredConstructor);
        Constructor declaredConstructor2 = classSon.getDeclaredConstructor();
        System.out.println("所有权限修饰符修饰的构造方法:" + declaredConstructor2);
        System.out.println();
    }


}
