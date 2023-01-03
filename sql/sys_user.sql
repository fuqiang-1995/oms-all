/*
 Navicat Premium Data Transfer

 Source Server         : 127.0.0.1
 Source Server Type    : MySQL
 Source Server Version : 80022
 Source Host           : 127.0.0.1:3306
 Source Schema         : omsndb

 Target Server Type    : MySQL
 Target Server Version : 80022
 File Encoding         : 65001

 Date: 04/01/2023 01:22:24
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `name` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '用户名',
  `name_zh` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '姓名（中文）',
  `password` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '密码',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE KEY `name` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
BEGIN;
INSERT INTO `sys_user` (`id`, `name`, `name_zh`, `password`) VALUES (1, 'fuqiang', '付强', '123');
INSERT INTO `sys_user` (`id`, `name`, `name_zh`, `password`) VALUES (2, 'zhangsan', NULL, '827ccb0eea8a706c4c34a16891f84e7b');
INSERT INTO `sys_user` (`id`, `name`, `name_zh`, `password`) VALUES (5, 'zhangsan1', '张三', '827ccb0eea8a706c4c34a16891f84e7b');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
