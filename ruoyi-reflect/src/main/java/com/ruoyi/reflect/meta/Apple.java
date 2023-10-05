package com.ruoyi.reflect.meta;

/**
 * @author nisang
 * 2023/10/5 20:37
 * @version 1.0
 * Ruoyi-Cloud-Plus开发小组
 */
public class Apple {
    @FruitProvider(id = 1,name = "甘肃黄元帅",address = "甘肃天水市")
    private String appleProvider;

    public String getAppleProvider() {
        return appleProvider;
    }

    public void setAppleProvider(String appleProvider) {
        this.appleProvider = appleProvider;
    }

    public static void main(String[] args) {
        FruitInfoUtil.getFruitInfo(Apple.class);
    }
}
