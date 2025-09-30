# 《南京照相馆》观影感悟网站

## 在线演示

🌐 **演示地址**: [http://buxianwanyin.cn:8081/](http://buxianwanyin.cn:8081/)

您可以直接访问上述地址体验完整的网站功能，无需本地部署。
## 项目简介

这是一个基于Spring Boot开发的电影观影感悟网站，专注于《南京照相馆》这部历史题材电影的深度分析和观影体验分享。网站汇集了计算机应用工程专业四位学生的独特观影视角，结合技术思维和人文情怀，为用户提供全面的电影解读和个人感悟分享。

## 功能特色

### 🎬 电影介绍
- 详细的剧情概述和背景介绍
- 专业的影片分析和评价
- 精美的视觉设计和用户体验
- 主要演员卡片式展示，包含角色分析和表演亮点

### 👥 演员介绍
- 主要演员的详细资料和个人简介
- 角色分析和表演评价
- 演员作品回顾和职业生涯介绍
- 响应式卡片布局设计

### 🎭 电影内涵
- 深度的主题思考和象征意义解读
- 历史背景和文化内涵分析
- 计算机专业学生的独特观影视角
- 多维度的电影价值探讨

### 📝 个人观影感悟
- **覃桂锦**：从技术与人文的角度深度解读
- **朱斌博**：时间轴式观影历程分享
- **苏子翔**：多层次价值观思考和未来展望
- **覃照睿**：女性视角的细腻观影体验
- 每位学生都有独立的个人页面和头像展示

## 技术栈

- **后端框架**: Spring Boot 2.6.13
- **模板引擎**: Thymeleaf
- **前端技术**: HTML5, CSS3, JavaScript
- **构建工具**: Maven 3.x
- **开发环境**: Java 11
- **开发工具**: Spring Boot DevTools（热重载）

## 项目结构

```
film-review-web/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/springbootdemo/filmreviewweb/
│   │   │       ├── FilmReviewWebApplication.java    # 主启动类
│   │   │       └── controller/
│   │   │           └── HomeController.java          # 主控制器
│   │   └── resources/
│   │       ├── static/                              # 静态资源
│   │       │   ├── css/
│   │       │   │   └── style.css                   # 主样式文件
│   │       │   ├── images/                         # 学生头像图片
│   │       │   │   ├── qinguijin.png
│   │       │   │   ├── qinzhaorui.png
│   │       │   │   ├── suzixiang.png
│   │       │   │   └── zhubinbo.png
│   │       │   ├── js/
│   │       │   │   └── mobile-menu.js              # 移动端菜单脚本
│   │       │   └── index.html                      # 静态首页（备用）
│   │       ├── templates/                          # Thymeleaf模板
│   │       │   ├── index.html                      # 主页模板
│   │       │   ├── movie-intro.html                # 电影介绍页
│   │       │   ├── actors.html                     # 演员介绍页
│   │       │   ├── meaning.html                    # 电影内涵页
│   │       │   └── reviews/                        # 个人观影感悟
│   │       │       ├── qinguijin.html              # 覃桂锦的感悟
│   │       │       ├── qinzhaorui.html             # 覃照睿的感悟
│   │       │       ├── suzixiang.html              # 苏子翔的感悟
│   │       │       └── zhubinbo.html               # 朱斌博的感悟
│   │       └── application.yml                     # 配置文件
│   └── test/                                       # 测试文件
├── target/                                         # 构建输出目录
├── pom.xml                                         # Maven配置
├── .gitignore                                      # Git忽略文件
└── README.md                                       # 项目说明
```

## 快速开始

### 环境要求

- **Java**: 11 或更高版本
- **Maven**: 3.6+ 
- **IDE**: 推荐IntelliJ IDEA或Eclipse
- **浏览器**: 支持现代浏览器（Chrome、Firefox、Safari、Edge）

### 安装步骤

1. **克隆项目**
   ```bash
   git clone [项目地址]
   cd film-review-web
   ```

2. **安装依赖**
   ```bash
   mvn clean install
   ```

3. **运行项目**
   ```bash
   mvn spring-boot:run
   ```
   
   或者在IDE中直接运行 `FilmReviewWebApplication.java`

4. **访问网站**
   
   打开浏览器访问：`http://localhost:8081`

## 页面路由

| 路由 | 页面 | 描述 |
|------|------|------|
| `/` | 首页 | 网站概览和导航入口 |
| `/movie-intro` | 电影介绍 | 《南京照相馆》详细介绍和演员卡片 |
| `/actors` | 演员介绍 | 主要演员资料和作品分析 |
| `/meaning` | 电影内涵 | 深度主题解读和文化分析 |
| `/review/qinguijin` | 覃桂锦感悟 | 技术与人文视角的观影体验 |
| `/review/zhubinbo` | 朱斌博感悟 | 时间轴式观影历程分享 |
| `/review/suzixiang` | 苏子翔感悟 | 多层次价值观思考 |
| `/review/qinzhaorui` | 覃照睿感悟 | 女性视角的细腻观影体验 |

## 设计亮点

### 🎨 视觉设计
- **现代化响应式设计**：完美适配桌面端、平板端和移动端
- **优雅的色彩搭配**：采用渐变背景和统一的视觉风格
- **卡片式布局**：演员介绍采用现代卡片设计，信息层次清晰
- **流畅的用户交互**：悬停效果、过渡动画和移动端友好的导航

### 📱 响应式特性
- **桌面端**：三列网格布局，充分利用屏幕空间
- **平板端**：自适应列数，保持良好的阅读体验
- **移动端**：单列布局，汉堡菜单导航，优化触摸操作
- **图片优化**：响应式图片加载，适配不同屏幕尺寸

### 🔧 技术特色
- **本地化资源**：所有图片和静态资源本地化，避免外部依赖
- **语义化HTML**：结构清晰，SEO友好
- **模块化CSS**：样式组织合理，易于维护
- **热重载开发**：集成Spring Boot DevTools，提升开发效率
- **移动端优化**：专门的移动端菜单脚本和样式

## 内容特色

### 📚 多元化视角
本网站汇集了四位计算机应用工程专业学生的观影感悟：

- **覃桂锦（男）**：从技术发展与传统文化传承的角度思考
- **朱斌博（男）**：采用时间轴形式记录观影历程和心路变化
- **苏子翔（男）**：多维度价值观分析和未来职业规划思考
- **覃照睿（女）**：细腻的情感体验和女性独特的观影视角

### 🎯 深度分析
- **历史背景梳理**：详细的时代背景和历史文化分析
- **人物关系剖析**：深入的角色分析和人物关系解读
- **象征意义解读**：多层次的隐喻和象征意义探讨
- **现实意义思考**：结合当代社会的深度思考和启发

### 💡 专业视角
作为计算机应用工程专业的学生作品，网站体现了：
- **技术与人文的融合**：用技术手段展现人文关怀
- **传统与现代的对话**：思考数字化时代的传统文化传承
- **理性与感性的平衡**：既有技术分析又有情感体验

## 开发配置

### 应用配置 (application.yml)
```yaml
server:
  port: 8081                    # 服务端口

spring:
  thymeleaf:
    prefix: classpath:/templates/
    suffix: .html
    mode: HTML
    encoding: UTF-8
    cache: false                # 开发环境关闭缓存
```

### 自定义配置
- **端口修改**：在 `application.yml` 中修改 `server.port`
- **模板缓存**：生产环境建议设置 `spring.thymeleaf.cache: true`
- **静态资源**：放置在 `src/main/resources/static/` 目录下

## 构建和部署

### 本地构建
```bash
# 编译项目
mvn compile

# 运行测试
mvn test

# 打包应用
mvn package

# 运行打包后的jar
java -jar target/film-review-web-0.0.1-SNAPSHOT.jar
```

### 生产部署
1. 修改 `application.yml` 中的配置（如端口、缓存等）
2. 执行 `mvn clean package` 打包
3. 将生成的jar文件部署到服务器
4. 使用 `java -jar` 命令启动应用

## 开发说明

### 添加新的观影感悟
1. 在 `HomeController.java` 中添加新的路由映射
2. 在 `templates/reviews/` 目录下创建对应的HTML模板
3. 在 `static/images/` 目录下添加学生头像图片
4. 更新导航菜单和相关链接

### 样式定制
- 主样式文件：`src/main/resources/static/css/style.css`
- 响应式断点：768px（移动端）
- 颜色主题：可在CSS文件顶部的变量中修改

### 移动端适配
- 汉堡菜单脚本：`src/main/resources/static/js/mobile-menu.js`
- 移动端样式：在 `@media (max-width: 768px)` 中定义
- 触摸友好的交互设计

### 贡献流程
1. Fork 本项目
2. 创建特性分支 (`git checkout -b feature/AmazingFeature`)
3. 提交更改 (`git commit -m 'Add some AmazingFeature'`)
4. 推送到分支 (`git push origin feature/AmazingFeature`)
5. 开启 Pull Request

### 代码规范
- 遵循Java编码规范
- HTML模板使用语义化标签
- CSS使用BEM命名规范
- JavaScript使用ES6+语法

## 许可证

本项目采用 MIT 许可证 - 查看 [LICENSE](LICENSE) 文件了解详情。

## 联系方式

如有问题或建议，欢迎通过以下方式联系：

- **邮箱**：2644832053@qq.com

## 致谢

感谢所有参与本项目的同学们

*本项目仅用于学习交流，所有电影相关内容版权归原作者所有。*
*《南京照相馆》是一部优秀的历史题材电影，值得每个人深入思考和品味。*