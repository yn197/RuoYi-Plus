package com.ruoyi.web.list.commonlang;

import com.ruoyi.web.list.commonlang.domain.Person;
import org.apache.commons.lang3.Validate;

/**
 * @author yangni
 * @version 1.0
 * 
 * @date 2022/12/19 12:41
 */
public class ValidateTest {
    public static void main(String[] args) {
        // 判断是否在指定范围内
        Validate.inclusiveBetween(0, 20, 15);

        // 判断是否不在指定范围内
//        Validate.exclusiveBetween(0, 20, 35);

        // 判断表达式是否为true，不是抛出IllegalArgumentException异常
//        Validate.isTrue(1 == 2, " 1不等于2");

        // 验证状态。 第一个表达式为true抛出非法状态IllegalStateException异常
        Person person = null;
//        Validate.validState(person != null, "person is null");

        // 验证非空，如果为空，会抛出NPE
//        Validate.notNull(person, "用户为空");
    }
}
