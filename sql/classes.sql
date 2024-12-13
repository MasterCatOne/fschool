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

 Date: 13/12/2024 10:37:26
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for classes
-- ----------------------------
DROP TABLE IF EXISTS `classes`;
CREATE TABLE `classes`  (
  `class_id` bigint NOT NULL AUTO_INCREMENT COMMENT '班级id',
  `class_name` varchar(128) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '班级昵称',
  `student_count` int NULL DEFAULT NULL COMMENT '班级人数',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime NULL DEFAULT NULL COMMENT '跟新时间',
  `is_deleted` tinyint UNSIGNED NULL DEFAULT 0 COMMENT '删除标记（1:不可用 0:可用）',
  PRIMARY KEY (`class_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of classes
-- ----------------------------
INSERT INTO `classes` VALUES (1, '一班', 0, '2021-01-16 06:16:48', '2015-05-24 23:51:28', 0);
INSERT INTO `classes` VALUES (2, '二班', 0, '2011-07-24 05:51:41', '2010-03-14 18:11:05', 0);
INSERT INTO `classes` VALUES (3, '吴班', 7, '2018-12-12 10:04:43', '2024-12-11 16:45:20', 0);
INSERT INTO `classes` VALUES (4, '四班', 36, '2024-12-11 16:43:21', '2024-12-11 16:43:56', 0);
INSERT INTO `classes` VALUES (5, '吉治文', 13, '2024-12-12 10:31:00', '2024-12-12 10:31:00', 0);

SET FOREIGN_KEY_CHECKS = 1;
