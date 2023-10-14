package com.ruoyi.web.list.commonlang.domain;

/**
 * @author yangni
 * @version 1.0
 * 
 * @date 2022/12/19 10:36
 */
public class Person {
    private String name;

    public static void staticMet(String t) {
        System.out.println(t);
    }

    public Person(String name) {
        this.name = name;
    }

    public String call(String string) {
        System.out.println(name);
        System.out.println(string);
        return string;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "test [name=" + name + "]";
    }
}
