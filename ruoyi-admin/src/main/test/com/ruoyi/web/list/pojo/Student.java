package com.ruoyi.web.list.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@Accessors(chain = true)
@AllArgsConstructor
public class Student implements Serializable {
    /**
     * The age of the student
     */
    private Integer age;
    /**
     * The name of the student
     */
    private String username;
}
