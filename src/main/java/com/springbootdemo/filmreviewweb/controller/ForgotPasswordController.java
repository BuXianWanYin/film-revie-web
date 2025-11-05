package com.springbootdemo.filmreviewweb.controller;

import com.springbootdemo.filmreviewweb.entity.User;
import com.springbootdemo.filmreviewweb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.util.Random;

/**
 * 忘记密码控制器
 */
@Controller
@RequestMapping("/forgot-password")
public class ForgotPasswordController {

    @Autowired
    private UserService userService;

    /**
     * 忘记密码页面
     */
    @GetMapping("")
    public String forgotPasswordPage(Model model, HttpSession session) {
        // 生成验证码
        String captcha = generateCaptcha();
        session.setAttribute("forgotPasswordCaptcha", captcha);
        
        model.addAttribute("captcha", captcha);
        return "forgot-password";
    }

    /**
     * 验证用户名和验证码
     */
    @PostMapping("/verify")
    public String verify(@RequestParam String username,
                        @RequestParam String captcha,
                        HttpSession session,
                        RedirectAttributes redirectAttributes) {
        // 获取Session中的验证码
        String sessionCaptcha = (String) session.getAttribute("forgotPasswordCaptcha");
        
        // 验证验证码
        if (sessionCaptcha == null || !sessionCaptcha.equalsIgnoreCase(captcha)) {
            redirectAttributes.addFlashAttribute("error", "验证码错误，请重新输入");
            // 重新生成验证码
            String newCaptcha = generateCaptcha();
            session.setAttribute("forgotPasswordCaptcha", newCaptcha);
            return "redirect:/forgot-password";
        }
        
        // 验证用户名
        User user = userService.findByUsername(username);
        if (user == null) {
            redirectAttributes.addFlashAttribute("error", "用户名不存在");
            // 重新生成验证码
            String newCaptcha = generateCaptcha();
            session.setAttribute("forgotPasswordCaptcha", newCaptcha);
            return "redirect:/forgot-password";
        }
        
        // 验证通过，将用户名存储到Session中，允许重置密码
        session.setAttribute("forgotPasswordUsername", username);
        session.removeAttribute("forgotPasswordCaptcha"); // 清除验证码
        
        redirectAttributes.addFlashAttribute("success", "验证成功，请设置新密码");
        return "redirect:/password/reset";
    }

    /**
     * 生成4位数字验证码
     */
    private String generateCaptcha() {
        Random random = new Random();
        int captcha = 1000 + random.nextInt(9000); // 生成1000-9999之间的4位数
        return String.valueOf(captcha);
    }
}

