package com.ruoyi.web.list.commonlang;

import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.DateUtils;

import java.text.ParseException;
import java.util.Date;

/**
 * @author yangni
 * @version 1.0
 * 
 * @date 2022/12/19 10:23
 */
public class DateUtilsTest {
    public static void main(String[] args) {
        // DateFormatUtils----date转字符串
        Date date = new Date();
        System.out.println(DateFormatUtils.format(date, "yyyy-MM-dd hh:mm:ss"));// 小写的是12小时制
        System.out.println(DateFormatUtils.format(date, "yyyy-MM-dd HH:mm:ss"));// 大写的HH是24小时制

        // DateUtils ---加减指定的天数(也可以加减秒、小时等操作)
        Date addDays = DateUtils.addDays(date, 2);
        System.out.println(DateFormatUtils.format(addDays, "yyyy-MM-dd HH:mm:ss"));
        Date addDays2 = DateUtils.addDays(date, -2);
        System.out.println(DateFormatUtils.format(addDays2, "yyyy-MM-dd HH:mm:ss"));

        // 原生日期判断日期先后顺序
        System.out.println(addDays2.after(addDays));
        System.out.println(addDays2.before(addDays));

        // DateUtils---字符串转date
        String strDate = "2018-11-01 19:23:44";
        try {
            Date parseDateStrictly = DateUtils.parseDateStrictly(strDate, "yyyy-MM-dd HH:mm:ss");
            Date parseDate = DateUtils.parseDate(strDate, "yyyy-MM-dd HH:mm:ss");
            System.out.println(parseDateStrictly);
            System.out.println(parseDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
