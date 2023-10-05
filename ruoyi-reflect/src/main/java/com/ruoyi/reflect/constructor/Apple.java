package com.ruoyi.reflect.constructor;

/**
 * @author nisang
 * 2023/10/5 18:02
 * @version 1.0
 * Ruoyi-Cloud-Plus开发小组
 */
public class Apple {
    public double price = 10;
    public String name = "苹果";

    public Apple() {
    }

    private Apple(double price) {
        this.price = price;
    }

    public Apple(double price, String name) {
        this.price = price;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Apple{" +
                "price=" + price +
                ", name='" + name + '\'' +
                '}';
    }
}
