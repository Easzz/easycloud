/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 80025
 Source Host           : localhost:3306
 Source Schema         : drive

 Target Server Type    : MySQL
 Target Server Version : 80025
 File Encoding         : 65001

 Date: 01/06/2021 17:16:24
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for project
-- ----------------------------
DROP TABLE IF EXISTS `project`;
CREATE TABLE `project`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `project_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `gmt_create` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `uni_name`(`project_name`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of project
-- ----------------------------
INSERT INTO `project` VALUES (1, '123', NULL);
INSERT INTO `project` VALUES (2, 'Admin', NULL);
INSERT INTO `project` VALUES (3, 'BadsfF', NULL);
INSERT INTO `project` VALUES (4, '1饿1', '2021-06-01 09:13:45');

-- ----------------------------
-- Table structure for project_item_sub
-- ----------------------------
DROP TABLE IF EXISTS `project_item_sub`;
CREATE TABLE `project_item_sub`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `project_id` int(0) NULL DEFAULT NULL COMMENT '项目id',
  `platform` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '平台',
  `drive_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '驱动名',
  `manufacturer` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '厂商(芯片类型)',
  `version` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '版本',
  `drive_date` date NOT NULL COMMENT '日期',
  `url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '地址',
  `description` varchar(1024) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '说明',
  `gmt_create` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `uni_data`(`project_id`, `platform`, `drive_name`, `manufacturer`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 29 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of project_item_sub
-- ----------------------------
INSERT INTO `project_item_sub` VALUES (23, 22, 'win7', 'Graphic', '1', '1.0.1', '2021-05-04', '\\upload\\20210529\\3ab1640520fc4aad888432d60d388e58.zip', NULL, NULL);
INSERT INTO `project_item_sub` VALUES (24, 1, 'win10', 'LAN', '1', '123', '2021-06-02', '\\sdf/12.xt', NULL, NULL);
INSERT INTO `project_item_sub` VALUES (25, 3, 'win7', 'LAN', 'test1', '1', '2021-06-29', '\\ad/132.tx', NULL, NULL);
INSERT INTO `project_item_sub` VALUES (26, 3, 'win10', 'LAN', '123f2', '1.2', '2021-06-25', '\\sdoipf\\1.ext', '23山东省地方时代峰峻考虑房价为联发科为解放路口文件', '2021-06-01 08:36:36');
INSERT INTO `project_item_sub` VALUES (27, 3, 'win10', 'LAN', 'test', '1', '2021-06-15', '\\234', '23', '2021-06-01 08:43:55');
INSERT INTO `project_item_sub` VALUES (28, 3, 'win7', 'Graphic', 'aaa', '2', '2021-05-31', '\\234', '123', '2021-06-01 08:53:53');
INSERT INTO `project_item_sub` VALUES (29, 3, 'win10', 'Audio', '12', '12', '2021-06-15', '23', '23', '2021-06-01 14:50:12');
INSERT INTO `project_item_sub` VALUES (30, 3, 'win10', 'LAN', '12', '123', '2021-06-23', '123', '123', '2021-06-01 14:50:21');
INSERT INTO `project_item_sub` VALUES (31, 3, 'win7', 'Bluetooth', '12', '123', '2021-06-15', '123', '123', '2021-06-01 14:51:40');

SET FOREIGN_KEY_CHECKS = 1;
