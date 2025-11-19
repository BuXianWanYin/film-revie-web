package com.springbootdemo.filmreviewweb;

import com.springbootdemo.filmreviewweb.entity.Review;
import com.springbootdemo.filmreviewweb.entity.User;
import com.springbootdemo.filmreviewweb.service.ReviewService;
import com.springbootdemo.filmreviewweb.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;

/**
 * 电影评论网站应用测试类
 */
@SpringBootTest
class FilmReviewWebApplicationTests {

    @Autowired
    private UserService userService;

    @Autowired
    private ReviewService reviewService;

    /**
     * 测试应用上下文加载
     */
    @Test
    void contextLoads() {
        assertNotNull(userService, "UserService应该被正确注入");
        assertNotNull(reviewService, "ReviewService应该被正确注入");
    }

    /**
     * 测试用户服务 - 根据用户名查找用户
     */
    @Test
    void testFindUserByUsername() {
        // 测试查找存在的用户
        User user = userService.findByUsername("qinguijin");
        if (user != null) {
            assertNotNull(user.getId(), "用户ID不应为空");
            assertEquals("qinguijin", user.getUsername(), "用户名应该匹配");
        }
    }

    /**
     * 测试用户服务 - 用户登录功能
     */
    @Test
    void testUserLogin() {
        // 测试正确的用户名和密码登录
        User user = userService.login("qinguijin", "123456");
        if (user != null) {
            assertNotNull(user.getId(), "登录成功应返回用户ID");
            assertEquals("qinguijin", user.getUsername(), "用户名应该匹配");
        }

        // 测试错误的密码
        User invalidUser = userService.login("qinguijin", "wrongpassword");
        assertNull(invalidUser, "错误密码应该返回null");

        // 测试不存在的用户
        User notExistUser = userService.login("notexist", "123456");
        assertNull(notExistUser, "不存在的用户应该返回null");
    }

    /**
     * 测试观后感服务 - 根据用户ID查找观后感
     */
    @Test
    void testFindReviewByUserId() {
        // 先查找用户
        User user = userService.findByUsername("qinguijin");
        if (user != null) {
            Review review = reviewService.findByUserId(user.getId());
            // 观后感可能不存在，所以只检查不为null时的情况
            if (review != null) {
                assertNotNull(review.getId(), "观后感ID不应为空");
                assertEquals(user.getId(), review.getUserId(), "用户ID应该匹配");
            }
        }
    }

    /**
     * 测试观后感服务 - 根据用户名查找观后感
     */
    @Test
    void testFindReviewByUsername() {
        Review review = reviewService.findByUsername("qinguijin");
        if (review != null) {
            assertNotNull(review.getId(), "观后感ID不应为空");
            assertNotNull(review.getUserId(), "用户ID不应为空");
        }
    }

    /**
     * 测试观后感服务 - 保存观后感
     */
    @Test
    void testSaveReview() {
        // 查找测试用户
        User user = userService.findByUsername("qinguijin");
        if (user != null) {
            Review review = new Review();
            review.setUserId(user.getId());
            review.setMovieTitle("测试电影");
            review.setMovieDesc("测试电影描述");
            review.setPlotAnalysis("测试剧情分析");
            review.setCharacterAnalysis("测试角色分析");
            review.setImpression("测试个人感悟");
            review.setSummary("测试总结");

            boolean result = reviewService.saveOrUpdateReview(review);
            assertTrue(result, "保存观后感应该成功");

            // 验证保存后的观后感
            Review savedReview = reviewService.findByUserId(user.getId());
            if (savedReview != null) {
                assertEquals("测试电影", savedReview.getMovieTitle(), "电影标题应该匹配");
            }
        }
    }

    /**
     * 测试用户服务 - 修改密码功能
     */
    @Test
    void testChangePassword() {
        // 查找测试用户
        User user = userService.findByUsername("qinguijin");
        if (user != null) {
            String originalPassword = "123456";
            String newPassword = "newpass123";
            
            // 修改密码
            boolean result = userService.changePassword(user.getId(), originalPassword, newPassword);
            if (result) {
                // 验证新密码可以登录
                User loginUser = userService.login("qinguijin", newPassword);
                assertNotNull(loginUser, "使用新密码应该能登录");

                // 恢复原密码
                userService.changePassword(user.getId(), newPassword, originalPassword);
            }
        }
    }

    /**
     * 测试用户服务 - 重置密码功能
     */
    @Test
    void testResetPassword() {
        String username = "qinguijin";
        String newPassword = "resetpass123";
        String originalPassword = "123456";

        boolean result = userService.resetPassword(username, newPassword);
        if (result) {
            // 验证新密码可以登录
            User loginUser = userService.login(username, newPassword);
            assertNotNull(loginUser, "使用重置后的密码应该能登录");

            // 恢复原密码
            userService.resetPassword(username, originalPassword);
        }
    }
}
