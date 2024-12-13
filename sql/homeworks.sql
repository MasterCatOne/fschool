/*
 Navicat Premium Data Transfer

 Source Server         : mysq
 Source Server Type    : MySQL
 Source Server Version : 80036
 Source Host           : localhost:3306
 Source Schema         : fschool

 Target Server Type    : MySQL
 Target Server Version : 80036
 File Encoding         : 65001

 Date: 13/12/2024 10:37:36
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for homeworks
-- ----------------------------
DROP TABLE IF EXISTS `homeworks`;
CREATE TABLE `homeworks`  (
  `homework_id` bigint NOT NULL AUTO_INCREMENT COMMENT '作业id',
  `teacher_id` bigint NOT NULL COMMENT '教师id',
  `class_id` bigint NOT NULL COMMENT '班级id',
  `homework_title` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '作业标题',
  `homework_content` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL COMMENT '作业的内容',
  `deadline` date NULL DEFAULT NULL COMMENT '截止日期',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间\r\n',
  `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间\r\n',
  `is_deleted` tinyint NULL DEFAULT 0 COMMENT '逻辑删除字段\r\n',
  `process` bigint NULL DEFAULT NULL COMMENT '作业完成进度',
  PRIMARY KEY (`homework_id`) USING BTREE,
  INDEX `class_id`(`class_id` ASC) USING BTREE,
  INDEX `teacher_id`(`teacher_id` ASC) USING BTREE,
  CONSTRAINT `homeworks_ibfk_1` FOREIGN KEY (`class_id`) REFERENCES `classes` (`class_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `homeworks_ibfk_2` FOREIGN KEY (`teacher_id`) REFERENCES `teachers` (`teacher_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 26 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of homeworks
-- ----------------------------
INSERT INTO `homeworks` VALUES (1, 7, 1, '数学探索：一次函数的应用与解析', 'The On Startup feature allows you to control what tabs appear when you launch Navicat.              ', '2025-02-18', '2011-08-03 14:26:11', '2007-06-27 19:17:21', 0, 60);
INSERT INTO `homeworks` VALUES (2, 34, 1, '文学鉴赏：解读《红楼梦》中林黛玉的人物形象', 'The On Startup feature allows you to control what tabs appear when you launch Navicat.', '2025-01-11', '2011-07-05 15:27:21', '2014-02-27 05:49:13', 0, 31);
INSERT INTO `homeworks` VALUES (3, 36, 5, '物理实验报告：光的折射与反射现象研究', 'To successfully establish a new connection to local/remote server - no matter via                   ', '2025-01-05', '2001-03-18 09:24:28', '2024-12-06 03:59:27', 0, 75);
INSERT INTO `homeworks` VALUES (4, 1, 5, '历史回顾：二战期间的重要战役与转折点分析', 'Anyone who has never made a mistake has never tried anything new.', '2025-02-05', '2024-03-21 16:04:13', '2024-12-13 10:08:16', 1, 16);
INSERT INTO `homeworks` VALUES (5, 11, 2, '化学合成实验：制备并分析乙酸乙酯的性质\r\n', 'Import Wizard allows you to import data to tables/collections from CSV, TXT, XML, DBF and more.     ', '2025-01-23', '2002-12-04 10:44:03', '2023-01-29 04:45:46', 0, 22);
INSERT INTO `homeworks` VALUES (6, 4, 2, '英语阅读理解：探讨《简·爱》中的爱情观\r\n', 'Navicat provides a wide range advanced features, such as compelling code editing                    ', '2025-02-03', '2008-06-04 15:05:38', '2005-07-04 19:34:17', 0, 91);
INSERT INTO `homeworks` VALUES (7, 2, 2, '生物观察日记：记录植物生长过程中的变化\r\n', 'All the Navicat Cloud objects are located under different projects. You can share                   ', '2025-03-04', '2009-09-27 18:33:30', '2013-02-28 10:25:51', 0, 3);
INSERT INTO `homeworks` VALUES (8, 3, 5, '地理调研报告：分析某地区气候变化对农业的影响\r\n', 'Flexible settings enable you to set up a custom key for comparison and synchronization.', '2025-01-25', '2014-11-08 01:22:02', '2016-10-01 01:17:03', 0, 92);
INSERT INTO `homeworks` VALUES (9, 6, 3, '信息技术项目：开发简易网页设计与实现\r\n', 'The Information Pane shows the detailed object information, project activities, the                 ', '2025-03-07', '2022-01-01 04:00:42', '2024-12-12 19:33:29', 0, 67);
INSERT INTO `homeworks` VALUES (10, 31, 5, '美术创作：以“四季之美”为主题的绘画作品\r\n', 'You must be the change you wish to see in the world. You must be the change you wish                ', '2024-12-27', '2017-01-07 21:42:09', '2024-12-12 19:33:22', 0, 12);
INSERT INTO `homeworks` VALUES (11, 14, 4, '物理小论文：探讨量子物理的基本原理与未来发展\r\n', 'The repository database can be an existing MySQL, MariaDB, PostgreSQL, SQL Server,                  ', '2025-02-22', '2010-03-16 12:10:20', '2009-05-03 03:45:56', 0, 97);
INSERT INTO `homeworks` VALUES (12, 33, 3, '音乐赏析：分析贝多芬《命运交响曲》的音乐特点\r\n', 'Champions keep playing until they get it right. You must be the change you wish to see in the world.', '2025-02-25', '2002-01-01 15:23:40', '2020-04-14 10:09:28', 0, 11);
INSERT INTO `homeworks` VALUES (13, 13, 4, '经济案例分析：研究某企业成功与失败的市场策略\r\n', 'With its well-designed Graphical User Interface(GUI), Navicat lets you quickly and                  ', '2025-03-02', '2005-11-07 17:16:07', '2022-01-20 21:21:56', 0, 53);
INSERT INTO `homeworks` VALUES (14, 26, 5, '语文写作：撰写一篇关于“梦想与坚持”的议论文\r\n流业', 'I may not have gone where I intended to go, but I think I have ended up where I needed to be.       ', '2025-03-03', '2024-10-15 19:15:13', '2024-12-12 19:32:56', 0, 48);
INSERT INTO `homeworks` VALUES (15, 14, 5, '科学实验设计：探究不同温度对酶活性的影响\r\n', 'Navicat Cloud provides a cloud service for synchronizing connections, queries, model                ', '2024-12-30', '2001-12-16 11:06:10', '2010-09-22 11:43:02', 0, 4);
INSERT INTO `homeworks` VALUES (16, 31, 4, '社会调查：研究青少年网络成瘾的原因与对策\r\n', 'To start working with your server in Navicat, you should first establish a connection               ', '2025-02-04', '2015-10-26 03:10:40', '2001-04-25 23:31:04', 0, 72);
INSERT INTO `homeworks` VALUES (17, 31, 1, '法语口语练习：模拟旅游场景中的对话交流\r\n', 'The Information Pane shows the detailed object information, project activities, the                 ', '2025-02-02', '2010-01-26 22:28:46', '2008-09-11 08:39:49', 0, 60);
INSERT INTO `homeworks` VALUES (18, 26, 4, '体育技能训练：制定个人篮球投篮提升计划\r\n', 'It is used while your ISPs do not allow direct connections, but allows establishing                 ', '2025-03-08', '2012-05-10 06:09:21', '2000-06-21 21:47:16', 0, 16);
INSERT INTO `homeworks` VALUES (19, 12, 2, '天文观测报告：记录并解析一次天文现象\r\n', 'HTTP Tunneling is a method for connecting to a server that uses the same protocol                   ', '2025-02-12', '2011-01-13 00:59:59', '2011-02-25 15:06:37', 0, 35);
INSERT INTO `homeworks` VALUES (20, 3, 2, '心理健康研究：探讨压力管理的方法与效果\r\n', 'In other words, Navicat provides the ability for data in different databases and/or                 ', '2025-02-23', '2016-05-31 03:08:17', '2016-09-16 05:59:23', 0, 75);
INSERT INTO `homeworks` VALUES (21, 4, 2, '编程实践：用Python实现一个简单的数据可视化项目\r\n', 'Champions keep playing until they get it right. It provides strong authentication                   ', '2025-02-02', '2006-12-27 14:56:18', '2017-07-02 15:41:23', 0, 17);
INSERT INTO `homeworks` VALUES (22, 3, 5, '环境科学考察：调查当地河流的水质污染情况\r\n', 'You will succeed because most people are lazy. After logged in the Navicat Cloud                    ', '2024-12-28', '2002-07-30 05:10:38', '2003-10-14 09:56:43', 0, 38);

SET FOREIGN_KEY_CHECKS = 1;
