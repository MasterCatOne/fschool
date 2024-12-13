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

 Date: 13/12/2024 10:37:49
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for news
-- ----------------------------
DROP TABLE IF EXISTS `news`;
CREATE TABLE `news`  (
  `new_id` bigint NOT NULL AUTO_INCREMENT COMMENT '新闻id',
  `teacher_id` bigint NOT NULL COMMENT '教师id',
  `new_title` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '新闻标题',
  `new_content` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL COMMENT '新闻的内容',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间\r\n',
  `update_time` datetime NULL DEFAULT NULL COMMENT '发布时间\r\n',
  `is_deleted` tinyint NULL DEFAULT 0 COMMENT '逻辑删除字段\r\n',
  `new_img` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '新闻的图片',
  PRIMARY KEY (`new_id`) USING BTREE,
  INDEX `teacher_id`(`teacher_id` ASC) USING BTREE,
  CONSTRAINT `news_ibfk_1` FOREIGN KEY (`teacher_id`) REFERENCES `teachers` (`teacher_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 109 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of news
-- ----------------------------
INSERT INTO `news` VALUES (1, 9, 'ss305', 'Success consists of going from failure to failure without loss of enthusiasm. You cannot save people, you can just love them.                         ', '2007-03-15 21:26:23', '2022-09-12 01:01:27', 0, 'http://192.168.122.171:1314/images/new1.jpg');
INSERT INTO `news` VALUES (2, 8, 'pakws8', 'In a Telnet session, all communications, including username and password, are transmitted in plain-text, allowing anyone to listen-in                 ', '2003-05-14 05:23:03', '2008-10-13 18:28:24', 0, 'http://192.168.122.171:1314/images/new2.jpg');
INSERT INTO `news` VALUES (3, 7, 'tinwingch302', 'Navicat provides a wide range advanced features, such as compelling code editing capabilities, smart code-completion, SQL formatting, and more.', '2012-06-07 16:50:06', '2000-09-19 07:44:03', 0, 'http://192.168.122.171:1314/images/new3.jpg');
INSERT INTO `news` VALUES (4, 12, 'wfso', 'Genius is an infinite capacity for taking pains. Instead of wondering when your next vacation is, maybe you should set up a life you                  ', '2011-09-30 21:42:13', '2010-03-10 15:11:02', 0, 'http://192.168.122.171:1314/images/new4.jpg');
INSERT INTO `news` VALUES (5, 29, 'cywo', 'Monitored servers include MySQL, MariaDB and SQL Server, and compatible with cloud databases like Amazon RDS, Amazon Aurora, Oracle                   ', '2001-11-16 01:04:09', '2000-06-11 02:53:34', 0, 'http://192.168.122.171:1314/images/new5.jpg');
INSERT INTO `news` VALUES (6, 23, 'hiranm6', 'Monitored servers include MySQL, MariaDB and SQL Server, and compatible with cloud databases like Amazon RDS, Amazon Aurora, Oracle                   ', '2011-08-19 05:25:12', '2021-12-12 18:05:29', 0, 'http://192.168.122.171:1314/images/new6.jpg');
INSERT INTO `news` VALUES (7, 29, 'howingfat', 'A man is not old until regrets take the place of dreams. All journeys have secret destinations of which the traveler is unaware.', '2015-02-14 09:29:07', '2011-07-06 12:52:48', 0, 'http://192.168.122.171:1314/images/new7.jpg');
INSERT INTO `news` VALUES (8, 3, 'hanaishii1011', 'A man is not old until regrets take the place of dreams. Navicat 15 has added support for the system-wide dark mode. You will succeed                 ', '2018-09-30 03:41:38', '2018-09-18 08:58:30', 0, 'http://192.168.122.171:1314/images/new8.jpg');
INSERT INTO `news` VALUES (9, 3, 'luzhennan', 'After comparing data, the window shows the number of records that will be inserted, updated or deleted in the target. To connect to                   ', '2021-05-15 22:48:50', '2015-04-27 22:22:14', 0, 'http://192.168.122.171:1314/images/new9.jpg');
INSERT INTO `news` VALUES (10, 14, 'randyne', 'Navicat Data Modeler is a powerful and cost-effective database design tool which helps you build high-quality conceptual, logical and                 ', '2011-06-26 03:39:48', '2000-09-24 13:14:00', 0, 'http://192.168.122.171:1314/images/new10.jpg');
INSERT INTO `news` VALUES (11, 23, 'kwokkuensiu', 'Typically, it is employed as an encrypted version of Telnet. It can also manage cloud databases such as Amazon Redshift, Amazon RDS,                  ', '2014-02-03 17:07:11', '2011-11-13 12:04:27', 0, 'http://192.168.122.171:1314/images/new11.jpg');
INSERT INTO `news` VALUES (12, 30, 'rita606', 'Navicat provides powerful tools for working with queries: Query Editor for editing the query text directly, and Query Builder, Find                   ', '2009-09-21 21:20:53', '2009-07-29 07:44:42', 0, 'http://192.168.122.171:1314/images/new12.jpg');
INSERT INTO `news` VALUES (13, 3, 'anhowar', 'Remember that failure is an event, not a person. You cannot save people, you can just love them. Remember that failure is an event, not a person.', '2023-06-23 07:59:38', '2024-12-13 09:33:23', 0, 'http://192.168.122.171:1314/images/new13.jpg');
INSERT INTO `news` VALUES (14, 5, 'retanaka', 'All the Navicat Cloud objects are located under different projects. You can share the project to other Navicat Cloud accounts for collaboration.', '2010-12-21 23:05:29', '2017-11-13 04:13:44', 0, 'http://192.168.122.171:1314/images/new14.jpg');
INSERT INTO `news` VALUES (15, 5, 'kentmiura1', 'Instead of wondering when your next vacation is, maybe you should set up a life you don’t need to escape from. To successfully establish            ', '2013-05-02 23:37:02', '2007-10-21 15:47:24', 0, 'http://192.168.122.171:1314/images/new15.jpg');
INSERT INTO `news` VALUES (16, 1, '无论谁哈不包括不可可用性', 'in dolore tempor occaecat quis', '2013-12-31 09:29:09', '2024-12-12 20:10:21', 0, 'http://192.168.122.171:1314/images/new16.jpg');

SET FOREIGN_KEY_CHECKS = 1;
