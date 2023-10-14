package com.ruoyi.web.list.commonlang;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Collections;

/**元素位置交换
 * @author yangni
 * @version 1.0
 * 
 * @date 2022/12/15 10:49
 */
@SpringBootTest
@Slf4j
public class CollectionTest {


    public static void main(String[] args) {
        ArrayList arrayList = new ArrayList();

        arrayList.add("A");

        arrayList.add("B");

        arrayList.add("C");

        arrayList.add("D");

        arrayList.add("E");

        System.out.println("Before swaping, ArrayList contains : " + arrayList);

        Collections.swap(arrayList,0,4);

        System.out.println("After swaping, ArrayList contains : " + arrayList);
    }
}


