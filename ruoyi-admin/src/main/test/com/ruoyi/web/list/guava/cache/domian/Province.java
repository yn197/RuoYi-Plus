package com.ruoyi.web.list.guava.cache.domian;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author yangni
 * @version 1.0
 * 
 * @date 2022/12/5 13:12
 */
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Province {
    //省会名称
    private String name;
    //省会编码 如：PR001
    private String code;
}
