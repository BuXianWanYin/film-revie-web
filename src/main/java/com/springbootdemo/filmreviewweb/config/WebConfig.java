package com.springbootdemo.filmreviewweb.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import com.springbootdemo.filmreviewweb.interceptor.LoginInterceptor;

/**
 * Web配置类
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor())
                .addPathPatterns("/**")  // 拦截所有路径
                .excludePathPatterns(
                    "/login",              // 登录页面
                    "/login/submit",       // 登录提交
                    "/logout",             // 退出登录
                    "/forgot-password",    // 忘记密码页面
                    "/forgot-password/verify", // 忘记密码验证
                    "/password/reset",     // 重置密码页面（忘记密码流程）
                    "/password/reset",     // 重置密码提交（忘记密码流程）
                    "/static/**",          // 静态资源
                    "/css/**",             // CSS文件
                    "/js/**",              // JS文件
                    "/images/**",          // 图片文件
                    "/error",              // 错误页面
                    "/favicon.ico"         // 网站图标
                );
    }
}

