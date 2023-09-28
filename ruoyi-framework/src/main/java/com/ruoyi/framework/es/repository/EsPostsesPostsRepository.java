package com.ruoyi.framework.es.repository;


import com.ruoyi.framework.domain.Posts;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * 搜索商品ES操作类
 * Created by macro on 2018/6/19.
 */
public interface EsPostsesPostsRepository extends ElasticsearchRepository<Posts, Long> {
}
