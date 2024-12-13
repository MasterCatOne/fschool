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

 Date: 13/12/2024 10:37:43
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for managers
-- ----------------------------
DROP TABLE IF EXISTS `managers`;
CREATE TABLE `managers`  (
  `manager_id` bigint NOT NULL AUTO_INCREMENT COMMENT '管理员主键',
  `manager_name` varchar(128) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '姓名',
  `manager_pwd` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '密码',
  `role` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT 'admin' COMMENT '角色',
  `secret` varchar(12) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '盐，用于个人敏感信息处理',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime NULL DEFAULT NULL COMMENT '跟新时间',
  `is_deleted` tinyint UNSIGNED NULL DEFAULT 0 COMMENT '删除标记（1:不可用 0:可用）',
  `account` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '账号',
  PRIMARY KEY (`manager_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 15 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of managers
-- ----------------------------
INSERT INTO `managers` VALUES (3, 'lirui', '$1$V3F4yC$WjT2T0ntrN1o9x0wb045E/', 'amdin', '$1$V3F4yC', NULL, NULL, 0, 'ADlirui');
INSERT INTO `managers` VALUES (4, '1', '$1$wII7js$UpMC5248n7DtAtMhpmrU8/', 'manager', '$1$wII7js', NULL, NULL, 1, '1');
INSERT INTO `managers` VALUES (5, '酒乙萍', '$1$kffnL1$FlUDG0nDxpxMYB.1n6s.P0', 'irure adipisicing minim consectetur', '$1$kffnL1', NULL, NULL, 0, 'sint deserunt');
INSERT INTO `managers` VALUES (6, '管宇泽', '$1$3zuCKd$bFIsELJ57xEfPpwUT/DzY0', 'tempor', '$1$3zuCKd', NULL, NULL, 0, 'in deserunt eiusmod fugiat voluptate');
INSERT INTO `managers` VALUES (7, '', '$1$3wymLd$uuPovsI5rFqbslArvhQU2.', '', '$1$3wymLd', NULL, NULL, 1, '');
INSERT INTO `managers` VALUES (8, '11', '$1$2D8BVN$ouvFuEfq.VD9MDKd0XFw40', 'admin', '$1$2D8BVN', NULL, NULL, 0, '11');
INSERT INTO `managers` VALUES (9, '穰一全', '$1$KT5Zmo$Yo96S9L5RWP.LjwqozoGR/', 'labore Lorem aute', '$1$KT5Zmo', NULL, NULL, 0, 'Duis id');
INSERT INTO `managers` VALUES (10, '蔚呈轩', '$1$0Bse43$4eH0vBRlajcGXdAT0W62t.', 'ut elit consequat aliqua non', '$1$0Bse43', NULL, NULL, 1, 'ut');
INSERT INTO `managers` VALUES (11, '穰一', '$1$c06gMe$zgXHly/Nx26q/MsqfuqxJ1', 'admin', '$1$c06gMe', NULL, NULL, 0, 'Duis id11');
INSERT INTO `managers` VALUES (12, '李瑞', '$1$uLv2AE$caXAjeOSsO.Gage1Fggmg.', 'admin', '$1$uLv2AE', NULL, NULL, 0, '22');
INSERT INTO `managers` VALUES (13, '1', '$1$AgkiHg$nsO3JIG8lOxIh4w5CQISY1', 'admin', '$1$AgkiHg', NULL, NULL, 1, '1');
INSERT INTO `managers` VALUES (14, '李白', '$1$T76lGp$KVlmYkt0EjYv04ligpSTT1', 'admin', '$1$T76lGp', NULL, NULL, 0, '123456');

SET FOREIGN_KEY_CHECKS = 1;
