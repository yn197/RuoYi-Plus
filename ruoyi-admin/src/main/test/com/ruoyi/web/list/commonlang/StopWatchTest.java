package com.ruoyi.web.list.commonlang;

import org.apache.commons.lang3.time.StopWatch;

/**
 * @author yangni
 * @version 1.0
 * 
 * @date 2022/12/19 10:25
 */
public class StopWatchTest {
    public static void main(String[] args) {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();

        try {
            Thread.sleep(5 * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        stopWatch.stop();
        System.out.println(stopWatch.getStartTime());// 获取开始时间
        System.out.println(stopWatch.getTime());// 获取总的执行时间--单位是毫秒
    }
}
