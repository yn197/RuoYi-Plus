package com.ruoyi.web.list.commonlang;

import com.ruoyi.common.utils.StringUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang.math.RandomUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yangni
 * @version 1.0
 * 
 * @date 2022/12/19 12:38
 */
public class RandomStringUtilsTest {
    public static void main(String[] args) {
        // 第一个参数表示生成位数，第二个表示是否生成字母，第三个表示是否生成数字
        System.out.println(RandomStringUtils.random(15, true, false));

        // 长度、起始值、结束值、是否使用字母、是否生成数字
        System.out.println(RandomStringUtils.random(15, 5, 129, true, false));

        System.out.println(RandomStringUtils.random(22));

        // 从指定字符串随机生成
        System.out.println(RandomStringUtils.random(15, "abcdefgABCDEFG123456789"));

        // 从字母中抽取
        System.out.println(RandomStringUtils.randomAlphabetic(15));

        // 从数字抽取
        System.out.println(RandomStringUtils.randomNumeric(15));

        // ASCII between 32 and 126 =内部调用(random(count, 32, 127, false,false);)
        System.out.println(RandomStringUtils.randomAscii(15));

        List<Object> result = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            result.add(RandomUtils.nextInt());
        }
        System.out.println(StringUtils.join(result, ","));

        result = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            result.add(RandomUtils.nextInt(20));
        }
        System.out.println(StringUtils.join(result, ","));

        result = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            result.add(org.apache.commons.lang3.RandomUtils.nextInt(0, 10));
        }
        System.out.println(StringUtils.join(result, ","));

        result = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            result.add(org.apache.commons.lang3.RandomUtils.nextLong(5L, 6L));
        }
        System.out.println(StringUtils.join(result, ","));

        result = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            result.add(org.apache.commons.lang3.RandomUtils.nextFloat(0.5F, 0.6F));
        }
        System.out.println(StringUtils.join(result, ","));
    }

}
