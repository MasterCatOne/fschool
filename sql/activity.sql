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

 Date: 13/12/2024 10:37:19
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for activity
-- ----------------------------
DROP TABLE IF EXISTS `activity`;
CREATE TABLE `activity`  (
  `activity_id` bigint NOT NULL AUTO_INCREMENT COMMENT '活动表主键',
  `activity_title` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '活动标题',
  `activity_content` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL COMMENT '活动内容',
  `activity_time` date NULL DEFAULT NULL COMMENT '活动时间',
  `activity_img` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '' COMMENT '活动图片',
  PRIMARY KEY (`activity_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 71 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of activity
-- ----------------------------
INSERT INTO `activity` VALUES (2, 'katominato', 'How we spend our days is, of course, how we spend our lives. Navicat provides a wide range advanced features, such as compelling code                 ', '2025-03-01', 'http://192.168.122.171:1314/images/act2.jpg');
INSERT INTO `activity` VALUES (3, 'pachr', 'To start working with your server in Navicat, you should first establish a connection or several connections using the Connection window.             ', '2025-03-01', 'http://192.168.122.171:1314/images/act3.jpg');
INSERT INTO `activity` VALUES (4, 'heatherric', 'The Main Window consists of several toolbars and panes for you to work on connections, database objects and advanced tools.                           ', '2025-02-15', 'http://192.168.122.171:1314/images/act4.jpg');
INSERT INTO `activity` VALUES (5, 'ycy51', 'It provides strong authentication and secure encrypted communications between two hosts, known as SSH Port Forwarding (Tunneling),   ...                 ', '2025-02-12', '');
INSERT INTO `activity` VALUES (6, 'hxiuying', 'If opportunity doesn’t knock, build a door. There is no way to happiness. Happiness is the way. The first step is as good as half over.', '2025-01-11', 'http://192.168.122.171:1314/images/act6.jpg');
INSERT INTO `activity` VALUES (7, 'cylee', 'To open a query using an external editor, control-click it and select Open with External Editor. You can set the file path of an external             ', '2024-12-16', 'http://192.168.122.171:1314/images/act7.jpg');
INSERT INTO `activity` VALUES (8, 'hendersonshirley00', 'Always keep your eyes open. Keep watching. Because whatever you see can inspire you. It wasn’t raining when Noah built the ark.', '2025-01-30', 'http://192.168.122.171:1314/images/act8.jpg');
INSERT INTO `activity` VALUES (9, 'cara', 'Secure Sockets Layer(SSL) is a protocol for transmitting private documents via the Internet. In other words, Navicat provides the ability             ', '2025-01-03', 'http://192.168.122.171:1314/images/act9.jpg');
INSERT INTO `activity` VALUES (11, 'taniguchisaku', 'Navicat provides powerful tools for working with queries: Query Editor for editing the query text directly, and Query Builder, Find                   ', '2025-01-10', '');
INSERT INTO `activity` VALUES (12, 'wailam1', 'You must be the change you wish to see in the world. Difficult circumstances serve as a textbook of life for people.', '2025-01-13', 'http://192.168.122.171:1314/images/act1.jpg');
INSERT INTO `activity` VALUES (13, 'chang1', 'Navicat is a multi-connections Database Administration tool allowing you to connect to MySQL, Oracle, PostgreSQL, SQLite, SQL Server,                 ', '2025-01-08', 'http://192.168.122.171:1314/images/act5.jpg');

SET FOREIGN_KEY_CHECKS = 1;
