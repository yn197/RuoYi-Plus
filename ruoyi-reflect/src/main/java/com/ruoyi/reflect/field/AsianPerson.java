package com.ruoyi.reflect.field;

/**
 * @author nisang
 * 2023/10/5 17:59
 * @version 1.0
 * Ruoyi-Cloud-Plus开发小组
 */
public class AsianPerson extends Person{
    private float height = 170;
    public float weight = 134;

    private static int IQ = 200;

    public AsianPerson() {
    }

    public AsianPerson(int numOfEye, double money, float height, float weight) {
        super(numOfEye, money);
        this.height = height;
        this.weight = weight;
    }
}
