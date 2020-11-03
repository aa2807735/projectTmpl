/*
 Navicat Premium Data Transfer

 Source Server         : mysql8.0
 Source Server Type    : MySQL
 Source Server Version : 80012
 Source Host           : localhost:3306
 Source Schema         : tmpl

 Target Server Type    : MySQL
 Target Server Version : 80012
 File Encoding         : 65001

 Date: 03/11/2020 10:22:50
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for auth_user
-- ----------------------------
DROP TABLE IF EXISTS `auth_user`;
CREATE TABLE `auth_user`  (
  `user_id` bigint(11) NOT NULL COMMENT '用户ID',
  `user_name` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '用户名称',
  `user_password` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '用户密码',
  `create_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `create_id` bigint(11) NOT NULL COMMENT '创建人',
  `update_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '修改时间',
  `update_id` bigint(11) NOT NULL COMMENT '修改人',
  PRIMARY KEY (`user_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin COMMENT = '用户表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for sys_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_menu`;
CREATE TABLE `sys_menu`  (
  `menu_id` int(11) NOT NULL COMMENT '菜单ID',
  `menu_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '菜单名称',
  `menu_cmnt` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '菜单备注',
  `menu_prime` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT 'common' COMMENT '菜单权限',
  `parent_id` int(11) NOT NULL DEFAULT 0 COMMENT '父亲节点',
  `menu_level` int(10) NULL DEFAULT NULL COMMENT '菜单层级',
  `create_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `create_id` bigint(11) NOT NULL COMMENT '创建人',
  `update_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '修改时间',
  `update_id` bigint(11) NOT NULL COMMENT '修改人',
  PRIMARY KEY (`menu_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin COMMENT = '菜单表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_menu
-- ----------------------------
INSERT INTO `sys_menu` VALUES (1, '主页', '前台主页', 'comon', 0, 1, '2020-11-03 09:51:20', 1, '2020-11-03 09:51:20', 1);

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role`  (
  `role_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '角色ID',
  `role_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '角色名称',
  `create_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `create_id` bigint(11) NOT NULL COMMENT '创建人',
  `update_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '修改时间',
  `update_id` bigint(11) NOT NULL COMMENT '修改人',
  PRIMARY KEY (`role_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin COMMENT = '角色表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for sys_role_menu_rel
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_menu_rel`;
CREATE TABLE `sys_role_menu_rel`  (
  `role_id` bigint(20) NOT NULL COMMENT '角色id',
  `menu_id` int(11) NOT NULL COMMENT '菜单id',
  `create_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `create_id` bigint(11) NOT NULL COMMENT '创建人',
  `update_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '修改时间',
  `update_id` bigint(11) NOT NULL COMMENT '修改人',
  PRIMARY KEY (`role_id`, `menu_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin COMMENT = '角色菜单关系表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for sys_role_user_rel
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_user_rel`;
CREATE TABLE `sys_role_user_rel`  (
  `role_id` int(11) NOT NULL COMMENT '角色id',
  `user_id` int(11) NOT NULL COMMENT '用户id',
  `create_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `create_id` bigint(11) NOT NULL COMMENT '创建人',
  `update_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '修改时间',
  `update_id` bigint(11) NOT NULL COMMENT '修改人',
  PRIMARY KEY (`role_id`, `user_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin COMMENT = '角色用户关系表' ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
