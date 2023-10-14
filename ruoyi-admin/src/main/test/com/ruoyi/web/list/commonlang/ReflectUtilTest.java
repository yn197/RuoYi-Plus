package com.ruoyi.web.list.commonlang;

import com.ruoyi.web.list.commonlang.domain.Person;
import org.apache.commons.lang3.reflect.ConstructorUtils;
import org.apache.commons.lang3.reflect.FieldUtils;
import org.apache.commons.lang3.reflect.MethodUtils;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author yangni
 * @version 1.0
 * 
 * @date 2022/12/19 10:36
 */
public class ReflectUtilTest {


    public static void main(String[] args) throws InvocationTargetException, InstantiationException,
            IllegalAccessException, NoSuchMethodException {
        test();
    }

    public static void test() throws InstantiationException, IllegalAccessException,
            IllegalArgumentException, InvocationTargetException, NoSuchMethodException {
        // ConstructorUtils工具类的使用
        Constructor accessibleConstructor = ConstructorUtils.getAccessibleConstructor(Person.class, String.class);
        Person newInstance = (Person) accessibleConstructor.newInstance("ReflectUtilTest");
        System.out.println(newInstance.getClass());
        System.out.println(newInstance);

        // MethodUtils的使用
        Method accessibleMethod = MethodUtils.getAccessibleMethod(Person.class, "call", String.class);
        Object invoke = accessibleMethod.invoke(newInstance, "参数");
        System.out.println(invoke);
        // 调用静态方法
        MethodUtils.invokeStaticMethod(Person.class, "staticMet", "静态方法");

        // FieldUtils 暴力获取私有变量(第三个参数表示是否强制获取)---反射方法修改元素的值
        Field field = FieldUtils.getField(Person.class, "name", true);
        field.setAccessible(true);
        System.out.println(field.getType());
        field.set(newInstance, "修改后的值");
        System.out.println(newInstance.getName());
    }
}
