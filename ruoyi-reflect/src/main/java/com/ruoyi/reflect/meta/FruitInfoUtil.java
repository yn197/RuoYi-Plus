package com.ruoyi.reflect.meta;

import java.lang.reflect.Field;

/**
 * @author nisang
 * 2023/10/5 20:39
 * @version 1.0
 * Ruoyi-Cloud-Plus开发小组
 */
public class FruitInfoUtil {

    public static void getFruitInfo(Class<?>clazz) {
        String strFruitSupplierInformation = "供应商信息:";

        Field[] declaredFields = clazz.getDeclaredFields();
        for (Field field : declaredFields) {
            if (field.isAnnotationPresent(FruitProvider.class)){
                FruitProvider annotation = field.getAnnotation(FruitProvider.class);
                StringBuilder builder = new StringBuilder();
                strFruitSupplierInformation= builder
                        .append(strFruitSupplierInformation)
                        .append("\n供应商编号:").append(annotation.id())
                        .append("\n供应商名称:").append(annotation.name())
                        .append("\n供应商地址:").append(annotation.address())
                        .toString();
                System.out.println(strFruitSupplierInformation);
            }
        }
    }

}
