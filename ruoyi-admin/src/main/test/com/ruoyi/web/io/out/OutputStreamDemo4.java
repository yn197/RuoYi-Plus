package com.ruoyi.web.io.out;

import java.io.BufferedOutputStream;
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
public class OutputStreamDemo4 {
    public static void main(String[] args) throws IOException {
        OutputStream outputStream = new BufferedOutputStream(new FileOutputStream("七郎.txt"));
        String str = "我是七郎";
        byte[] bytes = str.getBytes(StandardCharsets.UTF_8);
        outputStream.write(bytes);
        outputStream.flush();
    }
}
