/*
 Navicat Premium Data Transfer

 Source Server         : 192.168.10.51
 Source Server Type    : MySQL
 Source Server Version : 50730
 Source Host           : 192.168.10.51:3306
 Source Schema         : iotplatform

 Target Server Type    : MySQL
 Target Server Version : 50730
 File Encoding         : 65001

 Date: 29/05/2021 17:40:58
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for project
-- ----------------------------
DROP TABLE IF EXISTS `project`;
CREATE TABLE `project`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `project_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `uni_name`(`project_name`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 24 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of project
-- ----------------------------
INSERT INTO `project` VALUES (19, '123');
INSERT INTO `project` VALUES (20, '12312');
INSERT INTO `project` VALUES (21, 'cesss');
INSERT INTO `project` VALUES (22, 'sdfsf');
INSERT INTO `project` VALUES (1, '测试');
INSERT INTO `project` VALUES (4, '测试4');
INSERT INTO `project` VALUES (23, '胜多负少');
INSERT INTO `project` VALUES (2, '项目2');
INSERT INTO `project` VALUES (3, '项目3');

-- ----------------------------
-- Table structure for project_item_sub
-- ----------------------------
DROP TABLE IF EXISTS `project_item_sub`;
CREATE TABLE `project_item_sub`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `project_id` int(11) NULL DEFAULT NULL COMMENT '项目id',
  `project_item_id` int(11) NULL DEFAULT NULL,
  `version` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '平台',
  `drive_date` datetime(0) NULL DEFAULT NULL,
  `url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `drive_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `platform` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `gmt_create` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 24 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of project_item_sub
-- ----------------------------
INSERT INTO `project_item_sub` VALUES (23, 22, NULL, '1.0.1', '2021-05-04 04:00:00', '\\upload\\20210529\\3ab1640520fc4aad888432d60d388e58.zip', 'Graphic', 'win7', NULL);

SET FOREIGN_KEY_CHECKS = 1;
