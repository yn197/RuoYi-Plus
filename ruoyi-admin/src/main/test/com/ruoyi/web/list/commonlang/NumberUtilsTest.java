package com.ruoyi.web.list.commonlang;

import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author yangni
 * @version 1.0
 * 
 * @date 2022/12/19 10:20
 */
@SpringBootTest
public class NumberUtilsTest {
    public static void main(String[] args) {
        test3();
    }
    /**
     * NumberUtils
     */
    public static  void test3(){
        System.out.println(NumberUtils.isNumber("231232.8"));//true---判断是否是数字
        System.out.println(NumberUtils.isDigits("2312332.5"));//false，判断是否是整数
        System.out.println(NumberUtils.toDouble("null"));//如果传的值不正确返回一个默认值，字符串转double，传的不正确会返回默认值
        System.out.println(NumberUtils.createBigDecimal("333333"));//字符串转bigdecimal
    }
}
