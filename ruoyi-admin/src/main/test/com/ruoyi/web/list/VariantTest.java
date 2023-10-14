package com.ruoyi.web.list;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest
public class VariantTest {

    /**
     * 静态变量和实例变量
     */
    public static int staticVar = 0;
    public int instanceVar = 0;

    public VariantTest() {
        staticVar++;
        instanceVar++;
        System.out.println("staticVar =" + staticVar + ",instanceVar =" + instanceVar);
    }

    public static void main(String[] args) {
        VariantTest variantTest = new VariantTest();
        VariantTest variantTest2 = new VariantTest();

        log.info("Integer和int默认值--------------------------------");
        User user = new User();
        System.out.println(user.getAge());
        System.out.println(user.getScore());
    }

    public static String aaa() {
        return "Hello, world";
//        VariantTest.bbb();
    }


    public void bbb() {
        System.out.println("123");
    }

    /**
     * Integer和int
     */
    @Data
    static class User {
        private int age;
        private Integer score;
    }


}
