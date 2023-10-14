package com.ruoyi.web.list.commonlang;

import org.apache.commons.lang.SerializationUtils;

import java.util.HashMap;

/**
 * @author yangni
 * @version 1.0
 * 
 * @date 2022/12/19 12:44
 */
public class SerializationUtilsTest {
    public static void main(String[] args) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("key1", "value1");

        // 深复制
        HashMap<String, Object> clonedmap = (HashMap) SerializationUtils.clone(map);
        clonedmap.put("key2", "value2");

        System.out.println(map);
        System.out.println(clonedmap);

        // 序列化
        byte[] serialize = SerializationUtils.serialize(map);
        // 反序列化
        Object deserialize = SerializationUtils.deserialize(serialize);
        System.out.println(deserialize);
    }
}
