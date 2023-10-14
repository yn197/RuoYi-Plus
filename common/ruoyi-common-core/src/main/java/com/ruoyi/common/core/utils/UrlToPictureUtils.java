package com.ruoyi.common.core.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * @author yangni
 * @version 1.0
 * 
 * @date 2022/11/21 11:29
 */
public class UrlToPictureUtils {

    /**
     * @imgUrl 图片url
     * @filePath 图片保存的路径
     */
    public void getImgByUrl(String imgUrl, String filePath) {
        File img = new File(filePath);
        HttpURLConnection conn = null;
        InputStream inStream = null;
        FileOutputStream outStream = null;
        try {
            URL url = new URL(imgUrl);
            //打开链接
            conn = (HttpURLConnection) url.openConnection();
            //设置请求方式为"GET"
            conn.setRequestMethod("GET");
            //建立连接的超时时间
            conn.setConnectTimeout(10 * 1000);
            //传递数据的超时时间
            conn.setReadTimeout(10 * 1000);
            //通过输入流获取图片数据
            inStream = conn.getInputStream();

            //创建输出流
            outStream = new FileOutputStream(img);
            byte[] buffer = new byte[1024];
            //每次读取的字符串长度，如果为-1，代表全部读取完毕
            int len;
            //使用一个输入流从buffer里把数据读取出来
            while ((len = inStream.read(buffer)) != -1) {
                //用输出流往buffer里写入数据，中间参数代表从哪个位置开始读，len代表读取的长度
                outStream.write(buffer, 0, len);
            }

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (inStream != null) {
                try {
                    inStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (conn != null) {
                conn.disconnect();
            }
            if (outStream != null) {
                try {
                    outStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
