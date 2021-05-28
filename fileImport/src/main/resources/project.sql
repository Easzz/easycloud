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

 Date: 28/05/2021 17:08:48
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
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of project
-- ----------------------------
INSERT INTO `project` VALUES (1, '测试');

-- ----------------------------
-- Table structure for project_item
-- ----------------------------
DROP TABLE IF EXISTS `project_item`;
CREATE TABLE `project_item`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `project_id` int(11) NULL DEFAULT NULL COMMENT '项目id',
  `drive_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '驱动名称',
  `platform` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '平台',
  `gmt_create` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of project_item
-- ----------------------------
INSERT INTO `project_item` VALUES (1, 1, '声卡', 'win10', NULL);
INSERT INTO `project_item` VALUES (2, 1, '显卡', 'win10', NULL);
INSERT INTO `project_item` VALUES (3, 1, '声卡', 'win7', NULL);
INSERT INTO `project_item` VALUES (4, 1, '显卡', 'win7', NULL);

-- ----------------------------
-- Table structure for project_item_sub
-- ----------------------------
DROP TABLE IF EXISTS `project_item_sub`;
CREATE TABLE `project_item_sub`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `project_id` int(11) NULL DEFAULT NULL COMMENT '项目id',
  `project_item_id` int(11) NULL DEFAULT NULL,
  `version` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '平台',
  `gmt_create` datetime(0) NULL DEFAULT NULL,
  `drive_date` datetime(0) NULL DEFAULT NULL,
  `url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `drive_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `platform` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of project_item_sub
-- ----------------------------
INSERT INTO `project_item_sub` VALUES (1, 1, 1, '1.0', NULL, '2021-05-28 14:19:30', 'aa.exe', '声卡', 'win10');
INSERT INTO `project_item_sub` VALUES (2, 1, 3, '1.1', NULL, '2021-05-06 14:23:05', 'bb.exe', '声卡', 'win7');

SET FOREIGN_KEY_CHECKS = 1;
