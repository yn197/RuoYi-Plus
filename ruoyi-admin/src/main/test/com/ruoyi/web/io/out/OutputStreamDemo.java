package com.ruoyi.web.io.out;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

/**
 * @author yangni
 * @version 1.0
 * 
 * @date 2022/11/18 12:53
 */
public class OutputStreamDemo {
    public static void main(String[] args) throws IOException {
        OutputStream outputStream = new FileOutputStream("四郎.txt");
        String str = "我是四郎";
        byte[] bytes = str.getBytes(StandardCharsets.UTF_8);
        for (byte b:bytes){
            outputStream.write(b);
        }
    }
}
