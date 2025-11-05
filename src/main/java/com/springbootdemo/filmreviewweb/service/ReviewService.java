package com.springbootdemo.filmreviewweb.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.springbootdemo.filmreviewweb.entity.Review;

/**
 * 观后感服务接口
 */
public interface ReviewService extends IService<Review> {
    
    /**
     * 根据用户ID查找观后感
     */
    Review findByUserId(Long userId);
    
    /**
     * 根据用户名查找观后感
     */
    Review findByUsername(String username);
    
    /**
     * 保存或更新观后感
     */
    boolean saveOrUpdateReview(Review review);
}

