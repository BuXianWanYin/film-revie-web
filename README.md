# 《南京照相馆》观影感悟网站

## 项目简介

这是一个基于Spring Boot开发的电影观影感悟网站，专注于《南京照相馆》这部历史题材电影的深度分析和观影体验分享。网站从计算机应用工程专业学生的独特视角出发，结合技术思维和人文情怀，为用户提供全面的电影解读。

## 功能特色

### 🎬 电影介绍
- 详细的剧情概述和背景介绍
- 专业的影片分析和评价
- 精美的视觉设计和用户体验

### 👥 演员介绍
- 主要演员的详细资料
- 角色分析和表演评价
- 演员作品回顾

### 🎭 电影内涵
- 深度的主题思考和象征意义解读
- 历史背景和文化内涵分析
- 计算机专业学生的独特观影视角

### 📝 个人观影感悟
- 多篇原创观影心得
- 不同角度的深度思考
- 专业与人文的完美结合

## 技术栈

- **后端框架**: Spring Boot 2.x
- **模板引擎**: Thymeleaf
- **前端技术**: HTML5, CSS3, JavaScript
- **构建工具**: Maven
- **开发环境**: Java 8+

## 项目结构

```
film-review-web/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/filmreview/
│   │   │       └── controller/          # 控制器层
│   │   └── resources/
│   │       ├── static/
│   │       │   ├── css/                 # 样式文件
│   │       │   └── images/              # 本地图片资源
│   │       ├── templates/               # Thymeleaf模板
│   │       │   ├── index.html          # 主页
│   │       │   ├── movie-intro.html    # 电影介绍
│   │       │   ├── actors.html         # 演员介绍
│   │       │   ├── meaning.html        # 电影内涵
│   │       │   └── reviews/            # 个人观影感悟
│   │       └── application.yml         # 配置文件
│   └── test/                           # 测试文件
├── pom.xml                             # Maven配置
└── README.md                           # 项目说明
```

## 快速开始

### 环境要求

- Java 11
- Maven 3.6+
- IDE（推荐IntelliJ IDEA或Eclipse）

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

4. **访问网站**
   
   打开浏览器访问：`http://localhost:8081`

## 页面导航

- **首页** (`/`) - 网站概览和导航入口
- **电影介绍** (`/movie-intro`) - 《南京照相馆》详细介绍
- **演员介绍** (`/actors`) - 主要演员资料和分析
- **电影内涵** (`/meaning`) - 深度主题解读
- **个人观影感悟** (`/reviews/*`) - 多篇原创观影心得

## 设计亮点

### 🎨 视觉设计
- 现代化的响应式设计
- 优雅的色彩搭配和排版
- 精心制作的SVG图标和插图
- 流畅的用户交互体验

### 📱 响应式布局
- 完美适配桌面端和移动端
- 灵活的网格系统
- 优化的图片加载策略

### 🔧 技术特色
- 本地化图片资源，避免外部依赖
- 语义化的HTML结构
- 模块化的CSS组织
- 优化的页面加载性能

## 内容特色

### 📚 专业视角
作为计算机应用工程专业的学生作品，本网站不仅关注电影的艺术价值，更从技术角度思考：
- 数字化时代的传统工艺传承
- 技术与人文的平衡关系
- 信息时代的历史记忆保存

### 🎯 深度分析
- 历史背景的详细梳理
- 人物关系的深入剖析
- 象征意义的多层解读
- 现实意义的深度思考

## 开发说明

### 配置文件

主要配置在 `application.yml` 中：
```yaml
server:
  port: 8080

spring:
  thymeleaf:
    cache: false
    encoding: UTF-8
```

### 自定义配置

如需修改端口或其他配置，请编辑 `src/main/resources/application.yml` 文件。

## 贡献指南

欢迎提交Issue和Pull Request来改进这个项目！

1. Fork 本项目
2. 创建特性分支 (`git checkout -b feature/AmazingFeature`)
3. 提交更改 (`git commit -m 'Add some AmazingFeature'`)
4. 推送到分支 (`git push origin feature/AmazingFeature`)
5. 开启 Pull Request

## 许可证

本项目采用 MIT 许可证 - 查看 [LICENSE](LICENSE) 文件了解详情。

## 联系方式

如有问题或建议，欢迎通过以下方式联系：

- 邮箱: [2644832053@qq.com]

---

*本项目仅用于学习交流，所有电影相关内容版权归原作者所有。*