/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50624
Source Host           : localhost:3306
Source Database       : db_01

Target Server Type    : MYSQL
Target Server Version : 50624
File Encoding         : 65001

Date: 2016-03-08 23:05:59
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t10
-- ----------------------------
DROP TABLE IF EXISTS `t10`;
CREATE TABLE `t10` (
  `F01` int(10) NOT NULL AUTO_INCREMENT,
  `F02` varchar(20) NOT NULL COMMENT '用户名',
  `F03` varchar(50) DEFAULT NULL COMMENT '邮箱',
  `F04` varchar(64) NOT NULL COMMENT '密码',
  `F05` enum('FXS','QY') DEFAULT NULL COMMENT '用户类型（企业、分析师）',
  `F06` enum('S','F') DEFAULT NULL COMMENT '是否删除',
  `F07` timestamp NULL DEFAULT NULL COMMENT '时间戳',
  `F08` enum('SC','WJH','HMD','QY') DEFAULT NULL COMMENT '用户状态（删除、未激活、黑名单、启用）',
  PRIMARY KEY (`F01`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='用户信息表';

-- ----------------------------
-- Records of t10
-- ----------------------------
INSERT INTO `t10` VALUES ('2', 'asd2012', '2693491512@qq.com', 'ea506d620623c93c17aa07c1d1ef89cbb15ec9a0', 'QY', 'F', '2016-02-29 00:57:25', 'WJH');
INSERT INTO `t10` VALUES ('3', 'asd2013', '1936855897@qq.com', 'ea506d620623c93c17aa07c1d1ef89cbb15ec9a0', 'FXS', 'F', '2016-02-29 00:58:34', 'WJH');
INSERT INTO `t10` VALUES ('4', 'asd2014', '269349151@qq.com', 'ea506d620623c93c17aa07c1d1ef89cbb15ec9a0', 'FXS', 'F', '2016-03-06 11:59:13', 'WJH');

-- ----------------------------
-- Table structure for t11
-- ----------------------------
DROP TABLE IF EXISTS `t11`;
CREATE TABLE `t11` (
  `F01` int(11) NOT NULL COMMENT '用户ID，参考T10，F01',
  `F02` varchar(40) DEFAULT NULL COMMENT '用户邮箱',
  `F03` varchar(10) DEFAULT NULL COMMENT '激活码（4位）',
  `F04` timestamp NULL DEFAULT NULL COMMENT '时间戳'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户邮箱注册激活码表';

-- ----------------------------
-- Records of t11
-- ----------------------------
INSERT INTO `t11` VALUES ('6', 'www@qq.com', '6559', '2016-02-27 00:52:19');
INSERT INTO `t11` VALUES ('7', '2693491512@qq.com', '6158', '2016-02-27 22:13:00');
INSERT INTO `t11` VALUES ('8', '1936855897@qq.com', '3836', '2016-02-27 22:17:06');
INSERT INTO `t11` VALUES ('9', '1936855897@qq.com', '6082', '2016-02-27 23:30:37');
INSERT INTO `t11` VALUES ('10', '18273149313@qq.com', '1188', '2016-02-27 23:53:43');
INSERT INTO `t11` VALUES ('11', '269349151@qq.com', '1494', '2016-02-28 00:47:23');
INSERT INTO `t11` VALUES ('1', '2693491512@qq.com', '6281', '2016-02-28 01:12:17');
INSERT INTO `t11` VALUES ('2', '', '3349', '2016-02-28 16:06:03');
INSERT INTO `t11` VALUES ('3', '2693491513@qq.com', '1820', '2016-02-28 16:28:40');
INSERT INTO `t11` VALUES ('4', '2693491514@qq.com', '4116', '2016-02-28 16:29:51');
INSERT INTO `t11` VALUES ('5', '2@qq.com', '9310', '2016-02-28 16:30:23');
INSERT INTO `t11` VALUES ('6', '269349152@qq.com', '2654', '2016-02-28 17:01:34');
INSERT INTO `t11` VALUES ('7', '83478@qq.com', '4753', '2016-02-28 17:13:20');
INSERT INTO `t11` VALUES ('8', '8137812@qq.com', '2446', '2016-02-28 17:15:13');
INSERT INTO `t11` VALUES ('9', '33473478@qq.com', '2176', '2016-02-28 17:21:51');
INSERT INTO `t11` VALUES ('2', '2693491512@qq.com', '5634', '2016-02-29 00:57:32');
INSERT INTO `t11` VALUES ('3', '1936855897@qq.com', '4561', '2016-02-29 00:58:44');
INSERT INTO `t11` VALUES ('4', '269349151@qq.com', '5369', '2016-03-06 11:59:15');

-- ----------------------------
-- Table structure for t20
-- ----------------------------
DROP TABLE IF EXISTS `t20`;
CREATE TABLE `t20` (
  `F01` int(11) NOT NULL COMMENT '用户ID，参考T10,F01',
  `F02` varchar(10) DEFAULT NULL COMMENT '真实姓名',
  `F03` enum('BM','NV','NAN') DEFAULT NULL COMMENT '性别',
  `F04` date DEFAULT NULL COMMENT '出生日期',
  `F05` text COMMENT '个人简介',
  `F06` date DEFAULT NULL COMMENT '从业日期',
  `F07` varchar(50) DEFAULT NULL COMMENT '毕业院校',
  `F08` varchar(50) DEFAULT NULL COMMENT '毕业院校',
  `F09` varchar(100) DEFAULT NULL COMMENT '头像链接',
  PRIMARY KEY (`F01`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='分析师-简介';

-- ----------------------------
-- Records of t20
-- ----------------------------
INSERT INTO `t20` VALUES ('3', '廖金龙', 'NAN', '2016-03-25', null, null, '', null, '/IMAGE/1457238660379.png');
INSERT INTO `t20` VALUES ('4', '张三', 'NAN', '2016-01-26', '个人简介\"hello\"\n“world”\n\"Hello World\"\n\'hello world\'\n\"\"\"', '2016-03-02', '湖南省长沙市某某某某学校', '湖南省长沙市某某某某某某某某某某某某某有限公司', '/IMAGE/1457251447527.jpg');

-- ----------------------------
-- Table structure for t30
-- ----------------------------
DROP TABLE IF EXISTS `t30`;
CREATE TABLE `t30` (
  `F01` int(11) NOT NULL COMMENT '用户ID，参考T10,F01',
  `F02` varchar(100) DEFAULT NULL COMMENT '公司名称',
  `F03` text COMMENT '主营业务',
  `F04` text COMMENT '备注说明',
  PRIMARY KEY (`F01`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='企业-资料';

-- ----------------------------
-- Records of t30
-- ----------------------------
INSERT INTO `t30` VALUES ('2', null, null, null);
