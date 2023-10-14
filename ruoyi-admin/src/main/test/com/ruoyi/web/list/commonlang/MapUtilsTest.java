package com.ruoyi.web.list.commonlang;



import org.apache.commons.collections.MapUtils;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.Map;

/**
 * @author yangni
 * @version 1.0
 * 
 * @date 2022/12/19 12:49
 */
@SpringBootTest
public class MapUtilsTest {

    @Test
    public void test(){
        Map map = null;
        Map map2 = new HashMap();
        Map map3 = new HashMap<>();
        map3.put("xxx", "xxx");
        // 检验为empty可以验证null和size为0的情况
        System.out.println(MapUtils.isEmpty(map));
        System.out.println(MapUtils.isEmpty(map2));
        System.out.println(MapUtils.isEmpty(map3));

        String string = MapUtils.getString(map3, "eee");
        String string2 = MapUtils.getString(map3, "xxx");
        Integer integer = MapUtils.getInteger(map3, "xxx");
        System.out.println("string->" + string);
        System.out.println("string2->" + string2);
        System.out.println("integer->" + integer);
        System.out.println(integer == null);
    }
}
