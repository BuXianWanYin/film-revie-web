package com.springbootdemo.filmreviewweb.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.springbootdemo.filmreviewweb.entity.Review;
import com.springbootdemo.filmreviewweb.mapper.ReviewMapper;
import com.springbootdemo.filmreviewweb.service.ReviewService;
import com.springbootdemo.filmreviewweb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 观后感服务实现类
 */
@Service
public class ReviewServiceImpl extends ServiceImpl<ReviewMapper, Review> implements ReviewService {

    @Autowired
    private UserService userService;

    @Override
    public Review findByUserId(Long userId) {
        LambdaQueryWrapper<Review> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Review::getUserId, userId);
        return getOne(wrapper);
    }

    @Override
    public Review findByUsername(String username) {
        var user = userService.findByUsername(username);
        if (user != null) {
            return findByUserId(user.getId());
        }
        return null;
    }

    @Override
    public boolean saveOrUpdateReview(Review review) {
        if (review.getId() == null) {
            return save(review);
        } else {
            return updateById(review);
        }
    }
}

