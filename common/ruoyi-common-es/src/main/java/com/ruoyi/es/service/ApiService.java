package com.ruoyi.es.service;

import com.ruoyi.es.domain.Posts;
import com.ruoyi.es.repository.EsPostPostsRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 16074
 */
@Service
public class ApiService {
    @Resource
    private EsPostPostsRepository esPostPostsRepository;

    /**
     * 删除文档
     * @param id
     * @return
     */
    public boolean deletePosts(Long id) {
        try {
            esPostPostsRepository.deleteById(id);
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
            Posts = esPostPostsRepository.save(aLog);
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
            Posts = esPostPostsRepository.findById(id).get();
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
            Iterable<Posts> aIterable = esPostPostsRepository.findAll();
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
