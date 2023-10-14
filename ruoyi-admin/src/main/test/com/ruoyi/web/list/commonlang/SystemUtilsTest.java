package com.ruoyi.web.list.commonlang;

import org.apache.commons.lang3.SystemUtils;

/**
 * @author yangni
 * @version 1.0
 * 
 * @date 2022/12/19 10:23
 */
public class SystemUtilsTest {
    public static void main(String[] args) {
        test5();
    }
    /**
     * SystemUtils
     */
    public static  void test5(){
        System.out.println(SystemUtils.getJavaHome());
        System.out.println(SystemUtils.getJavaIoTmpDir());
        System.out.println(SystemUtils.getUserDir());
        System.out.println(SystemUtils.getUserHome());
        System.out.println(SystemUtils.JAVA_VERSION);
        System.out.println(SystemUtils.OS_NAME);
        System.out.println(SystemUtils.USER_TIMEZONE);
    }
}
