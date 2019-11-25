/*
Navicat MySQL Data Transfer

Source Server         : wcc
Source Server Version : 50714
Source Host           : localhost:3306
Source Database       : jdbctest

Target Server Type    : MYSQL
Target Server Version : 50714
File Encoding         : 65001

Date: 2019-11-25 18:17:50
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for fruit
-- ----------------------------
DROP TABLE IF EXISTS `fruit`;
CREATE TABLE `fruit` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `name` varchar(30) DEFAULT NULL COMMENT '名称',
  `price` decimal(10,2) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `uq_name` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of fruit
-- ----------------------------
INSERT INTO `fruit` VALUES ('1', '苹果', '9.50');
INSERT INTO `fruit` VALUES ('2', '香蕉', '6.05');
INSERT INTO `fruit` VALUES ('3', '苹果（进口）', '19.51');
INSERT INTO `fruit` VALUES ('4', '芒果', '10.00');
INSERT INTO `fruit` VALUES ('5', '草莓', '8.30');
INSERT INTO `fruit` VALUES ('6', '榴莲', '29.99');
INSERT INTO `fruit` VALUES ('8', '菠萝', '16.00');
