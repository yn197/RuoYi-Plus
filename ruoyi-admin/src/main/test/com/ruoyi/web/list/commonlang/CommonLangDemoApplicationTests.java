package com.ruoyi.web.list.commonlang;

import com.google.common.collect.Lists;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.ListUtils;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@SpringBootTest
class CommonLangDemoApplicationTests {

    @Test
    void contextLoads() {
        List<String> list1 = Lists.newArrayList("a", "b", "c");
        List<String> list2 = Lists.newArrayList("a", "b", "c", "d", "e");
        List<String> list3 = Lists.newArrayList("d", "c", "e", "c", "f");

        // list1 与  list2的交集
        System.err.println("list1 与  list2的交集 " + ListUtils.retainAll(list1, list2));
        // list1 与  list3的差集
        System.err.println("list1 与  list3的差集 " + ListUtils.subtract(list1, list3));
        // list3 与  list1的差集
        System.err.println("list3 与  list1的差集 " + ListUtils.subtract(list3, list1));
    }

    //    类似的还有CollectionUtils，MapUtils
    public static void main(String[] args) {
        List<Integer> list1 = new ArrayList<Integer>();
        list1.add(1);
        list1.add(2);
        list1.add(3);
        list1.add(4);

        List<Integer> list2 = new ArrayList<Integer>();
        list2.add(3);
        list2.add(4);
        list2.add(5);
        list2.add(6);

        // 取交集[3, 4]
        Collection<Integer> interColl = CollectionUtils.intersection(list1, list2);
        System.out.println(interColl);// 打印出[3, 4]

        // 取并集[1, 2, 3, 4, 5, 6]
        Collection<Integer> unionColl = CollectionUtils.union(list1, list2);
        System.out.println(unionColl);// 打印出[1, 2, 3, 4, 5, 6]

        // 取差集[1,2]
        Collection<Integer> disColl = CollectionUtils.disjunction(list1, interColl);
        System.out.println(disColl);// 打印出[1, 2]
    }
}
