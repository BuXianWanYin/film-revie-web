package com.springbootdemo.filmreviewweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("title", "电影评论网站");
        return "index";
    }

    @GetMapping("/movie-intro")
    public String movieIntro(Model model) {
        model.addAttribute("title", "电影介绍");
        return "movie-intro";
    }

    @GetMapping("/actors")
    public String actors(Model model) {
        model.addAttribute("title", "演员介绍");
        return "actors";
    }

    @GetMapping("/meaning")
    public String meaning(Model model) {
        model.addAttribute("title", "电影内涵");
        return "meaning";
    }

    // 学生个人观影感悟页面
    @GetMapping("/review/qinguijin")
    public String qinGuiJinReview(Model model) {
        model.addAttribute("title", "覃桂锦的观影感悟");
        model.addAttribute("studentName", "覃桂锦");
        model.addAttribute("gender", "男");
        return "reviews/qinguijin";
    }

    @GetMapping("/review/zhubinbo")
    public String zhuBinBoReview(Model model) {
        model.addAttribute("title", "朱斌博的观影感悟");
        model.addAttribute("studentName", "朱斌博");
        model.addAttribute("gender", "男");
        return "reviews/zhubinbo";
    }

    @GetMapping("/review/suzixiang")
    public String suZiXiangReview(Model model) {
        model.addAttribute("title", "苏子翔的观影感悟");
        model.addAttribute("studentName", "苏子翔");
        model.addAttribute("gender", "男");
        return "reviews/suzixiang";
    }

    @GetMapping("/review/qinzhaorui")
    public String qinZhaoRuiReview(Model model) {
        model.addAttribute("title", "覃照睿的观影感悟");
        model.addAttribute("studentName", "覃照睿");
        model.addAttribute("gender", "女");
        return "reviews/qinzhaorui";
    }
}