package com.ruoyi.web.enums;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;

/**
 * @author nisang
 * 2023/11/3 10:09
 * @version 1.0
 * Ruoyi-Cloud-Plus开发小组
 */
@Slf4j
public class EnumTest {
    public static void main(String[] args) {
        LearningLesson learningLesson = new LearningLesson();
        learningLesson.setLearningLessonName("Java技术");
        learningLesson.setPlanStatus(PlanStatus.NO_PLAN);
        String toJSONString = JSON.toJSONString(learningLesson);
        log.info("课程计划:{}",toJSONString);



        //jackson
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
            String writeValueAsString = objectMapper.writeValueAsString(learningLesson);
            log.info("课程计划:{}",writeValueAsString);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
