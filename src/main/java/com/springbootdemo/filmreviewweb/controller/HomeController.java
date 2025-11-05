package com.springbootdemo.filmreviewweb.controller;

import com.springbootdemo.filmreviewweb.entity.Review;
import com.springbootdemo.filmreviewweb.entity.User;
import com.springbootdemo.filmreviewweb.service.ReviewService;
import com.springbootdemo.filmreviewweb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpSession;

@Controller
public class HomeController {

    @Autowired
    private UserService userService;

    @Autowired
    private ReviewService reviewService;

    @GetMapping("/")
    public String home(Model model, HttpSession session) {
        // 检查是否已登录，未登录则重定向到登录页面
        User user = (User) session.getAttribute("user");
        if (user == null) {
            return "redirect:/login";
        }
        
        model.addAttribute("title", "南京照相馆观影感悟");
        model.addAttribute("user", user);
        return "index";
    }

    @GetMapping("/movie-intro")
    public String movieIntro(Model model, HttpSession session) {
        model.addAttribute("title", "电影介绍");
        User user = (User) session.getAttribute("user");
        model.addAttribute("user", user);
        return "movie-intro";
    }

    @GetMapping("/actors")
    public String actors(Model model, HttpSession session) {
        model.addAttribute("title", "演员介绍");
        User user = (User) session.getAttribute("user");
        model.addAttribute("user", user);
        return "actors";
    }

    @GetMapping("/meaning")
    public String meaning(Model model, HttpSession session) {
        model.addAttribute("title", "电影内涵");
        User user = (User) session.getAttribute("user");
        model.addAttribute("user", user);
        return "meaning";
    }

    // 通用的观后感页面，根据用户名动态加载
    @GetMapping("/review/{username}")
    public String review(@PathVariable String username, Model model, HttpSession session) {
        User user = userService.findByUsername(username);
        if (user == null) {
            return "redirect:/";
        }
        
        Review review = reviewService.findByUserId(user.getId());
        
        model.addAttribute("title", user.getRealName() + "的观影感悟");
        model.addAttribute("user", user);
        model.addAttribute("review", review);
        
        // 当前登录用户
        User currentUser = (User) session.getAttribute("user");
        model.addAttribute("currentUser", currentUser);
        
        return "review-detail";
    }
}