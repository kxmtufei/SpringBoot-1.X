/*
Navicat MySQL Data Transfer

Source Server         : study
Source Server Version : 50714
Source Host           : localhost:3306
Source Database       : jdbctest

Target Server Type    : MYSQL
Target Server Version : 50714
File Encoding         : 65001

Date: 2019-11-28 18:03:25
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_car
-- ----------------------------
DROP TABLE IF EXISTS `t_car`;
CREATE TABLE `t_car` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `bid` int(11) DEFAULT NULL,
  `cname` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_car
-- ----------------------------
INSERT INTO `t_car` VALUES ('1', '1', '迈巴赫62S');
INSERT INTO `t_car` VALUES ('2', '2', '沃尔沃S80');
INSERT INTO `t_car` VALUES ('3', '4', '悍马H2');
INSERT INTO `t_car` VALUES ('4', '8', '蔚来EP9');
INSERT INTO `t_car` VALUES ('5', '7', '劳斯莱斯幻影');
INSERT INTO `t_car` VALUES ('6', '3', '法拉第毒药');
