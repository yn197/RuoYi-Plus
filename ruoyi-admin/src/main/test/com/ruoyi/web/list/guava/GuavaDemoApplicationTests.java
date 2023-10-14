package com.ruoyi.web.list.guava;

import com.google.common.base.Optional;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class GuavaDemoApplicationTests {

    @Test
    void contextLoads() {
    }

    public static void main(String[] args) {
        GuavaDemoApplicationTests guavaDemoApplicationTests = new GuavaDemoApplicationTests();
        Integer invalidInput  = null;
        Optional<Integer> a =  Optional.of(invalidInput);
        Optional<Integer> b =  Optional.of(new Integer(10));
        System.out.println(guavaDemoApplicationTests.sum(a, b));
    }
    public Integer sum(Optional<Integer> a, Optional<Integer> b) {
        return a.get() + b.get();
    }
}
