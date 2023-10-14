package com.ruoyi.web.list.commonlang;

import org.apache.commons.lang3.ArrayUtils;

/**
 *
 * 操作数组，功能强大，可以合并，判断是否包含等操作
 * @author yangni
 * @version 1.0
 * 
 * @date 2022/12/19 10:30
 */
public class ArrayUtilsTest {
    public static void main(String[] args) {
        int array[] = { 1, 5, 5, 7 };
        System.out.println(array);

        // 增加元素
        array = ArrayUtils.add(array, 9);
        System.out.println(ArrayUtils.toString(array));

        // 删除元素
        array = ArrayUtils.remove(array, 3);
        System.out.println(ArrayUtils.toString(array));

        // 反转数组
        ArrayUtils.reverse(array);
        System.out.println(ArrayUtils.toString(array));

        // 查询数组索引
        System.out.println(ArrayUtils.indexOf(array, 5));

        // 判断数组中是否包含指定值
        System.out.println(ArrayUtils.contains(array, 5));

        // 合并数组
        array = ArrayUtils.addAll(array, new int[] { 1, 5, 6 });
        System.out.println(ArrayUtils.toString(array));
        //补充:ArrayUtils可以将包装类型的数组转变为基本类型的数组。
        Integer integer[] = new Integer[] { 0, 1, 2 };
        System.out.println(integer.getClass());

        int[] primitive = ArrayUtils.toPrimitive(integer);
        System.out.println(primitive.getClass());
//        补充:ArrayUtils.remove()是根据下标移除，也可以移除元素:从该数组中删除第一次出现的指定元素，返回一个新的数组。
        int array2[] = { 1, 5, 5, 7 };
        System.out.println(ArrayUtils.toString(array2));

        // 删除元素
        array2 = ArrayUtils.removeElement(array2, 5);
        System.out.println(ArrayUtils.toString(array2));
//        上面是删除第一个出现的元素，如果需要删除所有的，可以用:
        int array3[] = { 1, 5, 5, 7 };
        System.out.println(ArrayUtils.toString(array3));

        // 删除元素
        while (ArrayUtils.contains(array3, 5)) {
            array3 = ArrayUtils.removeElement(array3, 5);
        }
        System.out.println(ArrayUtils.toString(array3));
    }
}
