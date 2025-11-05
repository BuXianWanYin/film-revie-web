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

    /**
     * 修改密码页面（已登录用户）
     */
    @GetMapping("/password/change")
    public String changePasswordPage(Model model, HttpSession session) {
        User user = (User) session.getAttribute("user");
        if (user == null) {
            return "redirect:/login";
        }
        model.addAttribute("user", user);
        return "password-change";
    }

    /**
     * 修改密码（已登录用户）
     */
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

    /**
     * 重置密码页面（忘记密码流程）
     */
    @GetMapping("/password/reset")
    public String resetPasswordPage(Model model, HttpSession session, RedirectAttributes redirectAttributes) {
        // 检查是否通过忘记密码验证
        String username = (String) session.getAttribute("forgotPasswordUsername");
        if (username == null) {
            redirectAttributes.addFlashAttribute("error", "请先完成验证");
            return "redirect:/forgot-password";
        }
        
        model.addAttribute("username", username);
        return "password-reset";
    }

    /**
     * 重置密码（忘记密码流程）
     */
    @PostMapping("/password/reset")
    public String resetPassword(@RequestParam String newPassword,
                               @RequestParam String confirmPassword,
                               HttpSession session,
                               RedirectAttributes redirectAttributes) {
        // 检查是否通过忘记密码验证
        String username = (String) session.getAttribute("forgotPasswordUsername");
        if (username == null) {
            redirectAttributes.addFlashAttribute("error", "请先完成验证");
            return "redirect:/forgot-password";
        }
        
        if (!newPassword.equals(confirmPassword)) {
            redirectAttributes.addFlashAttribute("error", "两次输入的密码不一致");
            return "redirect:/password/reset";
        }
        
        boolean success = userService.resetPassword(username, newPassword);
        if (success) {
            // 清除Session中的忘记密码信息
            session.removeAttribute("forgotPasswordUsername");
            redirectAttributes.addFlashAttribute("success", "密码重置成功，请使用新密码登录");
            return "redirect:/login";
        } else {
            redirectAttributes.addFlashAttribute("error", "密码重置失败，请重试");
            return "redirect:/password/reset";
        }
    }
}

