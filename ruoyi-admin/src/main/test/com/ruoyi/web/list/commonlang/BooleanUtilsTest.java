package com.ruoyi.web.list.commonlang;

import org.apache.commons.lang3.BooleanUtils;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * 判断Boolean类型工具类
 *
 * @author yangni
 * @version 1.0
 * 
 * @date 2022/12/19 10:21
 */
@SpringBootTest
public class BooleanUtilsTest {
    public static void main(String[] args) {
        test4();
    }

    /**
     * BooleanUtils
     */
    public static void test4() {
        System.out.println(BooleanUtils.isFalse(true));//false
        System.out.println(BooleanUtils.toBoolean("yes"));//true
        System.out.println(BooleanUtils.toBooleanObject(0));//false
        System.out.println(BooleanUtils.toStringYesNo(false));//no
        System.out.println(BooleanUtils.toBooleanObject("ok", "ok", "error", "null"));//true-----第一个参数是需要验证的字符串，第二个是返回true的值，第三个是返回false的值，第四个是返回null的值
    }
}
