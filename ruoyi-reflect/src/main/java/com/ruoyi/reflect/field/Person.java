package com.ruoyi.reflect.field;

/**
 * @author nisang
 * 2023/10/5 16:34
 * @version 1.0
 * Ruoyi-Cloud-Plus开发小组
 */

public class Person {
    public int numOfEye = 2;
    private double money = 1;

    public Person() {
    }

    public Person(int numOfEye, double money) {
        this.numOfEye = numOfEye;
        this.money = money;
    }
}
