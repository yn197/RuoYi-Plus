package com.ruoyi.reflect.method;

/**
 * @author nisang
 * 2023/10/5 18:00
 * @version 1.0
 * Ruoyi-Cloud-Plus开发小组
 */
public class MobilePhone extends Phone{
    public void listenMusic(String name) {
        System.out.println("播放音乐<" + name + ">");
    }

    private void movedPosition() {
        System.out.println("携带方便，随时随地可以使用");
    }

    private static void sendMessage() {
        System.out.println("发短信");
    }
}
