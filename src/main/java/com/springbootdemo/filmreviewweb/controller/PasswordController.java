package com.springbootdemo.filmreviewweb.controller;

import com.springbootdemo.filmreviewweb.entity.User;
import com.springbootdemo.filmreviewweb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;

/**
 * 密码修改控制器
 */
@Controller
public class PasswordController {

    @Autowired
    private UserService userService;

    @GetMapping("/password/change")
    public String changePasswordPage(Model model) {
        return "password-change";
    }

    @PostMapping("/password/change")
    public String changePassword(@RequestParam String oldPassword,
                                 @RequestParam String newPassword,
                                 @RequestParam String confirmPassword,
                                 HttpSession session,
                                 RedirectAttributes redirectAttributes) {
        User user = (User) session.getAttribute("user");
        
        if (user == null) {
            redirectAttributes.addFlashAttribute("error", "请先登录");
            return "redirect:/login";
        }
        
        if (!newPassword.equals(confirmPassword)) {
            redirectAttributes.addFlashAttribute("error", "两次输入的密码不一致");
            return "redirect:/password/change";
        }
        
        boolean success = userService.changePassword(user.getId(), oldPassword, newPassword);
        if (success) {
            redirectAttributes.addFlashAttribute("success", "密码修改成功");
            return "redirect:/password/change";
        } else {
            redirectAttributes.addFlashAttribute("error", "原密码错误");
            return "redirect:/password/change";
        }
    }
}

