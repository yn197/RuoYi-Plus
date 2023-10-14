package com.ruoyi.common.core.utils;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

import static org.springframework.util.ResourceUtils.getFile;

/**
 * @author nisang
 * 2023/10/14 17:33
 * @version 1.0
 * Ruoyi-Cloud-Plus开发小组
 */
@Slf4j
public class DownLoadFileUtils {

    public void downloadFile(@RequestParam String path, HttpServletResponse response) {

        try {
            File tempFile = getFile(path);
            try (FileInputStream fis = new FileInputStream(tempFile)) {
                byte[] buffer = new byte[fis.available()];
                int read = fis.read(buffer);
                // 清空response
                response.reset();
                // 设置response的Header
                response.addHeader("Content-Length", "" + tempFile.length());
                response.addHeader("Content-Disposition", "attachment;filename=" + new String(tempFile.getName().getBytes()));
                OutputStream toClient = new BufferedOutputStream(response.getOutputStream());
                response.setContentType("application/octet-stream");
                toClient.write(buffer);
                toClient.flush();
                toClient.close();
            }
        } catch (Exception e) {
            log.error("下载出错-》:{}",e.getMessage());
        }

    }
//    /**
//     * 创建一个临时文件
//     * @param url 远端文件Url
//     * @return File
//     */
//    private File getFile(String url) {
//        String fileName=null;
//        //对本地文件命名
//        if (url.contains(".jpg")) {
//            fileName=".jpg";
//        }
//        if (url.contains(".zip")){
//            fileName=".zip";
//        }
//        if (url.contains(".pdf")){
//            fileName=".pdf";
//        }
//        if (url.contains(".wav")){
//            fileName=".wav";
//        }
//        if (url.contains(".rar")){
//            fileName=".rar";
//        }
//        if (url.contains(".doc")){
//            fileName=".doc";
//        }
////        String fileName = url.substring(url.lastIndexOf("."), url.length());
//        File file = null;
//
//        URL urlfile;
//        try {
//            // 创建一个临时路径
//            file = File.createTempFile("file", fileName);
//            log.info("tempFile:->{}",file.getAbsolutePath());
//            //下载
//            urlfile = new URL(url);
//
//            try (InputStream inStream = urlfile.openStream();
//                 OutputStream os =  new FileOutputStream(file);) {
//                int bytesRead = 0;
//                byte[] buffer = new byte[8192];
//                while ((bytesRead = inStream.read(buffer, 0, 8192)) != -1) {
//                    os.write(buffer, 0, bytesRead);
//                }
//            }
//        } catch (Exception e) {
//            log.error("创建临时文件出错：-》{}",e.getMessage());
//        }
//        return file;
//    }

    public InputStream getInputStreamByUrl(String strUrl) {
        HttpURLConnection conn = null;
        try {
            URL url = new URL(strUrl);
            conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setConnectTimeout(20 * 1000);
            final ByteArrayOutputStream output = new ByteArrayOutputStream();
            IOUtils.copy(conn.getInputStream(), output);
            return new ByteArrayInputStream(output.toByteArray());
        } catch (Exception e) {
            log.error("getInputStreamByUrl 异常,exception is {}", e);
        } finally {
            try {
                if (conn != null) {
                    conn.disconnect();
                }
            } catch (Exception e) {
            }
        }
        return null;
    }
}
