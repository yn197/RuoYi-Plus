package com.ruoyi.web.io.input;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author yangni
 * @version 1.0
 * 
 * @date 2022/11/18 10:59
 */

public class InputStreamReaderDemo {

//        在java中InputStream是字节输入流，用来将文件中的数据读取到java程序中。
//        InputStream是所有字节输入流的顶层父类，是一个抽象类。如果要用，需要使用子类。
//
//        最常用的子类：FileInputStream。
//
//        构造方法：
//        FileInputStream(File file)： 传递一个File类型的文件   中文会乱码
//        FileInputStream(String name)： 传递一个String类型的文件路径
//
//        其他方法：
//        int read()： 从文件中读取一个字节数的数据。并返回读取到的这个字节。 如果读取结束，返回的是-1.
//        int read(byte[] b)： 一次读取一个字节数组，输入流会把读取到的内容放入到这个字节数组中，并返回读取到的个数， 如果读取结束返回-1.
//        void close()
//
//        使用步骤：
//        1. 创建一个FileInputStream流对象，绑定一个数据源文件。
//        2. 调用read方法读取数据。
//        3. 释放资源
//
//        注意： 这种方式不能读取中文，一个中文占多个字节，此时一次读取一个字节会把中文拆开读。

    public static void main(String[] args) throws IOException {
        //创建一个FileinputStream对象，并绑定一个数据源文件
        // 如果文件不存在，则会抛出异常（File not fount excep）
        FileInputStream fis = new FileInputStream("G:\\测试文件.txt");

        InputStreamReader reader = new InputStreamReader(fis, "UTF-8");
        //最后的”GBK”根据文件属性而定，如果不行，改成”UTF-8″试试
        BufferedReader br = new BufferedReader(reader);
        String line;
        while ((line = br.readLine()) != null) {
            System.out.println(line);
        }
        br.close();
        reader.close();
        fis.close();
    }
}
