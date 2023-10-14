package com.ruoyi.web.list.commonlang;

import org.apache.commons.lang.math.IntRange;

/**
 * 以Range结尾的类主要提供一些范围的操作,包括判断某些字符,数字等是否在这个范围以内
 * @author yangni
 * @version 1.0
 * 
 * @date 2022/12/19 10:26
 */
public class RangeTest {
    public static void main(String[] args) {

        IntRange intRange = new IntRange(1, 5);
        System.out.println(intRange.getMaximumInteger());
        System.out.println(intRange.getMinimumInteger());
        System.out.println(intRange.containsInteger(6));
        System.out.println(intRange.containsDouble(3));
    }
}
