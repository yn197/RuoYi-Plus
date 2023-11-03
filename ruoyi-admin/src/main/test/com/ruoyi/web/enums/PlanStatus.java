package com.ruoyi.web.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.baomidou.mybatisplus.annotation.IEnum;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;
import lombok.Setter;

/**
 * @author nisang
 * 2023/11/3 10:00
 * @version 1.0
 * Ruoyi-Cloud-Plus开发小组
 */
@Getter
public enum PlanStatus implements BaseEnum{
    NO_PLAN(0, "没有计划"),
    PLAN_RUNNING(1, "计划进行中");
    //前端展示字段
    @JsonValue
    //数据库保存字段
    @EnumValue
    int value;
    String desc;
    PlanStatus(int value, String desc) {
        this.value = value;
        this.desc = desc;
    }
}
