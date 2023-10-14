package com.ruoyi.web.list;

import com.alibaba.fastjson.JSON;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@Slf4j
@SpringBootTest
public class KeywordTests {

    /**
     * 学习关键字super和this
     */
    @Test
    public void contextLoads() {
        Son s = new Son();
        s.test(30);
    }

    @Data
    class Father {
        int a = 10;
    }

    @Data
    public class Son extends Father {
        int a = 20;

        public void test(int a) {
            System.out.println(super.a);//10
            System.out.println(this.a);//20
            System.out.println(a);//30
        }
    }

    /**
     * final修饰的关键字
     *
     * @param args
     */
    public static void main(String[] args) {
        final String aaa = "Hello Java";
        log.info("aaa:{},地址值:{}", aaa, aaa.hashCode());
        //引用变量无法改变
        //aaa="Hello c++";
        final StringBuffer stringBuffer = new StringBuffer("Hello Java");
        log.info("stringBuffer地址值:{}", stringBuffer.hashCode());
        //stringBuilder=new StringBuffer("Hello Php");
        stringBuffer.append(" And Php");
        log.info("stringBuffer:{},地址值:{}", JSON.toJSONString(stringBuffer), stringBuffer.hashCode());

    }
}
