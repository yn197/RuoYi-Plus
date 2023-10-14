package com.ruoyi.web.list.commonlang;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.MapUtils;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.Map;

/**
 * @author yangni
 * @version 1.0
 * 
 * @date 2022/12/13 9:43
 */
@SpringBootTest
@Slf4j
public class MapUtilsMainTest {
    @Test
    void contextLoads() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("name", "lisi");
        map.put("sex", "man");
        map.put("age", 18);
        map.put("money", null);
        String name = MapUtils.getString(map, "name");
//        int money = MapUtils.getInteger(map,"money");
        int money2 = MapUtils.getInteger(map, "money", 23);
        boolean empty = MapUtils.isEmpty(map);
        boolean notEmpty = MapUtils.isNotEmpty(map);
        String[][] user = {{"names", "zhangfsan"}, {"sexs", "1f"}};
        Map map1 = MapUtils.putAll(map, user);
        log.info("name:" + name);
        log.info("money2:" + money2);
        log.info("empty:" + empty);
        log.info("notEmpty:" + notEmpty);
        log.info("map1:" + map1);
    }

}
