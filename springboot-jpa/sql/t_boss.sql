/*
Navicat MySQL Data Transfer

Source Server         : study
Source Server Version : 50714
Source Host           : localhost:3306
Source Database       : jdbctest

Target Server Type    : MYSQL
Target Server Version : 50714
File Encoding         : 65001

Date: 2019-11-27 18:22:56
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_boss
-- ----------------------------
DROP TABLE IF EXISTS `t_boss`;
CREATE TABLE `t_boss` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `assets` decimal(8,2) DEFAULT NULL,
  `brand` varchar(30) NOT NULL,
  `name` varchar(30) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_l6eehw4jnjrtiowixmuavweh` (`brand`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_boss
-- ----------------------------
INSERT INTO `t_boss` VALUES ('1', '2755.46', '阿里巴巴', '马云');
INSERT INTO `t_boss` VALUES ('2', '2632.23', '腾讯', '马化腾');
INSERT INTO `t_boss` VALUES ('3', '1954.00', '恒大', '许家印');
INSERT INTO `t_boss` VALUES ('4', '386.70', '京东', '刘强东');
INSERT INTO `t_boss` VALUES ('7', '854.34', '万达', '王健林');
INSERT INTO `t_boss` VALUES ('8', '1434.34', '小米', '雷军');
INSERT INTO `t_boss` VALUES ('9', '342.00', '八马茶业', '欧八马');
INSERT INTO `t_boss` VALUES ('10', '342.00', '富士康', '郭台铭');
INSERT INTO `t_boss` VALUES ('11', '2012.33', '大润发', '陈发树');
