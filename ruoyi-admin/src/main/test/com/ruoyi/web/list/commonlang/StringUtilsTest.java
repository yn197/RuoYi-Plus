package com.ruoyi.web.list.commonlang;


import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author yangni
 * @version 1.0
 * 
 * @date 2022/12/19 9:28
 */
@SpringBootTest
public class StringUtilsTest {

    @Test
    public void mainTest() {
//        test1();
//        test2();
//        test3();
//        test4();
//        test5();
        test6();
    }


    /**
     * StringUtils
     */
    public static void test1() {
        System.out.println(StringUtils.isBlank("   "));// true----可以验证null, ""," "等
        System.out.println(StringUtils.isBlank("null"));// false
        System.out.println(StringUtils.isAllLowerCase("null"));// t
        System.out.println(StringUtils.isAllUpperCase("XXXXXX"));// t
        System.out.println(StringUtils.isEmpty(" "));// f---为null或者""返回true
        System.out.println(StringUtils.defaultIfEmpty(null, "default"));// 第二个参数是第一个为null或者""的时候的取值
        System.out.println(StringUtils.defaultIfBlank("    ", "default"));//// 第二个参数是第一个为null或者""或者"   "的时候的取值
    }

    //StringUtils也可以将集合和数组转为String，并且以指定符号链接里面的数据
    public static void test2() {
        List list = new ArrayList(2);
        list.add("张三");
        list.add("李四");
        list.add("王五");
        String list2str = StringUtils.join(list, ",");
        System.out.println(list2str);
    }

    //有时候我们希望给拼接后的字符串都加上单引号，这个在拼接SQL  in条件的时候非常有用，例如:
    public static void test3() {
        //需求:将逗号里面的内容都加上单引号
        String string = "111,222,333";
        string = "'" + string + "'";//字符串前后加'
        string = StringUtils.join(string.split(","), "','");//先按逗号分隔为数组，然后用','连接数组
        System.out.println(string);
    }

    //补充:StringUtils也可以截取字符串,判断是否大小写等操作
    public static void test4() {
        String string = "123_45_43_ss";
        System.out.println(StringUtils.isAllLowerCase(string));// 判断全部小写
        System.out.println(StringUtils.isAllUpperCase(string));// 判断全部大写
        System.out.println(StringUtils.substringAfter(string, "123"));// 截取123之后的
        System.out.println(StringUtils.substringBefore(string, "45"));// 截取45之前的
        System.out.println(StringUtils.substringBefore(string, "_"));// 截取第一个_之前的
        System.out.println(StringUtils.substringBeforeLast(string, "_"));// 截取最后一个_之前的
        System.out.println(StringUtils.substringAfter(string, "_"));// 截取第一个_之后的
        System.out.println(StringUtils.substringAfterLast(string, "_"));// 截取最后一个_之后的
        System.out.println(StringUtils.substringBetween("1234565432123456", "2", "6"));// 截取两个之间的(都找的是第一个)
    }

    //补充:StringUtils也可以将字符串分割为数组
    public static void test5() {
        String t = "ttttaaaddbfdsar";
        System.out.println(StringUtils.split(t, ","));
        System.out.println(Arrays.toString(StringUtils.split(t, ",")));
    }

    public static void test6() {
        String str = "我是,中国人,这是我的土地,我深爱着;每一寸。";
        //补充:isNoneBlank可以支持多个参数，甚至String数组，用来判断数组里的每一个字符串都是isNotBlank的。
        System.out.println(StringUtils.countMatches(str, ","));
        //补充:StringUtils可以第N次某字符串出现的位置
        System.out.println(StringUtils.ordinalIndexOf(str, ",", 2));
        //StringUtils可以获取指定字符串之间的字符串，并自动截取为字符串数组
        String[] substringBetweens = StringUtils.substringsBetween(str, ",", ";");
        System.out.println(substringBetweens);
        String[] substringBetweens2 = StringUtils.substringsBetween(str, ",", "。");
        System.out.println(substringBetweens2);
        //StringUtils可以获取指定字符串之间的字符串(只取满足条件的前两个)
        System.out.println(StringUtils.substringBetween(str, ","));
        //补充:Stringutils可以左截取和右截取
        // 左右截取
        System.out.println(StringUtils.left("abc", 2));
        System.out.println(StringUtils.right("abc", 2));
        //补充:StringUtils可以左右填充指定字符串
        // 左添加(默认添加空格)
        String leftPad = StringUtils.leftPad("2", 2);
        System.out.println(leftPad);
        String leftPad2 = StringUtils.leftPad("12", 3, "0");
        System.out.println(leftPad2);

        // 右添加(默认添加空格)
        String rightPad = StringUtils.rightPad("2", 2);
        System.out.println(rightPad);
        String rightPad2 = StringUtils.rightPad("12", 3, "0");
        System.out.println(rightPad2);
        //补充：StringUtils可以忽略大小写判断equals以及contains等
        boolean equalsIgnoreCase = StringUtils.equalsIgnoreCase("AA", "aa");
        System.out.println(equalsIgnoreCase);

        boolean containsIgnoreCase = StringUtils.containsIgnoreCase("Abc", "BC");
        System.out.println(containsIgnoreCase);
    }
}
