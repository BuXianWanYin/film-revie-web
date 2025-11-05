package com.springbootdemo.filmreviewweb.controller;

import com.springbootdemo.filmreviewweb.entity.Review;
import com.springbootdemo.filmreviewweb.entity.User;
import com.springbootdemo.filmreviewweb.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;

/**
 * 观后感管理控制器
 */
@Controller
@RequestMapping("/review")
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    @GetMapping("/edit")
    public String editReviewPage(HttpSession session, Model model) {
        User user = (User) session.getAttribute("user");
        if (user == null) {
            return "redirect:/login";
        }
        
        Review review = reviewService.findByUserId(user.getId());
        if (review == null) {
            review = new Review();
            review.setUserId(user.getId());
        }
        model.addAttribute("review", review);
        return "review-edit";
    }

    @PostMapping("/edit")
    public String saveReview(Review review, HttpSession session, RedirectAttributes redirectAttributes) {
        User user = (User) session.getAttribute("user");
        if (user == null) {
            return "redirect:/login";
        }
        
        Review existingReview = reviewService.findByUserId(user.getId());
        if (existingReview != null) {
            review.setId(existingReview.getId());
            review.setUserId(user.getId());
        } else {
            review.setUserId(user.getId());
        }
        
        reviewService.saveOrUpdateReview(review);
        redirectAttributes.addFlashAttribute("success", "观后感保存成功");
        return "redirect:/review/edit";
    }
}

