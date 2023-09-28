package com.ruoyi.framework.es.service;

import com.ruoyi.framework.domain.Posts;
import com.ruoyi.framework.es.repository.EsPostsesPostsRepository;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ApiService {
    @Autowired
    private EsPostsesPostsRepository esPostsesPostsRepository;

    /**
     * 删除文档
     * @param id
     * @return
     */
    public boolean deletePosts(Long id) {
        try {
            esPostsesPostsRepository.deleteById(id);
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
        return true;
    }

    /**
     * 插入文档
     * @param aLog
     * @return
     */
    public Posts savePosts(Posts aLog) {
        Posts Posts = new Posts();
        try {
            Posts = esPostsesPostsRepository.save(aLog);
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
        return Posts;
    }

    /**
     * 按id查询
     * @param id
     * @return
     */
    public Posts findOnePosts(long id) {
        Posts Posts = new Posts();
        try {
            Posts = esPostsesPostsRepository.findById(id).get();
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
        return Posts;
    }

    /**
     * 查询全部文档
     * @return
     */
    public List<Posts> findAllPosts() {
        List<Posts> list = new ArrayList<>();
        try {
            Iterable<Posts> aIterable = esPostsesPostsRepository.findAll();
            for (Posts Posts : aIterable) {
                list.add(Posts);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
        return list;
    }

}
