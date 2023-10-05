package com.ruoyi.reflect.cla;

/**
 * @author nisang
 * 2023/10/5 17:57
 * @version 1.0
 * Ruoyi-Cloud-Plus开发小组
 */
public class Father {
    public String name = "一个父亲";
    private int age = 30;

    public Father() {
    }

    public Father(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void duty() {
        System.out.println("赚钱养家");
    }

    private void attitude() {
        System.out.println("提升自己");
    }
}
