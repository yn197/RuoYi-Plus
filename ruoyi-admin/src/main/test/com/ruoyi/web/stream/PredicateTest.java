package com.ruoyi.web.stream;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.function.Predicate;

/**
 * @author yangni
 * @version 1.0
 *
 * @date 2022/8/21 11:12
 */
@SpringBootTest
public class PredicateTest {
    //1.Predicate<T> 断定型接口  Boolean test(T t)
    @Test
    public void predicate() {
        Boolean aBoolean = strRemoveBlank(2, (p)->p.equals(2));
        System.out.println(aBoolean);
    }

    //需求用来处理字符串 去除空格,分割...
    public Boolean strRemoveBlank(Integer str, Predicate<Integer>pre) {
        return pre.test(str);
    }
}
