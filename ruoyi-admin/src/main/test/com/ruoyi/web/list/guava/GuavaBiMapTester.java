package com.ruoyi.web.list.guava;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;

/**
 * @author yangni
 * @version 1.0
 * 
 * @date 2022/12/5 12:35
 */
public class GuavaBiMapTester {
    public static void main(String[] args) {
        BiMap<Integer, String> empIDNameMap = HashBiMap.create();
        empIDNameMap.put(new Integer(101), "Mahesh");
        empIDNameMap.put(new Integer(102), "Sohan");
        empIDNameMap.put(new Integer(103), "Ramesh");
        //Emp Id of Employee "Mahesh"
        System.out.println(empIDNameMap.inverse().get("Mahesh"));
    }
}
