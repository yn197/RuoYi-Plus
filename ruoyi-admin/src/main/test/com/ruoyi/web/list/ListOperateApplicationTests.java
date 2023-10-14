package com.ruoyi.web.list;

import cn.hutool.core.collection.CollUtil;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import com.ruoyi.web.list.pojo.Student;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import static java.util.stream.Collectors.toList;

@Slf4j
@SpringBootTest
public class ListOperateApplicationTests {

    /**
     * 针对单个数组对象取交，并，合集
     */
    @Test
    public void contextLoads1() {
        List<String> list1 = Lists.newArrayList();
        list1.add("1");
        list1.add("2");
        list1.add("3");
        list1.add("4");
        list1.add("5");

        List<String> list2 = Lists.newArrayList();
        list2.add("2");
        list2.add("5");
        list2.add("5");
        list2.add("6");
        list2.add("99");

        // 交集
        List<String> intersection = list1.stream().filter(item -> list2.contains(item)).collect(toList());
        System.out.println("---交集---");
        intersection.parallelStream().forEach(System.out::println);

        // 差集 (list1 - list2)
        List<String> reduce1 = list1.stream().filter(item -> !list2.contains(item)).collect(toList());
        System.out.println("---差集(list1 - list2)---");
        reduce1.parallelStream().forEach(System.out::println);

        // 并集
        List<String> listAll = list1.parallelStream().collect(toList());
        List<String> listAll2 = list2.parallelStream().collect(toList());
        listAll.addAll(listAll2);
        System.out.println("---并集---");
        listAll.parallelStream().forEachOrdered(System.out::println);

        // 去重并集
        List<String> listAllDistinct = listAll.stream().distinct().collect(toList());
        System.out.println("---得到去重并集---");
        listAllDistinct.parallelStream().forEachOrdered(System.out::println);
    }

    /**
     * 针对对象数组对象取交，并，合集，可以使用apache工具包CollectionUtils
     */
    @Test
    public void contextLoads2() {
        ArrayList<Student> newArrayList = Lists.newArrayList();
        newArrayList.add(new Student(18,"张三"));
        newArrayList.add(new Student(25,"李四"));

        ArrayList<Student> newArrayList2 = Lists.newArrayList();
        newArrayList2.add(new Student(18,"张三"));
        newArrayList2.add(new Student(33,"陈七"));

        //1、并集 union
        System.out.println(CollectionUtils.union(newArrayList, newArrayList2));
        //输出: [Student(username=张三, age=18), Student(username=李四, age=25), Student(username=陈七, age=33)]

        //2、交集 intersection
        System.out.println(CollectionUtils.intersection(newArrayList, newArrayList2));
        //输出:[Student(username=张三, age=18)]

        //3、交集的补集（析取）disjunction
        System.out.println(CollectionUtils.disjunction(newArrayList, newArrayList2));
        //输出:[Student(username=李四, age=25), Student(username=陈七, age=33)]

        //4、差集（扣除）
        System.out.println(CollectionUtils.subtract(newArrayList, newArrayList2));
        //输出:[Student(username=李四, age=25)]
    }

    /**
     * 针对对象数组对象取交，并，合集，可以使用guava工具包
     */
    @Test
    public void contextLoads3() {
        HashSet<Student> students1 = Sets.newHashSet(new Student(18,"张三")
                , new Student(25,"李四"));

        HashSet<Student> students2 = Sets.newHashSet(new Student(18,"张三")
                , new Student(33,"陈七"));

        //1、并集 union
        System.out.println(Sets.union(students1, students2));
        //输出: [Student(username=张三, age=18), Student(username=李四, age=25), Student(username=陈七, age=33)]

        //2、交集 intersection
        System.out.println(Sets.intersection(students1, students2));
        //输出:[Student(username=张三, age=18)]

        //4、差集（扣除）
        System.out.println(Sets.difference(students1, students2));
        //输出:[Student(username=李四, age=25)]
    }

    /**
     * 针对对象数组对象取交，并，合集，也可以使用hutools工具包
     */
    @Test
    public void contextLoads4() {
        ArrayList<Student> students1 = Lists.newArrayList();
        students1.add(new Student(18,"张三"));
        students1.add(new Student(25,"李四"));

        ArrayList<Student> students2 = Lists.newArrayList();
        students2.add(new Student(18,"张三"));
        students2.add(new Student(33,"陈七"));

        //1、并集 union
        System.out.println(CollUtil.union(students1, students2));
        //输出: [Student(username=张三, age=18), Student(username=李四, age=25), Student(username=陈七, age=33)]

        //2、交集 intersection
        System.out.println(CollUtil.intersection(students1, students2));
        //输出:[Student(username=张三, age=18)]

        //4、差集
        System.out.println(CollUtil.disjunction(students1, students2));
        //输出:[Student(username=李四, age=25)]
    }

}
