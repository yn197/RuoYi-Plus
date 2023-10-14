package com.ruoyi.web.io.buffer;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**字符缓冲输出流
 * @author yangni
 * @version 1.0
 * 
 * @date 2022/11/18 13:18
 */
public class BufferedWriterDemo {
    //使用步骤:
//    1.创建字符缓冲输出流对象,构造方法中传递字符输出流
//    2.调用字符缓冲输出流中的方法write,把数据写入到内存缓冲区中
//    3.调用字符缓冲输出流中的方法flush,把内存缓冲区中的数据,刷新到文件中
//      4.释放资源
    public static void main(String[] args) throws IOException {
        //System.out.println();
        //1.创建字符缓冲输出流对象,构造方法中传递字符输出流
        BufferedWriter bw = new BufferedWriter(new FileWriter("G:\\c.txt"));
        //2.调用字符缓冲输出流中的方法write,把数据写入到内存缓冲区中
        for (int i = 0; i <10 ; i++) {
            bw.write("你是人间的四月天");
            //bw.write("\r\n");
            bw.newLine();
        }
        //3.调用字符缓冲输出流中的方法flush,把内存缓冲区中的数据,刷新到文件中
        bw.flush();
        //4.释放资源
        bw.close();
    }
}
