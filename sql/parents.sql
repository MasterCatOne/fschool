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

 Date: 13/12/2024 10:37:55
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for parents
-- ----------------------------
DROP TABLE IF EXISTS `parents`;
CREATE TABLE `parents`  (
  `parent_id` bigint NOT NULL AUTO_INCREMENT COMMENT '家长主键',
  `parent_name` varchar(128) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '姓名',
  `parent_age` int NULL DEFAULT NULL COMMENT '年龄',
  `parent_pwd` varchar(124) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '密码',
  `parent_phone` varchar(15) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '手机号码',
  `role` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT 'parent' COMMENT '角色',
  `parent_sex` tinyint NULL DEFAULT 1 COMMENT '0表示女，1表示男',
  `secret` varchar(12) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '盐，用于个人敏感信息处理',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime NULL DEFAULT NULL COMMENT '跟新时间',
  `is_deleted` tinyint UNSIGNED NULL DEFAULT 0 COMMENT '删除标记（1:不可用 0:可用）',
  `account` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '账号',
  `class_id` bigint NULL DEFAULT NULL COMMENT '班级id',
  PRIMARY KEY (`parent_id`) USING BTREE,
  UNIQUE INDEX `parent_phone`(`parent_phone` ASC) USING BTREE,
  INDEX `parents_ibfk_1`(`class_id` ASC) USING BTREE,
  CONSTRAINT `parents_ibfk_1` FOREIGN KEY (`class_id`) REFERENCES `classes` (`class_id`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 131 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of parents
-- ----------------------------
INSERT INTO `parents` VALUES (106, '尉家明', 66, 'consequat anim Ut nulla elit', '048 7092 2441', 'parent', 1, '$1$t7obqq', NULL, NULL, 0, 'd', NULL);
INSERT INTO `parents` VALUES (108, NULL, NULL, '$1$rvRuOH$SLxkeSxHyqiqkhWyN5pnk/', NULL, 'parent', 1, '$1$rvRuOH', NULL, NULL, 1, '123', NULL);
INSERT INTO `parents` VALUES (109, NULL, NULL, '$1$EksT0k$2fqOTIO/zKufh3TztzT7i0', NULL, 'parent', 1, '$1$EksT0k', NULL, NULL, 1, '', NULL);
INSERT INTO `parents` VALUES (110, NULL, NULL, '$1$SXyLAe$w.PlP/i.c/j.qottSr0Cd0', NULL, 'parent', 1, '$1$SXyLAe', NULL, NULL, 1, '123456', NULL);
INSERT INTO `parents` VALUES (111, '李太白', 1, '$1$wyJsqX$jJpXtugxM7X/XCuLuWJSt.', NULL, 'parent', 0, '$1$wyJsqX', NULL, NULL, 0, '123456', NULL);
INSERT INTO `parents` VALUES (112, NULL, NULL, '$1$QN4Yeu$V6GPLxlULzXEDobPzCwdE/', NULL, 'parent', 1, '$1$QN4Yeu', NULL, NULL, 1, '', NULL);
INSERT INTO `parents` VALUES (113, '33', 33, '$1$phKm4x$Cye2BESnZtp.2ngcwjgwE/', NULL, 'parent', 1, '$1$phKm4x', NULL, NULL, 0, 'officia dolor Duis', NULL);
INSERT INTO `parents` VALUES (114, '1', 22, '$1$1hHBel$Vu0pHk6ped5sobAu74jnM0', NULL, 'parent', 1, '$1$1hHBel', NULL, NULL, 0, 'ullamco laboris cillum', NULL);
INSERT INTO `parents` VALUES (116, NULL, NULL, '$1$4XtXsM$v355/a7A3kCPmF0EFp0PY1', NULL, 'parent', 1, '$1$4XtXsM', NULL, NULL, 1, '1234', NULL);
INSERT INTO `parents` VALUES (117, '李白', 11, '$1$1omLnv$ajm.fTS8lR16Xxbl61eRa.', NULL, 'parent', 1, '$1$1omLnv', NULL, NULL, 0, '12', NULL);
INSERT INTO `parents` VALUES (118, NULL, NULL, '$1$P6u9At$J8RwJtIQlS2pYjd8KAgI7.', NULL, 'parent', 1, '$1$P6u9At', NULL, NULL, 1, '2', NULL);
INSERT INTO `parents` VALUES (119, '李白', 123, '$1$DbnzvT$rchQm0YXIOgE1SmhqzoYC/', NULL, 'parent', 1, '$1$DbnzvT', NULL, NULL, 0, '12345', NULL);
INSERT INTO `parents` VALUES (121, '222', 222, '$1$pWleVK$XmCcqEWhnn8g2Li8MqstQ1', NULL, 'parent', 1, '$1$pWleVK', NULL, NULL, 0, '123123', NULL);
INSERT INTO `parents` VALUES (122, '刘禅', 12, '$1$9ANTWK$Rd82itXZNyWSoBhrFGq9H1', NULL, 'parent', 0, '$1$9ANTWK', NULL, NULL, 0, '333', NULL);
INSERT INTO `parents` VALUES (125, NULL, NULL, '$1$U1WEi7$YwfqE6jbUejDDfm3qD.cb1', NULL, 'parent', 1, '$1$U1WEi7', NULL, NULL, 0, '10', NULL);
INSERT INTO `parents` VALUES (126, '卜静', 7, 'Excepteur incididunt pariatur nisi sunt', '19824270755', 'parent', 1, '$1$5990y0', NULL, NULL, 0, 'in cupidatat laboris magn2a', NULL);
INSERT INTO `parents` VALUES (127, '原奕泽', 17, 'officia', '58131168350', 'parent', 1, '$1$M6cSNd', NULL, NULL, 0, 'dolore', NULL);
INSERT INTO `parents` VALUES (128, '原奕泽', 17, 'officia', '23', 'parent', 1, '$1$mwcxxn', NULL, NULL, 0, '1302', NULL);
INSERT INTO `parents` VALUES (129, NULL, NULL, '$1$0yYSXR$Ws3DXU9K7INvj6FnnZmS/.', NULL, 'parent', 1, '$1$0yYSXR', NULL, NULL, 0, 'J123', NULL);
INSERT INTO `parents` VALUES (130, NULL, NULL, '$1$W2Qn1I$vbp5C2HR2YUyUh5SLyUgk1', NULL, 'parent', 1, '$1$W2Qn1I', NULL, NULL, 0, '1', NULL);

SET FOREIGN_KEY_CHECKS = 1;
