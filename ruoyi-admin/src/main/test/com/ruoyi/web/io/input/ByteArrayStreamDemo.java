package com.ruoyi.web.io.input;

import java.io.ByteArrayInputStream;

/**
 * @author yangni
 * @version 1.0
 * 
 * @date 2022/11/18 11:23
 */
public class ByteArrayStreamDemo {
    public static void main(String[] args) {
        byte[] b = "hello".getBytes();
        //输入中文必会乱码
        //byte[] b = "hello,你是人间四月天".getBytes();
        ByteArrayInputStream bais = new ByteArrayInputStream(b);
        int n = 0;
        while ((n = bais.read()) != -1) {
            //hello
            System.out.print((char) n);
        }
    }
}
