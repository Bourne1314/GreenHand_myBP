/*
 Navicat Premium Data Transfer

 Source Server         : it
 Source Server Type    : MySQL
 Source Server Version : 50721
 Source Host           : localhost:3306
 Source Schema         : greenhand

 Target Server Type    : MySQL
 Target Server Version : 50721
 File Encoding         : 65001

 Date: 19/10/2021 15:04:25
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for green_hand
-- ----------------------------
DROP TABLE IF EXISTS `green_hand`;
CREATE TABLE `green_hand`  (
  `ID` int(25) NOT NULL COMMENT '主键Id',
  `NAME` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '姓名',
  `CITY` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '城市',
  `AGE` int(25) NULL DEFAULT NULL COMMENT '年龄',
  `EDUCATION` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '教育背景',
  `TEL` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '电话',
  `CODE_LANGUAGE` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '最喜欢的变成语言',
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of green_hand
-- ----------------------------
INSERT INTO `green_hand` VALUES (1, '菜1', '连云港', 3, '本科', '18966662222', 'java');
INSERT INTO `green_hand` VALUES (2, '菜2', '上海', 4, '硕士', '18555553333', 'python');
INSERT INTO `green_hand` VALUES (3, '菜3', '北京', 5, '本科', '15466534578', 'javascript');
INSERT INTO `green_hand` VALUES (12, '神秘的菜鸟', '江苏连云港11', 10, '大学本科', '18555554444', 'Go');

SET FOREIGN_KEY_CHECKS = 1;
