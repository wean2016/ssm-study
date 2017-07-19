/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50617
Source Host           : localhost:3306
Source Database       : ssm

Target Server Type    : MYSQL
Target Server Version : 50617
File Encoding         : 65001

Date: 2017-07-19 19:42:53
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `studentName` varchar(20) DEFAULT NULL,
  `studentGender` int(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES ('1', 'lalalala', '0');
INSERT INTO `student` VALUES ('4', 'wean2', '0');
INSERT INTO `student` VALUES ('5', 'wean2', '0');
INSERT INTO `student` VALUES ('6', 'wean2', '0');
INSERT INTO `student` VALUES ('7', 'weasdasda2', '0');
