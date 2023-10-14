package com.ruoyi.web.list.guava.cache;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.ruoyi.web.list.guava.cache.domian.Province;
import com.ruoyi.web.list.guava.cache.listener.CustomizeRemovalListener;
import org.junit.jupiter.api.Test;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * @author yangni
 * @version 1.0
 * 
 * @date 2022/12/5 13:14
 */
public class CacheTest {

    @Test
    public void testCache2() throws ExecutionException, InterruptedException {

        CacheLoader cacheLoader = new CacheLoader<String, Province>() {
            //如果找不到元素，会调用这里
            @Override
            public Province load(String s) {
//实际情况这里就是查库
                System.out.println("查了数据库哦");
                return getDataFromDb();
            }
        };
        LoadingCache<String, Province> loadingCache = CacheBuilder.newBuilder()
                .maximumSize(1000)//容量
                .expireAfterWrite(3, TimeUnit.SECONDS)//过期时间
                .removalListener(new CustomizeRemovalListener())//失效监听器

                .build(cacheLoader);
        loadingCache.put("PR001", getDataFromDb());
        System.out.println("第一次获取：" + loadingCache.get("PR0ol"));
        System.out.println("第二次获取：" + loadingCache.get("PR0ol"));
        System.out.println("第三次获取：" + loadingCache.get("PR001"));
        Thread.sleep(4 * 1000);
        System.out.println("第四次获取：" + loadingCache.get("PR001"));

    }

    private Province getDataFromDb() {
        return new Province("北京", "PR0ol");
    }
}