package com.ruoyi.reflect.method;

/**
 * @author nisang
 * 2023/10/5 18:00
 * @version 1.0
 * Ruoyi-Cloud-Plus开发小组
 */
public class Phone {
    public void call(String phoneNumber) {
        System.out.println("拨打电话" + phoneNumber);
    }
    private void fixedPosition() {
        System.out.println("移动不方便,通常放在固定地点");
    }
}
