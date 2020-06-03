/*
 Navicat Premium Data Transfer

 Source Server         : MySql
 Source Server Type    : MySQL
 Source Server Version : 80016
 Source Host           : localhost:3306
 Source Schema         : zhkt

 Target Server Type    : MySQL
 Target Server Version : 80016
 File Encoding         : 65001

 Date: 03/06/2020 22:49:37
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for sys_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_menu`;
CREATE TABLE `sys_menu`  (
  `menu_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '菜单名称',
  `menu_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL COMMENT '菜单名称',
  `menu_pid` int(11) NOT NULL DEFAULT 0 COMMENT '关联自身id',
  `menu_no` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL COMMENT '第一位,补位.之后每三位代表一个级别菜单编号',
  `menu_url` varchar(11) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL DEFAULT '#' COMMENT '菜单连接',
  `menu_target` int(11) NULL DEFAULT 0 COMMENT '0,本系统.1外联',
  `menu_min_ico` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL COMMENT '菜单图标小',
  `menu_max_ico` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL COMMENT '菜单图标大',
  `menu_show` int(11) NOT NULL DEFAULT 0 COMMENT '0,显示型菜单.1非显示型菜单',
  `menu_order` int(11) NOT NULL DEFAULT 1 COMMENT '菜单排序',
  PRIMARY KEY (`menu_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = COMPACT;

-- ----------------------------
-- Records of sys_menu
-- ----------------------------

-- ----------------------------
-- Table structure for sys_org
-- ----------------------------
DROP TABLE IF EXISTS `sys_org`;
CREATE TABLE `sys_org`  (
  `org_id` int(11) NOT NULL AUTO_INCREMENT,
  `org_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL COMMENT '组织结构名称',
  `org_no` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL COMMENT '组织结构编号,第一位为补位1.每两位代表一级',
  `org_pid` int(11) NOT NULL,
  `org_status` int(11) NOT NULL DEFAULT 0 COMMENT '状态 0正常 1.禁用',
  PRIMARY KEY (`org_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = COMPACT;

-- ----------------------------
-- Records of sys_org
-- ----------------------------

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role`  (
  `role_id` int(11) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL COMMENT '角色名称',
  `role_default` int(11) NOT NULL DEFAULT 0 COMMENT '0,用户自定义.1系统内置的',
  `role_status` int(11) NOT NULL DEFAULT 0 COMMENT '0,有效.1.禁用',
  `role_explain` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `role_cuid` int(11) NULL DEFAULT 0 COMMENT '创建人id',
  `role_cdate` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `role_euid` int(11) NULL DEFAULT 0 COMMENT '最后修改人',
  `role_edate` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`role_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = COMPACT;

-- ----------------------------
-- Records of sys_role
-- ----------------------------

-- ----------------------------
-- Table structure for sys_role_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_menu`;
CREATE TABLE `sys_role_menu`  (
  `srm_id` int(11) NOT NULL AUTO_INCREMENT,
  `role_pid` int(11) NOT NULL COMMENT '关联角色主键',
  `menu_pid` int(11) NOT NULL COMMENT '关联菜单主键',
  PRIMARY KEY (`srm_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = COMPACT;

-- ----------------------------
-- Records of sys_role_menu
-- ----------------------------

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user`  (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL COMMENT '真实姓名',
  `user_phone` varchar(20) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL COMMENT '手机号',
  `user_no` int(11) NOT NULL COMMENT '工号/学号',
  `user_pwd` varchar(32) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `org_pid` int(11) NOT NULL DEFAULT 0 COMMENT '组织结构',
  `role_pid` int(11) NOT NULL DEFAULT 0 COMMENT '角色id',
  `user_status` int(11) NOT NULL DEFAULT 0 COMMENT '0,正常 1,禁用',
  `user_del_flag` int(11) NOT NULL DEFAULT 0 COMMENT '0,正常 1.已删除',
  `user_cuid` int(11) NULL DEFAULT NULL,
  `user_cdate` datetime(0) NULL DEFAULT NULL,
  `user_euid` int(11) NULL DEFAULT NULL,
  `user_edate` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`user_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = COMPACT;

-- ----------------------------
-- Records of sys_user
-- ----------------------------

SET FOREIGN_KEY_CHECKS = 1;
