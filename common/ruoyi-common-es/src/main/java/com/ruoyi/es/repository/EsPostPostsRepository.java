package com.ruoyi.es.repository;

import com.ruoyi.es.domain.Posts;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * 搜索商品ES操作类
 *
 * @author macro
 * @date 2018/6/19
 */
public interface EsPostPostsRepository extends ElasticsearchRepository<Posts, Long> {
}
