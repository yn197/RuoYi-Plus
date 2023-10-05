package com.ruoyi.reflect.cla;

/**
 * @author nisang
 * 2023/10/5 17:57
 * @version 1.0
 * Ruoyi-Cloud-Plus开发小组
 */
public class Son extends Father{
    public int height = 20;
    private int weight = 7;

    public Son() {
    }

    public Son(String name, int age, int height, int weight) {
        super(name, age);
        this.height = height;
        this.weight = weight;
    }

    private Son(int height, int weight) {
        this.height = height;
        this.weight = weight;
    }

    public void learn() {
        System.out.println("好好学习");
    }

    private void grow() {
        System.out.println("健康成长，养成积极向上的世界观");
    }

    public void addElectiveCourse(String cource) {
        System.out.println("选修" + cource + "课程");
    }
}