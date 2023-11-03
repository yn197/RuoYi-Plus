package com.ruoyi.web.enums;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author nisang
 * 2023/11/3 10:04
 * @version 1.0
 * Ruoyi-Cloud-Plus开发小组
 */
@Data
public class LearningLesson {
    @ApiModelProperty(value = "课程学习名字")
    private String LearningLessonName;
    @ApiModelProperty(value = "学习计划状态，0-没有计划，1-计划进行中")
    private PlanStatus planStatus;
}
