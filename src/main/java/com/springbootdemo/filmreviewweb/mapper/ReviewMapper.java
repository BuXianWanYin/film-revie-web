package com.springbootdemo.filmreviewweb.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.springbootdemo.filmreviewweb.entity.Review;
import org.apache.ibatis.annotations.Mapper;

/**
 * 观后感Mapper接口
 */
@Mapper
public interface ReviewMapper extends BaseMapper<Review> {
}

