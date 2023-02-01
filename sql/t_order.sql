/*
Navicat MySQL Data Transfer

Source Server         : 192.168.178.101
Source Server Version : 80023
Source Host           : 192.168.178.101:3306
Source Database       : demo_ds_0

Target Server Type    : MYSQL
Target Server Version : 80023
File Encoding         : 65001

Date: 2023-01-31 10:32:07
*/



DROP TABLE IF EXISTS `t_order_0`;
CREATE TABLE `t_order_0` (
  `id` varchar(64) NOT NULL COMMENT '主键',
  `order_id` bigint NOT NULL,
  `user_id` int NOT NULL,
  `status` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;


DROP TABLE IF EXISTS `t_order_1`;
CREATE TABLE `t_order_1` (
  `id` varchar(64) NOT NULL COMMENT '主键',
  `order_id` bigint NOT NULL,
  `user_id` int NOT NULL,
  `status` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

DROP TABLE IF EXISTS `t_order_2`;
CREATE TABLE `t_order_2` (
  `id` varchar(64) NOT NULL COMMENT '主键',
  `order_id` bigint NOT NULL,
  `user_id` int NOT NULL,
  `status` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

DROP TABLE IF EXISTS `t_order_3`;
CREATE TABLE `t_order_3` (
  `id` varchar(64) NOT NULL COMMENT '主键',
  `order_id` bigint NOT NULL,
  `user_id` int NOT NULL,
  `status` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

