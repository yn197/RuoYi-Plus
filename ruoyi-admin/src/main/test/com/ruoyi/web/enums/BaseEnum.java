package com.ruoyi.web.enums;

import lombok.Getter;

/**
 * @author nisang
 * 2023/11/3 10:16
 * @version 1.0
 * Ruoyi-Cloud-Plus开发小组
 */
public interface BaseEnum {
    int getValue();
    String getDesc();

    default boolean equalsValue(Integer value){
        if (value == null) {
            return false;
        }
        return getValue() == value;
    }
}
