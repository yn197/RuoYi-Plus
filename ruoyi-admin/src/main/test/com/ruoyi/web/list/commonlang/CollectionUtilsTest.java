package com.ruoyi.web.list.commonlang;

import org.apache.commons.collections.CollectionUtils;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author yangni
 * @version 1.0
 * 
 * @date 2022/12/19 12:46
 */
@SpringBootTest
public class CollectionUtilsTest {

    @Test
    public void test1() {
        List<String> list = new ArrayList<String>();
        list.add("str1");
        list.add("str2");

        List<String> list1 = new ArrayList<String>();
        list1.add("str1");
        list1.add("str21");

        // 判断是否有任何一个相同的元素
        System.out.println(CollectionUtils.containsAny(list, list1));

        // 求并集(自动去重)
        List<String> list3 = (List<String>) CollectionUtils.union(list, list1);
        System.out.println(list3);

        // 求交集(两个集合中都有的元素)
        Collection intersection = CollectionUtils.intersection(list, list1);
        System.out.println("intersection->" + intersection);

        // 求差集(并集去掉交集，也就是list中有list1中没有，list1中有list中没有)
        Collection intersection1 = CollectionUtils.disjunction(list, list1);
        System.out.println("intersection1->" + intersection1);

        // 获取一个同步的集合
        Collection synchronizedCollection = CollectionUtils.synchronizedCollection(list);

        // 验证集合是否为null或者集合的大小是否为0，同理有isNouEmpty方法
        List list4 = null;
        List list5 = new ArrayList<>();
        System.out.println(CollectionUtils.isEmpty(list4));
        System.out.println(CollectionUtils.isEmpty(list5));
        //补充:此工具类还可以向集合中加数组元素
        List<String> newList = new ArrayList<>();
        String s[] = { "1", "2" };
        CollectionUtils.addAll(newList, s);
        newList.add("3");
        System.out.println(newList);
    }
}
