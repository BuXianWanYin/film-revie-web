package com.springbootdemo.filmreviewweb.controller;

import com.springbootdemo.filmreviewweb.entity.Review;
import com.springbootdemo.filmreviewweb.entity.User;
import com.springbootdemo.filmreviewweb.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 * 个人中心控制器
 */
@Controller
@RequestMapping("/profile")
public class ProfileController {

    @Autowired
    private ReviewService reviewService;

    @GetMapping("")
    public String profile(HttpSession session, Model model) {
        User user = (User) session.getAttribute("user");
        if (user == null) {
            return "redirect:/login";
        }
        
        Review review = reviewService.findByUserId(user.getId());
        
        model.addAttribute("title", "个人中心");
        model.addAttribute("user", user);
        model.addAttribute("review", review);
        model.addAttribute("activePage", "profile");
        
        return "profile";
    }
}

