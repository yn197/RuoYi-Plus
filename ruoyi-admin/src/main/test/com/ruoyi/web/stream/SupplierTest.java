package com.ruoyi.web.stream;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

/**
 * @author yangni
 * @version 1.0
 * 
 * @date 2022/8/21 11:12
 */
@SpringBootTest
public class SupplierTest {
    //1.Supplier <T> 供给型    T   get()
    @Test
    public void supplier() {

        List<Integer> list = getNumberList(10, () -> (int) (Math.random() * 100));
        System.out.println(list);
    }


    //产生指定个数的整数，并且放入集合当中
    public List<Integer> getNumberList(int num, Supplier<Integer> sup) {
        List<Integer> list = new ArrayList<>(2);
        for (int i = 0; i < num; i++) {
            Integer n = sup.get();
            list.add(n);
        }
        return list;
    }
}
