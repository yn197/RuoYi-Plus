package com.ruoyi.web.es.repository;
import com.ruoyi.framework.domain.Posts;
import com.ruoyi.framework.es.service.ApiService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class DemoApplicationTests {


    @Autowired
    ApiService apiService;

    @Test
    public void contextLoads() {
        Posts posts = apiService.findOnePosts(302191900788527104L);
        log.info("Posts查询:{}", posts);
    }
}
