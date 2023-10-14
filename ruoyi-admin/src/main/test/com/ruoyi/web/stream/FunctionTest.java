package com.ruoyi.web.stream;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.function.Function;

/**
 * @author yangni
 * @version 1.0
 * 
 * @date 2022/8/21 11:12
 */
@SpringBootTest
public class FunctionTest {
    Function<Integer, Integer> times2 = i -> i*2;
    Function<Integer, Integer> squared = i -> i*i;
    //1.Function<T,R> 函数型
    @Test
    public void function() {
        String strRemoveBlank = strRemoveBlank("\t\t\t\t 我爱学习Java", (s) -> s.trim());
        String sub = strRemoveBlank("我爱学习Java", (s) -> s.substring(2,5));
        System.out.println(strRemoveBlank);
        System.out.println(sub);
        //2.default <V> Function<V, R> compose(Function<? super V, ? extends T> before)
        System.out.println(times2.apply(4));

        System.out.println(squared.apply(4));
        //32                先4×4然后16×2,先执行apply(4)，在times2的apply(16),先执行参数，再执行调用者。
        System.out.println(times2.compose(squared).apply(4));
        //64               先4×2,然后8×8,先执行times2的函数，在执行squared的函数。
        System.out.println(times2.andThen(squared).apply(4));
        //16  类似方法引用
        System.out.println(Function.identity().compose(squared).apply(4));
    }

    //需求用来处理字符串 去除空格,分割...
    public String strRemoveBlank(String str, Function<String, String> fun) {
        //1.R apply(T t);
        return fun.apply(str);

    }
}
