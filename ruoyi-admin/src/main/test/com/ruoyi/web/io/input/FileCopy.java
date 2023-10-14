package com.ruoyi.web.io.input;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author yangni
 * @version 1.0
 * 
 * @date 2022/11/18 11:14
 */
public class FileCopy {

    //    文件复制其实就是一边读，一边写，每读取一次就把读取到的内容写到文件中。
//    为了保证复制效率，我们采用一次读取一个字节数组的方式进行复制
//
//    思路：
//        1. 创建字节输入流对象，用来读取
//        2. 创建字节输出流对象，用来写入。
//        3. 开始读取，一次读取一个字节数组。
//        4. 把读取到的字节数组的内容写入到目的地文件
//        5. 循环 第3步 和 第4步
//        6. 释放资源
    public static void main(String[] args) throws IOException {
        //1. 创建字节输入流对象，用来读取
        FileInputStream fis = new FileInputStream("G:\\测试文件.txt");
        //2创建字节输出流对象，用来写入//没有会创建
        FileOutputStream fs = new FileOutputStream("G:\\测试文件_copy.txt");
        //3创建一个数组用来读取
        byte arr[] = new byte[1024 * 8];
        int len;//用来计数
        while ((len = fis.read(arr)) != -1) {
            //从文件中用字节数组读取数组，存储到字节数组中
//            每读取到一个内容，就把读取到的内容写入到目的地文件
            fs.write(arr,0,len);

        }
        //释放资源
        fs.close();
        fis.close();
    }
}
