package com.ruoyi.web.list.guava.cache.listener;

import com.google.common.cache.RemovalListener;
import com.google.common.cache.RemovalNotification;
import com.ruoyi.web.list.guava.cache.domian.Province;

/**
 * @author yangni
 * @version 1.0
 * 
 * @date 2022/12/5 13:13
 */
public class CustomizeRemovalListener implements RemovalListener<String, Province> {
    @Override
    public void onRemoval(RemovalNotification<String, Province> removalNotification) {
        String reason = String.format("key=%s,value=%s,reason=%s", removalNotification.getKey(), removalNotification.getValue(), removalNotification.getCause());
        System.out.println(reason);
    }
}
