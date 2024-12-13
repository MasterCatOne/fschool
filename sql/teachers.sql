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

 Date: 13/12/2024 10:38:09
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for teachers
-- ----------------------------
DROP TABLE IF EXISTS `teachers`;
CREATE TABLE `teachers`  (
  `teacher_id` bigint NOT NULL AUTO_INCREMENT COMMENT '教师主键',
  `class_id` bigint NULL DEFAULT NULL COMMENT '班级id',
  `teacher_name` varchar(128) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '姓名',
  `teacher_age` int NULL DEFAULT NULL COMMENT '年龄',
  `teacher_pwd` varchar(124) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '密码',
  `teacher_phone` varchar(15) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '手机号码',
  `role` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT 'teacher' COMMENT '角色',
  `teacher_sex` tinyint NULL DEFAULT 1 COMMENT '0表示女，1表示男',
  `secret` varchar(12) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '盐，用于个人敏感信息处理',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime NULL DEFAULT NULL COMMENT '跟新时间',
  `is_deleted` tinyint UNSIGNED NULL DEFAULT 0 COMMENT '删除标记（1:不可用 0:可用）',
  `gonghao` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '工号',
  PRIMARY KEY (`teacher_id`) USING BTREE,
  UNIQUE INDEX `teacher_phone`(`teacher_phone` ASC) USING BTREE,
  INDEX `teachers_ibfk_1`(`class_id` ASC) USING BTREE,
  CONSTRAINT `teachers_ibfk_1` FOREIGN KEY (`class_id`) REFERENCES `classes` (`class_id`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 37 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of teachers
-- ----------------------------
INSERT INTO `teachers` VALUES (1, 1, '常詩涵', 54, 'yHjxBkdnte', '181-3272-5835', 'teacher', 0, '63D2i2RBOR', '2004-04-14 04:25:35', '2018-06-18 09:41:56', 0, '90469');
INSERT INTO `teachers` VALUES (2, 3, '史岚', 45, '7X8VO7arhw', '755-6637-5986', 'teacher', 1, 'INJxeNTMeJ', '2005-01-17 22:11:05', '2011-01-06 04:47:52', 0, '55784');
INSERT INTO `teachers` VALUES (3, 3, '蒋睿', 40, 'hMpzzAX9h7', '131-7703-9230', 'teacher', 1, 'edOQR6DMKo', '2014-03-11 11:14:38', '2013-03-16 18:24:02', 0, '70344');
INSERT INTO `teachers` VALUES (4, 4, '张宇', 50, '$1$iAi0gV$NMe3QEgLGgKEF2x5ZXELv1', '19352394153', 'teacher', 1, '$1$iAi0gV', NULL, NULL, 0, 'Gzhangyu');
INSERT INTO `teachers` VALUES (5, 3, '杜一诺', 93, '$1$UND5NY$ihgn2N0nNbgZS/BS0FUQX0', '19139348152', 'ea consequat minim', 19, '$1$UND5NY', NULL, NULL, 0, 'mollit in consequat cillum non');
INSERT INTO `teachers` VALUES (6, 1, '养沐宸', 100, '$1$U8h4TZ$w35r3k0/1MenRJi367iGD/', '10784742240', 'aliqua aliquip', 75, '$1$U8h4TZ', NULL, NULL, 0, 'laborum');
INSERT INTO `teachers` VALUES (7, 3, '朱温', 58, '$1$T0uHZk$IzJnOvrsCgTh2mXD3zh7e1', NULL, 'teacher', 1, '$1$T0uHZk', NULL, NULL, 0, 'anim');
INSERT INTO `teachers` VALUES (8, 3, '朱棣', 5, '$1$dJfTGO$07bjnJhTcvn68nK7zBNFW0', NULL, 'teacher', 1, '$1$dJfTGO', NULL, NULL, 0, 'ani2m');
INSERT INTO `teachers` VALUES (9, 3, '贯一诺', 69, 'dolor', '10318158265', 'teacher', 87, '$1$3eyjSD', NULL, NULL, 1, 'id2');
INSERT INTO `teachers` VALUES (10, NULL, NULL, NULL, '$1$8Tjblr$cp9aIPomwBXpsK.RbjDVf.', NULL, 'teacher', 1, '$1$8Tjblr', NULL, NULL, 1, '1');
INSERT INTO `teachers` VALUES (11, 3, '李白', 44, '$1$wJnPbj$xBnMTH3ktkd.G4SmV4eNR.', NULL, 'teacher', 1, '$1$wJnPbj', NULL, NULL, 0, '101');
INSERT INTO `teachers` VALUES (12, 3, NULL, NULL, '$1$trtVzX$xSE0eH6lgyJkB7aNOHzq/1', NULL, 'teacher', 1, '$1$trtVzX', NULL, NULL, 0, '56652');
INSERT INTO `teachers` VALUES (13, 2, NULL, NULL, '$1$GTqKnp$b67arRgnKwF2pnA2Ooa8o1', NULL, 'teacher', 1, '$1$GTqKnp', NULL, NULL, 0, '123123');
INSERT INTO `teachers` VALUES (14, 4, NULL, NULL, '$1$bGjJMN$jSsFpAzx1R/ODWOtnR5hE0', NULL, 'teacher', 1, '$1$bGjJMN', NULL, NULL, 0, '32131');
INSERT INTO `teachers` VALUES (15, 2, NULL, NULL, '$1$hbf76Y$eaGQnDds6fC1GpM6PbDkI.', NULL, 'teacher', 1, '$1$hbf76Y', NULL, NULL, 0, '22222');
INSERT INTO `teachers` VALUES (23, 5, NULL, NULL, '$1$W7biD4$5xcjoutoz9PPUeivAfDNq1', NULL, 'teacher', 1, '$1$W7biD4', NULL, NULL, 0, '1221');
INSERT INTO `teachers` VALUES (26, 1, NULL, NULL, '$1$7r8eRH$v4ZXHk2yH1Tvf19kfY.OV0', NULL, 'teacher', 1, '$1$7r8eRH', NULL, NULL, 0, '111');
INSERT INTO `teachers` VALUES (27, 1, NULL, NULL, '$1$IdExlY$4sPu.6A9t7ARUYRU845pV0', NULL, 'teacher', 1, '$1$IdExlY', NULL, NULL, 1, 'id culpa dolore');
INSERT INTO `teachers` VALUES (28, 2, NULL, NULL, '$1$EWu8aD$87UHzrSMleFvc.PqJHaPD.', NULL, 'teacher', 1, '$1$EWu8aD', NULL, NULL, 1, '1223');
INSERT INTO `teachers` VALUES (29, 2, NULL, NULL, '$1$6qIksX$Ey36w1CfYejL2jFwXCIrh.', NULL, 'teacher', 1, '$1$6qIksX', NULL, NULL, 0, '122');
INSERT INTO `teachers` VALUES (30, NULL, NULL, NULL, '$1$nyT42a$qZW8uV7VGSS/Q2voAu1fj1', NULL, 'teacher', 1, '$1$nyT42a', NULL, NULL, 0, '1');
INSERT INTO `teachers` VALUES (31, 1, '封馥君', 18, 'dolore', '57663957175', 'teacher', 1, '$1$rsuw9H', NULL, NULL, 0, 'esse amet ullamco');
INSERT INTO `teachers` VALUES (33, 1, NULL, NULL, '$1$MMsEdE$rulClGVqBw6CGQWA5JAFo/', NULL, 'teacher', 1, '$1$MMsEdE', NULL, NULL, 0, 'dolore officia et');
INSERT INTO `teachers` VALUES (34, 1, NULL, NULL, '$1$ogZt22$C2VKxcRw8BdZ9kP5.Da0z1', NULL, 'teacher', 1, '$1$ogZt22', NULL, NULL, 0, 'dolore officia e2t');
INSERT INTO `teachers` VALUES (35, NULL, NULL, NULL, '$1$jQew1Y$6/gf.I/CztX0Uh5ljYAni0', NULL, 'teacher', 1, '$1$jQew1Y', NULL, NULL, 0, 'T123');
INSERT INTO `teachers` VALUES (36, NULL, NULL, NULL, '$1$M7CCFx$HpHxAeznpg3pDHfuQNHTF/', NULL, 'teacher', 1, '$1$M7CCFx', NULL, NULL, 0, '123');

SET FOREIGN_KEY_CHECKS = 1;
