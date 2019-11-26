/*
Navicat MySQL Data Transfer

<<<<<<< HEAD
Source Server         : study
=======
Source Server         : wcc
>>>>>>> d8eb7c9672d99ac9f762bfc18c50afa4a05444a0
Source Server Version : 50714
Source Host           : localhost:3306
Source Database       : jdbctest

Target Server Type    : MYSQL
Target Server Version : 50714
File Encoding         : 65001

<<<<<<< HEAD
Date: 2019-11-26 18:01:44
=======
Date: 2019-11-25 18:17:50
>>>>>>> d8eb7c9672d99ac9f762bfc18c50afa4a05444a0
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
<<<<<<< HEAD
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;
=======
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
>>>>>>> d8eb7c9672d99ac9f762bfc18c50afa4a05444a0

-- ----------------------------
-- Records of fruit
-- ----------------------------
INSERT INTO `fruit` VALUES ('1', '苹果', '9.50');
INSERT INTO `fruit` VALUES ('2', '香蕉', '6.05');
INSERT INTO `fruit` VALUES ('3', '苹果（进口）', '19.51');
INSERT INTO `fruit` VALUES ('4', '芒果', '10.00');
INSERT INTO `fruit` VALUES ('5', '草莓', '8.30');
INSERT INTO `fruit` VALUES ('6', '榴莲', '29.99');
<<<<<<< HEAD
INSERT INTO `fruit` VALUES ('9', '葡萄', '21.32');
=======
INSERT INTO `fruit` VALUES ('8', '菠萝', '16.00');
>>>>>>> d8eb7c9672d99ac9f762bfc18c50afa4a05444a0
