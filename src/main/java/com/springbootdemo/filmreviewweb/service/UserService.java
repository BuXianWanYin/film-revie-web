package com.springbootdemo.filmreviewweb.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.springbootdemo.filmreviewweb.entity.User;

/**
 * 用户服务接口
 */
public interface UserService extends IService<User> {
    
    /**
     * 根据用户名查找用户
     */
    User findByUsername(String username);
    
    /**
     * 用户登录
     */
    User login(String username, String password);
    
    /**
     * 修改密码
     */
    boolean changePassword(Long userId, String oldPassword, String newPassword);
}

