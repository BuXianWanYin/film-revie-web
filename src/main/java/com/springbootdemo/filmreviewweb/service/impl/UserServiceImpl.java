package com.springbootdemo.filmreviewweb.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.springbootdemo.filmreviewweb.entity.User;
import com.springbootdemo.filmreviewweb.mapper.UserMapper;
import com.springbootdemo.filmreviewweb.service.UserService;
import org.springframework.stereotype.Service;
import java.security.MessageDigest;
import java.nio.charset.StandardCharsets;

/**
 * 用户服务实现类
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Override
    public User findByUsername(String username) {
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(User::getUsername, username);
        return getOne(wrapper);
    }

    @Override
    public User login(String username, String password) {
        User user = findByUsername(username);
        if (user != null && user.getPassword().equals(md5Encrypt(password))) {
            return user;
        }
        return null;
    }

    @Override
    public boolean changePassword(Long userId, String oldPassword, String newPassword) {
        User user = getById(userId);
        if (user != null && user.getPassword().equals(md5Encrypt(oldPassword))) {
            user.setPassword(md5Encrypt(newPassword));
            return updateById(user);
        }
        return false;
    }

    @Override
    public boolean resetPassword(String username, String newPassword) {
        User user = findByUsername(username);
        if (user != null) {
            user.setPassword(md5Encrypt(newPassword));
            return updateById(user);
        }
        return false;
    }

    /**
     * MD5加密
     */
    private String md5Encrypt(String input) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] messageDigest = md.digest(input.getBytes(StandardCharsets.UTF_8));
            StringBuilder hexString = new StringBuilder();
            for (byte b : messageDigest) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) {
                    hexString.append('0');
                }
                hexString.append(hex);
            }
            return hexString.toString();
        } catch (Exception e) {
            throw new RuntimeException("MD5加密失败", e);
        }
    }
}

