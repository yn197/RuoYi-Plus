package com.ruoyi.web.list.commonlang;

import org.apache.commons.lang3.builder.EqualsBuilder;

/**
 * EqualsBuilder 可以用于拼接多个条件进行equals比较
 * @author yangni
 * @version 1.0
 * 
 * @date 2022/12/19 10:46
 */
public class EqualsBuilderTest {
    public static void main(String[] args) {
        EqualsBuilder equalsBuilder = new EqualsBuilder();
        Integer integer1 = new Integer(1);
        Integer integer2 = new Integer(1);

        String string1 = "111";
        String string2 = "111";
        equalsBuilder.append(integer1, integer2);
        equalsBuilder.append(string1, string2);
        System.out.println(equalsBuilder.isEquals());
    }
}
