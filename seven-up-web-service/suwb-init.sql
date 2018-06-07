-- --------------------------------------------------------
-- 主机:                           127.0.0.1
-- 服务器版本:                        5.7.18-log - MySQL Community Server (GPL)
-- 服务器操作系统:                      Win64
-- HeidiSQL 版本:                  9.4.0.5174
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- 导出数据库结构
DROP DATABASE IF EXISTS `suwb`;
CREATE DATABASE IF NOT EXISTS `suwb` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_bin */;
USE `suwb`;

-- 导出  表 sys_log 结构
DROP TABLE IF EXISTS `sys_log`;
CREATE TABLE IF NOT EXISTS `sys_log` (
  `action_id` varchar(32) NOT NULL COMMENT '操作id',
  `user_id` int(32) DEFAULT NULL COMMENT '用户id',
  `action_date` datetime DEFAULT NULL COMMENT '操作日期',
  `action_ip` varchar(20) DEFAULT NULL COMMENT '操作ip',
  `action_module` varchar(20) DEFAULT NULL COMMENT '操作模块',
  `action_type` tinyint(4) DEFAULT NULL COMMENT '操作类型',
  `action_url` varchar(100) DEFAULT NULL COMMENT '操作url',
  `action_params` varchar(500) DEFAULT NULL COMMENT '操作参数',
  PRIMARY KEY (`action_id`),
  KEY `ind_t_sys_log` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统操作日志表';

-- 导出  表 sys_resource 结构
DROP TABLE IF EXISTS `sys_resource`;
CREATE TABLE IF NOT EXISTS `sys_resource` (
  `res_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '资源ID',
  `res_name` varchar(80) NOT NULL COMMENT '资源名称',
  `res_parent_id` int(11) DEFAULT NULL,
  `res_url` varchar(100) DEFAULT NULL COMMENT '资源url',
  `res_target` varchar(10) DEFAULT NULL COMMENT '资源目标',
  `res_image` varchar(20) DEFAULT NULL COMMENT '资源图片',
  `res_type` tinyint(4) DEFAULT NULL COMMENT '资源类型',
  `res_desc` varchar(100) DEFAULT NULL COMMENT '资源描述',
  `res_order` int(11) DEFAULT NULL COMMENT '资源顺序',
  PRIMARY KEY (`res_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统资源表';

-- 导出  表 sys_role 结构
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE IF NOT EXISTS `sys_role` (
  `role_id` varchar(32) NOT NULL COMMENT '角色id',
  `role_name` varchar(40) NOT NULL COMMENT '角色名称',
  `role_desc` varchar(100) DEFAULT NULL COMMENT '角色描述',
  `role_order` int(11) DEFAULT NULL COMMENT '角色显示顺序',
  `created_date` datetime DEFAULT NULL COMMENT '角色创建时间',
  `created_by` varchar(10) DEFAULT NULL COMMENT '角色创建人',
  `updated_date` datetime DEFAULT NULL COMMENT '角色更新时间',
  `updated_by` varchar(10) DEFAULT NULL COMMENT '角色更新人',
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统角色表';

-- 导出  表 sys_role_resource 结构
DROP TABLE IF EXISTS `sys_role_resource`;
CREATE TABLE IF NOT EXISTS `sys_role_resource` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role_id` int(11) DEFAULT NULL COMMENT '角色id',
  `resource_id` int(11) DEFAULT NULL COMMENT '资源id',
  PRIMARY KEY (`id`),
  KEY `ind_t_sys_rolefunction` (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统角色资源表';

-- 导出  表 sys_user 结构
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE IF NOT EXISTS `sys_user` (
  `user_id` varchar(32) NOT NULL,
  `user_name` varchar(30) NOT NULL,
  `user_password` varchar(40) NOT NULL,
  `random_code` varchar(6) DEFAULT NULL,
  `user_status` int(11) DEFAULT NULL,
  `user_mobile` varchar(11) DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `created_by` varchar(20) DEFAULT NULL,
  `updated_date` datetime DEFAULT NULL,
  `updated_by` varchar(10) DEFAULT NULL,
  `role_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`user_id`),
  KEY `idx_t_sys_user_2` (`user_name`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统用户表';

-- 导出  表 sys_user_login 结构
DROP TABLE IF EXISTS `sys_user_login`;
CREATE TABLE IF NOT EXISTS `sys_user_login` (
  `id` varchar(32) NOT NULL COMMENT '记录id',
  `user_id` int(11) DEFAULT NULL COMMENT '用户id',
  `login_date` datetime DEFAULT NULL COMMENT '登录日期',
  `login_ip` varchar(20) DEFAULT NULL COMMENT '登录ip',
  `login_terminal` varchar(20) DEFAULT NULL COMMENT '登录终端',
  `login_browserType` varchar(40) DEFAULT NULL COMMENT '浏览器类型',
  PRIMARY KEY (`id`),
  KEY `idx_t_sys_userlogin` (`user_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统登录记录表';

-- 导出  表 sys_user_role 结构
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE IF NOT EXISTS `sys_user_role` (
  `id` varchar(32) COLLATE utf8_bin NOT NULL COMMENT 'id',
  `user_id` varchar(32) COLLATE utf8_bin DEFAULT NULL COMMENT '用户id',
  `role_id` varchar(32) COLLATE utf8_bin DEFAULT NULL COMMENT '角色id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='用户角色表\r\n';

