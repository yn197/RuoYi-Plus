package com.ruoyi.web.map;

import com.google.common.collect.Maps;
import lombok.Data;
import lombok.experimental.Accessors;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

@Slf4j
@SpringBootTest
public class MapTest {

    @Test
    public void ergodic() {
        Map<String, String> map = Maps.newHashMap();
        map.put("Amy", "女");
        map.put("Bob", "男");
        map.put("Lucy", "女");
        //第一种遍历map的方法，通过加强for循环map.keySet()，然后通过键key获取到value值
        for (String s : map.keySet()) {
            System.out.println("key : " + s + " value : " + map.get(s));
        }
        System.out.println("====================================");

        //第二种只遍历键或者值，通过加强for循环
        for (String s1 : map.keySet()) {//遍历map的键
            System.out.println("键key ：" + s1);
        }
        for (String s2 : map.values()) {//遍历map的值
            System.out.println("值value ：" + s2);
        }
        System.out.println("====================================");

        //第三种方式Map.Entry<String, String>的加强for循环遍历输出键key和值value
        for (Map.Entry<String, String> entry : map.entrySet()) {
            System.out.println("键 key ：" + entry.getKey() + " 值value ：" + entry.getValue());
        }
        System.out.println("====================================");

        //第四种Iterator遍历获取，然后获取到Map.Entry<String, String>，再得到getKey()和getValue()
        Iterator<Map.Entry<String, String>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, String> entry = it.next();
            System.out.println("键key ：" + entry.getKey() + " value ：" + entry.getValue());
        }
        System.out.println("====================================");
    }

    /**
     * computeIfPresent用法
     */
    @Test
    public void computeIfPresent() {
        // 创建一个 HashMap
        HashMap<String, Integer> prices = new HashMap<>();

        // 往HashMap中添加映射关系
        prices.put("Shoes", 200);
        prices.put("Bag", 300);
        prices.put("Pant", 150);
        System.out.println("HashMap: " + prices);

        // 重新计算鞋加上10%的增值税后的价值
        int shoesPrice = prices.computeIfPresent("Shoes", (key, value) -> value + value * 10 / 100);
        System.out.println("Price of Shoes after VAT: " + shoesPrice);

        // 输出更新后的HashMap
        System.out.println("Updated HashMap: " + prices);
    }

    @Data
    @Accessors(chain = true)
    class User {
        private String username;
        private String city;
    }
}
