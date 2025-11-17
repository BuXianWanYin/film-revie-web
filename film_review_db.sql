/*
 Navicat Premium Dump SQL

 Source Server         : mysql8
 Source Server Type    : MySQL
 Source Server Version : 80041 (8.0.41)
 Source Host           : localhost:3306
 Source Schema         : film_review_db

 Target Server Type    : MySQL
 Target Server Version : 80041 (8.0.41)
 File Encoding         : 65001

 Date: 17/11/2025 08:59:35
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for review
-- ----------------------------
DROP TABLE IF EXISTS `review`;
CREATE TABLE `review`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '观后感ID',
  `user_id` bigint NOT NULL COMMENT '用户ID',
  `movie_title` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '《南京照相馆》' COMMENT '电影名称',
  `movie_desc` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '电影描述',
  `movie_poster` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '电影海报URL',
  `reason` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL COMMENT '选择理由',
  `plot_analysis` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL COMMENT '情节分析',
  `character_analysis` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL COMMENT '人物塑造',
  `impression` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL COMMENT '最深刻的印象',
  `professional_thinking` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL COMMENT '专业角度思考',
  `summary` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL COMMENT '总结与感悟',
  `create_time` datetime NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `idx_user_id`(`user_id` ASC) USING BTREE,
  CONSTRAINT `fk_review_user` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '观后感表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of review
-- ----------------------------
INSERT INTO `review` VALUES (1, 1, '《南京照相馆》', '一部关于传承与坚守的温情之作', 'https://img2.baidu.com/it/u=2244160751,3334166478&fm=253&fmt=auto?w=1025&h=600', '<p>作为计算机应用工程专业的学生，我被这部电影深深吸引。它不仅展现了传统照相技艺的魅力，更让我思考在数字化时代如何平衡技术进步与人文情怀。</p><p>这部电影让我看到了技术与情感的完美融合</p>', '<p><strong>开篇设置</strong></p><p>影片以一个即将消失的老照相馆为背景，巧妙地设置了传统与现代的冲突点，为后续的情感铺垫奠定了基础。</p><h4>情感递进</h4><p>通过一张张老照片的故事，影片层层递进地展现了人物内心的变化，从抗拒到理解，从冷漠到温情。</p><h4>主题升华</h4><p>结尾处的和解不仅是人物关系的修复，更是传统文化与现代生活的和谐统一，给人以深刻启发。</p>', '<h4>老照相师</h4><p>固执中带着温情，传统中蕴含智慧。他的每一个动作都透露着对手艺的敬畏和对时光的眷恋。</p><h4>年轻摄影师</h4><p>代表新时代的思维方式，在与传统的碰撞中逐渐成长，最终找到了技术与情感的平衡点。</p>', '<p>最打动我的是影片中老师傅教年轻人冲洗照片的那一幕。在昏黄的灯光下，老师傅小心翼翼地操作着每一个步骤，那种专注和虔诚让我想到了我们学习编程时的状态。</p><h4>个人感悟</h4><p>无论是传统的照相技艺还是现代的编程技术，都需要这种工匠精神。技术可以更新换代，但对品质的追求和对细节的关注永远不会过时。</p>', '<h4>技术传承</h4><p>就像照相技术从胶片到数码的演进，计算机技术也在不断发展。我们要学会在创新中保持对基础知识的尊重。</p><h4>用户体验</h4><p>老照相师对每位顾客的用心服务提醒我，无论技术多么先进，最终都要服务于人，关注用户的真实需求。</p><h4>持续学习</h4><p>年轻摄影师的成长过程告诉我，在快速变化的技术领域，保持学习的心态和对传统的敬畏同样重要。</p>', '<p>《南京照相馆》让我重新思考了技术与人文的关系。作为一名计算机专业的学生，我常常沉浸在代码和算法中，但这部电影提醒我，技术的最终目的是为了更好地服务人类，传递温情。</p><h4>未来展望</h4><p>我希望在未来的学习和工作中，能够像影片中的人物一样，在掌握先进技术的同时，不忘初心，用技术创造更多有温度的产品，让科技真正造福人类。</p>', '2025-11-05 19:50:59', '2025-11-05 21:38:13');
INSERT INTO `review` VALUES (2, 2, '《南京照相馆》', '一部关于传承与坚守的温情之作', 'https://img2.baidu.com/it/u=2244160751,3334166478&fm=253&fmt=auto?w=1025&h=600', '<p>这部电影将视角聚焦在南京城里一家普通的照相馆上。南京城破，百姓深陷水深火热之中，吉祥照相馆成了人们的避难所。在这里，邮差阿昌、戏伶毓秀、翻译官王广海、照相馆老板老金一家，原本只是平凡度日的普通人，却被战争无情地卷入生死漩涡。他们被迫为日军冲洗照片，却惊觉照片里全是日军残忍杀害同胞的罪证。那些照片里，无辜百姓惨遭屠戮，被活埋、被枪杀、妇女被凌辱，每一幕都刺痛着观众的心，也深深刺痛了他们。我仿佛也置身于那个黑暗绝望的时代，亲眼目睹了侵略者的暴行，内心充满了愤怒与悲痛。</p>', '<div class=\"timeline-item\"><h3>初次接触</h3><p>这部电影将视角聚焦在南京城里一家普通的照相馆上。南京城破，百姓深陷水深火热之中，吉祥照相馆成了人们的避难所。</p></div><div class=\"timeline-item\"><h3>开场印象</h3><p>是他们在绝境中展现出的勇气和坚守。尽管害怕，尽管力量微薄，但他们没有选择沉默，而是想尽办法守护这些能揭露日军罪行的照片。为了送出这些照片，他们有人付出了生命的代价。当看到老金一家为了保护照片，面对日军的威胁毫不退缩时，我不禁热泪盈眶。他们让我明白，在国家危难之际，平凡人也能拥有伟大的力量，也能成为守护正义和真相的英雄。</p></div><div class=\"timeline-item\"><h3>情感转折</h3><p>电影中的人物形象鲜明且立体。阿昌从最初只求活命的胆小邮差，在目睹同胞惨状后，逐渐觉醒，拼死守护底片；毓秀虽身为女子，却有一身傲骨，与阿昌默契配合，在日军眼皮底下周旋；老金作为照相馆老板，沉稳坚毅，为众人出谋划策。而日军摄影师伊藤的虚伪、翻译官王广海的复杂，也都刻画得入木三分。</p></div>', '<div class=\"character-item\"><h4>阿昌</h4><p>从最初只求活命的胆小邮差，在目睹同胞惨状后，逐渐觉醒，拼死守护底片。</p></div><div class=\"character-item\"><h4>毓秀</h4><p>虽身为女子，却有一身傲骨，与阿昌默契配合，在日军眼皮底下周旋。</p></div><div class=\"character-item\"><h4>老金</h4><p>作为照相馆老板，沉稳坚毅，为众人出谋划策。</p></div>', '<p>最打动我的是影片中老师傅教年轻人冲洗照片的那一幕。在昏黄的灯光下，老师傅小心翼翼地操作着每一个步骤，那种专注和虔诚让我想到了我们学习编程时的状态。无论是传统的照相技艺还是现代的编程技术，都需要这种工匠精神。</p>', '<div class=\"thinking-item\"><h4>历史事件 vs 现代</h4><p>这部电影的独特之处在于，它取材于真实历史事件。1938年，华东照相馆的学徒罗瑾冒着生命危险，秘密冲洗加印日军暴行照片，与爱国青年吴旋接力守护，最终成为审判战犯的重要证据。影片将这一历史事件巧妙改编，让我们看到了普通百姓在绝境中对正义的坚守和对真相的执着。</p></div>', '<p>观影结束，我内心久久不能平静。南京大屠杀不再是课本上那冷冰冰的文字，而是一幅幅惨绝人寰的画面，是无数鲜活生命的消逝。它让我深刻认识到和平的来之不易，我们如今的幸福生活，是先辈们用鲜血和生命换来的。在2025年，这部电影的上映有着深远的意义。它提醒着我们，要铭记历史，勿忘国耻，传承先辈们不屈的精神。同时，也让世界看到那段真实的历史，警惕战争的阴霾再次笼罩。我们应当从电影中汲取力量，努力让国家更强大，让悲剧永不重演。</p>', '2025-11-05 19:50:59', '2025-11-05 19:50:59');
INSERT INTO `review` VALUES (3, 3, '《南京照相馆》', '时光定格中的人文情怀', 'https://img2.baidu.com/it/u=2244160751,3334166478&fm=253&fmt=auto?w=1025&h=600', '<p>当我第一次走进电影院观看《南京照相馆》时，内心充满了复杂的情感。作为一名农业专业的学生，我对传统手工艺有着天然的敬畏之心。农业本身就是一门古老的艺术，从种子到收获，每一个环节都承载着祖辈们的智慧结晶。影片开场的那一刻，黑白胶片的质感瞬间将我拉回到那个充满诗意的年代。老照相馆里弥漫着化学药水的味道，墙上挂满了泛黄的照片，每一张都诉说着一个时代的故事。这让我想起了家乡那些古老的农具，虽然已经被现代机械所取代，但它们身上依然散发着岁月的光芒。</p>', '<div class=\"article-content\"><h2>初见南京照相馆</h2><p>影片开场的那一刻，黑白胶片的质感瞬间将我拉回到那个充满诗意的年代。老照相馆里弥漫着化学药水的味道，墙上挂满了泛黄的照片，每一张都诉说着一个时代的故事。</p><h2>光影中的时代记忆</h2><p>电影的魅力在于它能够跨越时空的界限，让观众在短短两个小时内体验一个完整的人生。《南京照相馆》正是这样一部作品，它用细腻的镜头语言为我们展现了一个时代的缩影。</p></div>', '<div class=\"comparison-item\"><h4>传统价值</h4><p>匠人精神的传承、文化记忆的保存、情感温度的体现、个性化的服务</p></div><div class=\"comparison-item\"><h4>现代优势</h4><p>效率的大幅提升、成本的有效控制、技术的不断创新、普及性的广泛覆盖</p></div>', '<p>影片中的老师傅专注地调试着相机，那种专业的神情让我深深震撼。他的每一个动作都透露着对这门手艺的热爱和尊重，这种匠人精神正是我们这个时代最需要的品质。在农业领域，我们同样需要这种对土地、对作物、对传统种植技艺的敬畏之心。</p>', '<div class=\"insight-card\"><h4>种植技艺</h4><p>传统的种植方法虽然效率不高，但往往更加环保和可持续。我们需要在现代农业技术中融入传统智慧。</p></div><div class=\"insight-card\"><h4>农具工艺</h4><p>古老的农具制作工艺体现了先人的智慧，现代农机设计可以从中汲取灵感，实现功能与美学的统一。</p></div><div class=\"insight-card\"><h4>知识传承</h4><p>农业知识的传承不应该只依赖书本，师傅带徒弟的传统模式在某些领域仍然具有不可替代的价值。</p></div>', '<p>真正的成长不是学会了多少新技能，而是学会了如何在传统与现代之间找到平衡，如何在变化中保持初心。影片中照片是凝固的历史，而我们的专业是动态的实践。这一幕激励我，不能只做历史的旁观者。我们要走进田间地头，去亲身感受土地的脉搏。我们要思考：如何让保留下来的耕地更高效？如何让农业更绿色、可持续？如何让农民的生活更有尊严？这不仅仅是技术问题，更是涉及社会、经济、政策的系统工程。这部电影让我意识到，我们选择的专业，背负着的是如何让中华民族的生存之基——土地，在新时代焕发新生机的重大课题。</p>', '2025-11-05 19:50:59', '2025-11-05 19:50:59');
INSERT INTO `review` VALUES (4, 4, '《南京照相馆》', '用文字记录电影带给我们的感动与思考', 'https://img2.baidu.com/it/u=2244160751,3334166478&fm=253&fmt=auto?w=1025&h=600', '<p>在这个快节奏的时代，很少有电影能让我静下心来，细细品味每一个镜头的深意。《南京照相馆》就是这样一部作品，它没有华丽的特效，没有跌宕起伏的情节，却用最朴实的镜头语言，讲述了一个关于记忆、传承与人性温暖的故事。选择这部电影，源于对历史题材的特殊情感。作为一名年轻人，我总是好奇那些被时光掩埋的故事，想要通过影像去触摸历史的温度。《南京照相馆》恰好满足了我的这种渴望。</p>', '<div class=\"post-section\"><h2>镜头下的人生百态</h2><p>电影通过一家照相馆的视角，展现了南京这座城市的变迁。每一张照片都是一个故事，每一个故事都承载着一段历史。导演用细腻的镜头语言，将个人命运与时代变迁巧妙地交织在一起。</p></div>', '<p>影片中最打动我的是那些平凡人物的真实情感。无论是照相馆老板的坚守，还是顾客们对美好生活的憧憬，都让我感受到了人性中最珍贵的品质——坚韧与希望。</p>', '<p>如果要选择影片中最触动我的一个场景，那一定是老照相师在战火中保护照片的那一幕。当炮火连天，所有人都在逃命的时候，他却冒着生命危险回到照相馆，小心翼翼地收拾那些珍贵的照片。那一刻，我突然明白了什么叫做\"文化的传承\"。这些照片不仅仅是影像，更是历史的见证，是无数家庭的记忆载体。老照相师的行为，体现了一种对文化、对历史、对人性的深深敬畏。</p>', '<p><strong>视觉语言：</strong>导演运用了大量的静态镜头和长镜头，营造出一种沉静、深沉的氛围。这种拍摄手法与照相馆的主题形成了完美的呼应。<br><strong>色彩运用：</strong>影片整体色调偏向暖黄色，给人一种怀旧、温暖的感觉。这种色彩选择不仅符合历史题材的特点，也增强了观众的情感共鸣。<br><strong>音效设计：</strong>片中的音效设计非常细腻，从照相机的快门声到街道上的嘈杂声，每一个声音都恰到好处地烘托了氛围。</p>', '<p>看完《南京照相馆》，我陷入了深深的思考。在这个数字化的时代，我们拍照变得如此容易，随手一拍就是成百上千张照片。但是，我们是否还记得照片背后的故事？是否还珍惜那些定格的瞬间？这部电影让我重新审视了记忆与传承的意义。每一张照片都是历史的片段，每一个故事都值得被记录和传承。作为年轻一代，我们有责任去了解历史，去珍惜当下，去为未来留下有意义的记录。同时，影片也让我思考了艺术创作的本质。真正优秀的作品不需要华丽的包装，只需要真诚的情感和深刻的内涵。《南京照相馆》正是这样一部作品，它用最朴实的方式，传达了最深刻的主题。在这个快速变化的时代，我们需要这样的作品来提醒我们：不要忘记历史，不要忽视平凡，不要失去对美好的向往。愿每一个观看这部电影的人，都能在光影交错中找到属于自己的感动和思考。</p>', '2025-11-05 19:50:59', '2025-11-05 19:50:59');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '用户ID',
  `username` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '用户名',
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '密码',
  `real_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '真实姓名',
  `gender` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '性别',
  `avatar` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '头像路径',
  `create_time` datetime NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `uk_username`(`username` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '用户表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'qinguijin', 'e10adc3949ba59abbe56e057f20f883e', '覃桂锦', '男', '/images/qinguijin.png', '2025-11-05 19:50:59', '2025-11-05 19:50:59');
INSERT INTO `user` VALUES (2, 'zhubinbo', 'e10adc3949ba59abbe56e057f20f883e', '朱斌博', '男', '/images/zhubinbo.png', '2025-11-05 19:50:59', '2025-11-05 19:50:59');
INSERT INTO `user` VALUES (3, 'suzixiang', 'e10adc3949ba59abbe56e057f20f883e', '苏子翔', '男', '/images/suzixiang.png', '2025-11-05 19:50:59', '2025-11-05 19:50:59');
INSERT INTO `user` VALUES (4, 'qinzhaorui', 'e10adc3949ba59abbe56e057f20f883e', '覃照睿', '女', '/images/qinzhaorui.png', '2025-11-05 19:50:59', '2025-11-05 19:50:59');

SET FOREIGN_KEY_CHECKS = 1;
