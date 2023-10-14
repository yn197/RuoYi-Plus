package com.ruoyi.common.core.utils;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.springframework.http.MediaType;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * @author yangni
 * @version 1.0
 * 
 * @date 2022/11/21 12:15
 */
@Slf4j
public class UrlToMultipartFileUtil {
    /**
     * url转MultipartFile
     * @param url 文件url
     * @param fileName 文件新名称
     * @return
     */
    public static MultipartFile urlToMultipartFile(String url, String fileName){
        HttpURLConnection httpUrl = null;
        MultipartFile multipartFile = null;
        try {
            log.info("urlToMultipartFile文件转换中，url为："+url+"文件名称为："+fileName);
            httpUrl = (HttpURLConnection) new URL(url).openConnection();
            httpUrl.connect();
            log.info("成功建立httpUrl连接" + httpUrl);

            multipartFile = getMultipartFile(httpUrl.getInputStream(), fileName);
        } catch (IOException e) {
            log.error("url解析失败，抛出url解析异常");
        } finally {
            httpUrl.disconnect();
        }

        return multipartFile;
    }

    /**
     * inputStream 转 File
     *
     * @param ins
     * @param name
     * @return
     * @throws Exception
     */
    public static File inputStreamToFile(InputStream ins, String name) throws Exception {

        File file = new File(System.getProperty("java.io.tmpdir") + File.separator + name);
        OutputStream os = new FileOutputStream(file);
        int bytesRead;
        int len = 8192;
        byte[] buffer = new byte[len];
        while ((bytesRead = ins.read(buffer, 0, len)) != -1) {
            os.write(buffer, 0, bytesRead);
        }
        os.close();
        ins.close();

        return file;
    }

    /**
     * file转multipartFile
     *
     * @param file
     * @return
     */
    public static MultipartFile fileToMultipartFile(File file) {

        FileItemFactory factory = new DiskFileItemFactory(16, null);
        FileItem item = factory.createItem(file.getName(), "text/plain", true, file.getName());
        int bytesRead = 0;
        byte[] buffer = new byte[8192];
        try {
            FileInputStream fis = new FileInputStream(file);
            OutputStream os = item.getOutputStream();
            while ((bytesRead = fis.read(buffer, 0, 8192)) != -1) {
                os.write(buffer, 0, bytesRead);
            }
            os.close();
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new CommonsMultipartFile(item);
    }

    /**
     * @param file
     * @param path
     * @return
     */
    public static String saveMultipartFile(MultipartFile file, String path) {
        if (file.isEmpty()) {
            return "false";
        }
        String fileName = file.getOriginalFilename();
        File dest = new File(new File(path).getAbsolutePath() + "/" + fileName);
        if (!dest.getParentFile().exists()) {
            dest.getParentFile().mkdirs();
        }
        try {
            file.transferTo(dest); // 保存文件
            return "true";
        } catch (Exception e) {
            e.printStackTrace();
            return "false";
        }
    }

    /**
     * 通过InpuStream获取MultipartFile
     * @param inputStream 文件的输入流
     * @param fileName 文件新名称
     * @return
     */
    public static MultipartFile getMultipartFile(InputStream inputStream, String fileName) {
        FileItem fileItem = createFileItem(inputStream, fileName);

        //CommonsMultipartFile是feign对multipartFile的封装，但是要FileItem类对象
        return new CommonsMultipartFile(fileItem);
    }


    /**
     * 通过InpuStream获取FileItem
     * @param inputStream 文件输入流
     * @param fileName 文件新名称
     * @return
     */
    public static FileItem createFileItem(InputStream inputStream, String fileName) {
        FileItemFactory factory = new DiskFileItemFactory(16, null);
        String textFieldName = "file";
        FileItem item = factory.createItem(textFieldName, MediaType.MULTIPART_FORM_DATA_VALUE, true, fileName);
        int bytesRead = 0;
        byte[] buffer = new byte[8192];
        OutputStream os = null;
        //使用输出流输出输入流的字节
        try {
            os = item.getOutputStream();
            while ((bytesRead = inputStream.read(buffer, 0, 8192)) != -1) {
                os.write(buffer, 0, bytesRead);
            }
            inputStream.close();
        } catch (IOException e) {
            log.error("Stream copy exception", e);
            throw new IllegalArgumentException("文件上传失败");
        } finally {
            if (os != null) {
                try {
                    os.close();
                } catch (IOException e) {
                    log.error("Stream close exception", e);
                }
            }
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    log.error("Stream close exception", e);
                }
            }
        }

        return item;
    }
}
