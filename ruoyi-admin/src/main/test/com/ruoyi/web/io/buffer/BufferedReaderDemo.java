package com.ruoyi.web.io.buffer;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**字符缓冲输入流
 * @author yangni
 * @version 1.0
 * 
 * @date 2022/11/18 13:23
 */
public class BufferedReaderDemo {
    public static void main(String[] args) throws IOException {
        //1.创建字符缓冲输入流对象,构造方法中传递字符输入流
        BufferedReader br = new BufferedReader(new FileReader("G:\\c.txt"));

        //2.使用字符缓冲输入流对象中的方法read/readLine读取文本
        /*String line = br.readLine();
        System.out.println(line);

        line = br.readLine();
        System.out.println(line);

        line = br.readLine();
        System.out.println(line);

        line = br.readLine();
        System.out.println(line);*/

        /*
            发下以上读取是一个重复的过程,所以可以使用循环优化
            不知道文件中有多少行数据,所以使用while循环
            while的结束条件,读取到null结束
         */
        String line;
        while((line = br.readLine())!=null){
            System.out.println(line);
        }

        //3.释放资源
        br.close();
    }
}
