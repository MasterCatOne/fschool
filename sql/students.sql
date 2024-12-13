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

 Date: 13/12/2024 10:38:01
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for students
-- ----------------------------
DROP TABLE IF EXISTS `students`;
CREATE TABLE `students`  (
  `student_id` bigint NOT NULL AUTO_INCREMENT,
  `homework_id` bigint NULL DEFAULT NULL COMMENT '作业id',
  `class_id` bigint NULL DEFAULT NULL COMMENT '班级id',
  `teacher_id` bigint NULL DEFAULT NULL COMMENT '班主任id',
  `parent_id` bigint NULL DEFAULT NULL COMMENT '家长id',
  `student_name` varchar(128) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '姓名',
  `student_age` int NULL DEFAULT NULL COMMENT '年龄',
  `student_pwd` varchar(124) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '学生密码',
  `role` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT 'student' COMMENT '角色',
  `student_sex` tinyint NULL DEFAULT 1 COMMENT '0表示女，1表示男',
  `score` int NULL DEFAULT NULL COMMENT '成绩',
  `comment` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '评语',
  `avatar` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT 'http://192.168.122.171:1314' COMMENT '头像',
  `secret` varchar(12) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '盐，用于个人敏感信息处理',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime NULL DEFAULT NULL COMMENT '跟新时间',
  `is_deleted` tinyint UNSIGNED NULL DEFAULT 0 COMMENT '删除标记（1:不可用 0:可用）',
  `xuehao` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '学号',
  `is_online` tinyint NULL DEFAULT 0 COMMENT '0表示在线，1表示不在线',
  PRIMARY KEY (`student_id`) USING BTREE,
  INDEX `students_ibfk_1`(`class_id` ASC) USING BTREE,
  INDEX `students_ibfk_2`(`homework_id` ASC) USING BTREE,
  INDEX `students_ibfk_3`(`teacher_id` ASC) USING BTREE,
  INDEX `students_ibfk_4`(`parent_id` ASC) USING BTREE,
  CONSTRAINT `students_ibfk_1` FOREIGN KEY (`class_id`) REFERENCES `classes` (`class_id`) ON DELETE SET NULL ON UPDATE CASCADE,
  CONSTRAINT `students_ibfk_2` FOREIGN KEY (`homework_id`) REFERENCES `homeworks` (`homework_id`) ON DELETE SET NULL ON UPDATE CASCADE,
  CONSTRAINT `students_ibfk_3` FOREIGN KEY (`teacher_id`) REFERENCES `teachers` (`teacher_id`) ON DELETE SET NULL ON UPDATE CASCADE,
  CONSTRAINT `students_ibfk_4` FOREIGN KEY (`parent_id`) REFERENCES `parents` (`parent_id`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 112 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of students
-- ----------------------------
INSERT INTO `students` VALUES (1, NULL, 4, 13, 106, '潘睿', 18, 'AOSqzPgU9d', 'student', 0, 268, 'To successfully establish a new connection to local/remote server - no matter via SSL or SSH, set the database login information in the General tab.', 'http://192.168.122.171:1314/images/1.jpg', 'WVjQwWLuA4', '2018-02-27 13:29:54', '2009-01-16 21:51:09', 0, 'eCu7ZZAYfv', 1);
INSERT INTO `students` VALUES (2, NULL, 5, 13, 125, '昝睿', 18, '$1$g2oCQe$Ded5.gY/sBGbwKx0dPoe0/', 'student', 0, 559, 'SSH serves to prevent such vulnerabilities and allows you to access a remote server\'s shell without compromising security.                            ', 'http://192.168.122.171:1314/images/2.jpg', '$1$g2oCQe', '2022-05-01 03:41:34', '2024-12-12 19:33:07', 0, '3rSi0oqRxx', 1);
INSERT INTO `students` VALUES (3, NULL, 2, 3, 128, '高震南', 15, 'PvJEwRmPpy', 'student', 1, 649, 'To start working with your server in Navicat, you should first establish a connection or several connections using the Connection window.', 'http://192.168.122.171:1314/images/3.jpg', 'F9bbdqiWwW', '2012-06-28 01:58:50', '2016-05-14 06:00:00', 0, 'lm1WoOZMgW', 1);
INSERT INTO `students` VALUES (4, NULL, 5, 15, 110, '李震南', 17, '$1$UXdJxu$f./qjWWdaqPyAoZioujix1', 'student', 1, 432, 'Navicat allows you to transfer data from one database and/or schema to another with detailed analytical process.', 'http://192.168.122.171:1314/images/4.jpg', '$1$UXdJxu', '2003-04-02 17:21:19', '2024-12-12 16:21:35', 0, 'YitJzv4YYM8', 0);
INSERT INTO `students` VALUES (5, NULL, 3, 1, 122, '吕秀英', 21, 'jmDcQMGord', 'student', 0, 144, 'A man’s best friends are his ten fingers. If it scares you, it might be a good thing to try. You will succeed because most people are lazy.', 'http://192.168.122.171:1314/images/5.jpg', 'EeGQmJWN58', '2010-07-30 15:21:59', '2014-12-29 09:16:40', 0, '2tcdCgx712', 0);
INSERT INTO `students` VALUES (6, NULL, 2, 11, 127, '何秀英', 19, 'TfumgWhfgQ', 'student', 0, 310, 'What you get by achieving your goals is not as important as what you become by achieving your goals. HTTP Tunneling is a method for                   ', 'http://192.168.122.171:1314/images/6.jpg', 'X0f3JusmWf', '2024-03-19 08:40:19', '2005-05-11 14:41:29', 0, 'Nh0Qdici43', 1);
INSERT INTO `students` VALUES (7, NULL, 3, 26, 121, '马嘉伦', 16, '$1$DUtkJF$3UzvqUtMwyl30gWyTxWek/', 'student', 0, 360, 'All the Navicat Cloud objects are located under different projects. You can share the project to other Navicat Cloud accounts for collaboration.', 'http://192.168.122.171:1314/images/7.jpg', '$1$DUtkJF', '2003-02-07 18:43:50', '2024-12-12 16:25:54', 0, '6NQ5YmIzQg', 1);
INSERT INTO `students` VALUES (8, NULL, 5, 14, 108, '许岚', 1, '$1$7ucMQG$uKm4UNPZ2kaTf/eDTwFSI1', 'student', 1, 591, 'Creativity is intelligence having fun. Navicat allows you to transfer data from one database and/or schema to another with detailed                   ', 'http://192.168.122.171:1314/images/8.jpg', '$1$7ucMQG', '2024-10-08 06:53:20', '2024-12-12 21:55:55', 0, '123', 0);
INSERT INTO `students` VALUES (9, NULL, 4, 1, 117, '叶嘉伦', 19, 'zmnhrMNrtS', 'student', 1, 412, 'After comparing data, the window shows the number of records that will be inserted, updated or deleted in the target. I destroy my                    ', 'http://192.168.122.171:1314/images/9.jpg', 'UsBYI8ZT7n', '2003-12-05 19:40:52', '2000-09-02 01:01:15', 0, '14lvLJWRGe', 1);
INSERT INTO `students` VALUES (10, NULL, 3, 14, 126, '冯睿', 15, '$1$HUNsVd$M2JN9iaaOVg.oO9dkaTTg0', 'student', 1, 466, 'HTTP Tunneling is a method for connecting to a server that uses the same protocol (http://) and the same port (port 80) as a web server does.', 'http://192.168.122.171:1314/images/10.jpg', '$1$HUNsVd', '2013-10-27 04:11:46', '2024-12-12 16:26:09', 0, '2IUIsgmv6l', 1);
INSERT INTO `students` VALUES (11, NULL, 2, 5, 111, '马嘉伦', 20, 'q2XoQmUbgi', 'student', 0, 22, 'If the plan doesn’t work, change the plan, but never the goal. SSH serves to prevent such vulnerabilities and allows you to access                  ', 'http://192.168.122.171:1314/images/12.jpg', 'wGRKkJDvgr', '2005-05-22 09:31:56', '2024-01-25 05:40:02', 0, 'PlsKL5iNGO', 1);
INSERT INTO `students` VALUES (12, NULL, 5, 23, 118, '贺晓明', 19, '$1$yZOK0Y$lwaCGhOlOE/E.BHQ641P.0', 'student', 1, 723, 'Difficult circumstances serve as a textbook of life for people. I destroy m', 'http://192.168.122.171:1314/images/13.jpg', '$1$yZOK0Y', '2024-09-19 12:21:02', '2024-12-12 17:08:40', 0, 'OR61', 1);
INSERT INTO `students` VALUES (13, NULL, 3, 1, 109, '崔岚', 21, '$1$3ULHrO$S1xSl1m1/qXMdCI4nnyiw.', 'student', 1, 235, 'All the Navicat Cloud objects are located under different projects. You can share the project to other Navicat Cloud accounts for collaboration.', 'http://192.168.122.171:1314/images/14.jpg', '$1$3ULHrO', '2022-05-18 02:03:01', '2024-12-12 16:35:08', 0, 'mBRyx4614R', 0);
INSERT INTO `students` VALUES (14, NULL, 4, 6, 119, '史睿', 20, '$1$N6jnE5$GEamnAUGWKWK75v3ELKhK/', 'student', 1, 568, 'Navicat Monitor is a safe, simple and agentless remote server monitoring tool that is packed with powerful features to make your monitoring           ', 'http://192.168.122.171:1314/images/15.jpg', '$1$N6jnE5', '2010-08-19 06:10:18', '2024-12-12 16:33:14', 0, '7hXYWGMr4c', 1);
INSERT INTO `students` VALUES (15, NULL, 3, 29, NULL, '余晓明', 17, '$1$NSMKYR$LCg66UKqAjNz6l4gtakhZ.', 'student', 1, 697, 'Success consists of going from failure to failure without loss of enthusiasm. You must be the change you wish to see in the world.', 'http://192.168.122.171:1314/images/16.jpg', '$1$NSMKYR', '2010-12-06 10:10:15', '2024-12-12 16:25:46', 0, 'NVRruKdAuX', 0);
INSERT INTO `students` VALUES (16, NULL, 4, 33, 114, '沈岚', 16, 'QDGZVdMJCH', 'student', 0, 220, 'To successfully establish a new connection to local/remote server - no matter via SSL, SSH or HTTP, set the database login information                ', 'http://192.168.122.171:1314/images/17.jpg', 'Yij3FVSytm', '2019-04-02 14:49:59', '2015-04-12 12:38:03', 0, 'Ct8hKyHk7s', 1);
INSERT INTO `students` VALUES (17, NULL, 5, 4, 116, '余宇宁', 16, 'msqccaaoWR', 'student', 0, 48, 'To successfully establish a new connection to local/remote server - no matter via SSL or SSH, set the database login information in the General tab.', 'http://192.168.122.171:1314/images/18.jpg', 'S8KlUvLILS', '2023-08-27 21:54:36', '2000-07-27 21:29:42', 0, 'OEZ0FdL1zY', 0);
INSERT INTO `students` VALUES (18, NULL, 5, 30, 112, '方睿', 16, 'y69LRMBu8U', 'student', 1, 280, 'You can select any connections, objects or projects, and then select the corresponding buttons on the Information Pane.                               ', 'http://192.168.122.171:1314/images/22.jpg', 'br63Q2LUuk', '2014-03-13 10:34:02', '2011-04-29 12:03:11', 0, 'y3HuXI6qe5', 0);
INSERT INTO `students` VALUES (19, NULL, 1, 1, 106, '安国强', 46, '$1$ZCQhXD$gvpgkp8CVXe0Viyhak4P3.', 'student', 60, 19, 'In a Telnet session, all communications, including username and password, are transmitted in plain-text, allowing anyone to listen-in                 ', 'https://avatars.githubusercontent.com/u/69246582', '$1$ZCQhXD', '2013-08-27 10:57:09', '2024-12-12 16:16:50', 0, 'officia aliqua labore2', 1);
INSERT INTO `students` VALUES (105, NULL, 1, NULL, NULL, NULL, NULL, '$1$ntIj1T$AlAudyLE53Ijtgx8C14BG1', 'student', 1, NULL, NULL, 'http://192.168.122.171:1314/images/21.jpg', '$1$ntIj1T', '2024-12-12 14:12:14', '2024-12-12 14:20:49', 1, 'velit elit ullamco occaecat nisi', 0);
INSERT INTO `students` VALUES (106, NULL, 1, NULL, NULL, 'ttt', 21, '$1$idU7Wo$ZtcoCicQjJWIJGpt7vCNv0', 'student', 1, NULL, '你纯真善良，活泼可爱，对待朋友热情真诚，对老师尊敬有礼貌。学习上坚持不懈，虽然成绩不是最好的，但我知道你从没放弃，因为你知道学习的过程不仅是文化知识积累的过程，更是学会做人并不断自己完善的过程。', 'http://192.168.122.171:1314/images/22.jpg', '$1$idU7Wo', '2024-12-12 14:24:10', '2024-12-13 10:07:44', 0, '1', 0);
INSERT INTO `students` VALUES (111, NULL, 1, NULL, NULL, NULL, NULL, '$1$lxPFac$Q4vLe36GQM.8CIwz.TeB1/', 'student', 1, NULL, NULL, 'http://192.168.122.171:1314', '$1$lxPFac', '2024-12-13 10:05:42', '2024-12-13 10:05:42', 0, '121', 0);

SET FOREIGN_KEY_CHECKS = 1;
