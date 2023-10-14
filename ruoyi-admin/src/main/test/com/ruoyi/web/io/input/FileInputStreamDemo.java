package com.ruoyi.web.io.input;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * 读取某个位置的文件
 * @author yangni
 * @version 1.0
 * 
 * @date 2022/11/18 11:25
 */
public class FileInputStreamDemo {
    public static void main(String args[]) throws IOException {
        try{                                        //创建文件输入流对象
            FileInputStream rf = new FileInputStream("G:\\file_io_demo\\file_io_demo\\src\\main\\java\\com\\yn\\file_io_demo\\FileInputStreamDemo.java");
            int n=512,c=0;
            byte buffer[] = new byte[n];
            while ((c=rf.read(buffer,0,n))!=-1 ){   //读取输入流
                System.out.print(new String(buffer,0,c));
            }
            rf.close();                            //关闭输入流
        }
        catch (FileNotFoundException ffe){
            System.out.println(ffe);}
        catch (IOException ioe){
            System.out.println(ioe);
        }
    }
}
