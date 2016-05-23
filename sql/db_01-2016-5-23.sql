/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50624
Source Host           : localhost:3306
Source Database       : db_01

Target Server Type    : MYSQL
Target Server Version : 50624
File Encoding         : 65001

Date: 2016-05-23 23:47:09
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for h10
-- ----------------------------
DROP TABLE IF EXISTS `h10`;
CREATE TABLE `h10` (
  `F01` varchar(40) NOT NULL,
  `F02` varchar(40) DEFAULT NULL,
  `F03` varchar(200) DEFAULT NULL,
  `F04` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`F01`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of h10
-- ----------------------------
INSERT INTO `h10` VALUES ('FXS.ANALYST_LIST_SIZE', '分析师市场界面每页显示的分析师信息条数', '', '10');
INSERT INTO `h10` VALUES ('FXS.BUSINESS_HISTORY_MAXSIZE', '工作经历最长条数', '', '10');
INSERT INTO `h10` VALUES ('FXS.WORK_EXPERIENCE_PAGE_SIZE', '工作经历每页条数', '', '5');
INSERT INTO `h10` VALUES ('LETTER.PROJECT_NOPASS', '项目审核不通过', '', '尊敬的用户您好，您于${date}发布的项目【${title}】没有通过审核，具体原因为:${reason}');
INSERT INTO `h10` VALUES ('LETTER.PROJECT_PASS', '项目审核通过', '', '尊敬的用户您好，您于${date}发布的项目【${title}】已审核通过。');
INSERT INTO `h10` VALUES ('LETTER.REGISTER', '注册', '', '尊敬的用户${name}，欢迎注册我们网站.');
INSERT INTO `h10` VALUES ('PAGGING.PAGE_BID_SIZE', '项目页面分页展示投标情况的每页投标条数', '', '5');
INSERT INTO `h10` VALUES ('PAGGING.PAGE_FXS_PROJECT_SIZE', '分析师用户中心项目类表页面每页项目条数', '', '5');
INSERT INTO `h10` VALUES ('PAGGING.PAGE_LETTER_SIZE', '用户中心站内信每页项目条数', '', '10');
INSERT INTO `h10` VALUES ('SYSTEM.FILE_UPLOAD_PATH', '文件上传路径', '', 'C:\\Users\\Administrator/ljl-project-file');
INSERT INTO `h10` VALUES ('SYSTEM.SITENAME', '网站名称', '', '数据分析师中介平台');
INSERT INTO `h10` VALUES ('SYSTEM.VERIFYCODE_LENGTH', '验证码长度', '', '4');
INSERT INTO `h10` VALUES ('URL.FXS_PERSONAL_ITEM', '分析师个人主页展示页面', '', 'more/analyst/personal.jsp');
INSERT INTO `h10` VALUES ('URL.VARIABLE', '系统常量配置页面', '', '/more/system.jsp');
INSERT INTO `h10` VALUES ('URL.VARIABLE_UPDATE', '系统常量修改URL', '', '/more/system/variableUpdate.jsp');

-- ----------------------------
-- Table structure for h20
-- ----------------------------
DROP TABLE IF EXISTS `h20`;
CREATE TABLE `h20` (
  `F01` int(11) NOT NULL AUTO_INCREMENT,
  `F02` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`F01`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of h20
-- ----------------------------
INSERT INTO `h20` VALUES ('1', '超级管理员');
INSERT INTO `h20` VALUES ('3', '用户管理组');
INSERT INTO `h20` VALUES ('4', '宣传管理组');

-- ----------------------------
-- Table structure for h21
-- ----------------------------
DROP TABLE IF EXISTS `h21`;
CREATE TABLE `h21` (
  `F01` int(11) NOT NULL AUTO_INCREMENT,
  `F02` int(11) DEFAULT NULL,
  `F03` varchar(30) DEFAULT NULL,
  `F04` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`F01`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of h21
-- ----------------------------
INSERT INTO `h21` VALUES ('1', '1', 'admin', '7c4a8d09ca3762af61e59520943dc26494f8941b');
INSERT INTO `h21` VALUES ('3', '3', 'user', 'ea506d620623c93c17aa07c1d1ef89cbb15ec9a0');

-- ----------------------------
-- Table structure for h22
-- ----------------------------
DROP TABLE IF EXISTS `h22`;
CREATE TABLE `h22` (
  `F01` int(11) NOT NULL AUTO_INCREMENT,
  `F02` varchar(80) DEFAULT NULL,
  PRIMARY KEY (`F01`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of h22
-- ----------------------------
INSERT INTO `h22` VALUES ('7', '项目管理');
INSERT INTO `h22` VALUES ('8', '项目审核');
INSERT INTO `h22` VALUES ('9', '项目发布或审核不通过');
INSERT INTO `h22` VALUES ('10', '发送站内信');
INSERT INTO `h22` VALUES ('11', '常量配置查看');
INSERT INTO `h22` VALUES ('12', '常量配置修改');
INSERT INTO `h22` VALUES ('13', '用户管理');
INSERT INTO `h22` VALUES ('14', '权限配置');
INSERT INTO `h22` VALUES ('15', '添加管理员用户组');
INSERT INTO `h22` VALUES ('16', '添加管理员');
INSERT INTO `h22` VALUES ('17', '添加广告');

-- ----------------------------
-- Table structure for h23
-- ----------------------------
DROP TABLE IF EXISTS `h23`;
CREATE TABLE `h23` (
  `F01` int(11) NOT NULL AUTO_INCREMENT,
  `F02` int(11) DEFAULT NULL,
  `F03` int(11) DEFAULT NULL,
  `F04` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`F01`)
) ENGINE=InnoDB AUTO_INCREMENT=51 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of h23
-- ----------------------------
INSERT INTO `h23` VALUES ('37', '1', '8', '2016-05-23 02:50:38');
INSERT INTO `h23` VALUES ('38', '1', '9', '2016-05-23 02:50:38');
INSERT INTO `h23` VALUES ('39', '1', '10', '2016-05-23 02:50:38');
INSERT INTO `h23` VALUES ('40', '1', '11', '2016-05-23 02:50:38');
INSERT INTO `h23` VALUES ('41', '1', '12', '2016-05-23 02:50:38');
INSERT INTO `h23` VALUES ('42', '1', '13', '2016-05-23 03:04:55');
INSERT INTO `h23` VALUES ('44', '1', '14', '2016-05-23 13:08:01');
INSERT INTO `h23` VALUES ('46', '1', '15', '2016-05-23 14:19:59');
INSERT INTO `h23` VALUES ('47', '3', '13', '2016-05-23 14:25:50');
INSERT INTO `h23` VALUES ('48', '1', '7', '2016-05-23 14:26:46');
INSERT INTO `h23` VALUES ('49', '1', '16', '2016-05-23 14:26:46');
INSERT INTO `h23` VALUES ('50', '1', '17', '2016-05-23 19:20:55');

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
) ENGINE=InnoDB AUTO_INCREMENT=45 DEFAULT CHARSET=utf8 COMMENT='用户信息表';

-- ----------------------------
-- Records of t10
-- ----------------------------
INSERT INTO `t10` VALUES ('2', 'asd2012', '2693491512@qq.com', 'ea506d620623c93c17aa07c1d1ef89cbb15ec9a0', 'QY', 'F', '2016-02-29 00:57:25', 'QY');
INSERT INTO `t10` VALUES ('3', 'asd2016', '193685589712323@qq.com', 'ea506d620623c93c17aa07c1d1ef89cbb15ec9a0', 'FXS', 'F', '2016-02-29 00:58:34', 'QY');
INSERT INTO `t10` VALUES ('4', 'asd2013', '269349151@qq.com', 'ea506d620623c93c17aa07c1d1ef89cbb15ec9a0', 'FXS', 'F', '2016-03-06 11:59:13', 'WJH');
INSERT INTO `t10` VALUES ('5', 'asd2017', '3423748738@qq.com', 'ea506d620623c93c17aa07c1d1ef89cbb15ec9a0', 'FXS', 'F', '2016-03-10 20:46:14', 'HMD');
INSERT INTO `t10` VALUES ('6', 'test_0', '269340@qq.com', '7c4a8d09ca3762af61e59520943dc26494f8941b', 'FXS', 'F', '2016-03-21 21:51:12', 'WJH');
INSERT INTO `t10` VALUES ('7', 'test_1', '269341@qq.com', '7c4a8d09ca3762af61e59520943dc26494f8941b', 'FXS', 'F', '2016-03-21 21:51:13', 'WJH');
INSERT INTO `t10` VALUES ('8', 'test_2', '269342@qq.com', '7c4a8d09ca3762af61e59520943dc26494f8941b', 'FXS', 'F', '2016-03-21 21:51:13', 'WJH');
INSERT INTO `t10` VALUES ('9', 'test_3', '269343@qq.com', '7c4a8d09ca3762af61e59520943dc26494f8941b', 'FXS', 'F', '2016-03-21 21:51:13', 'WJH');
INSERT INTO `t10` VALUES ('10', 'test_4', '269344@qq.com', '7c4a8d09ca3762af61e59520943dc26494f8941b', 'FXS', 'F', '2016-03-21 21:51:13', 'WJH');
INSERT INTO `t10` VALUES ('11', 'test_5', '269345@qq.com', '7c4a8d09ca3762af61e59520943dc26494f8941b', 'FXS', 'F', '2016-03-21 21:51:13', 'WJH');
INSERT INTO `t10` VALUES ('12', 'test_6', '269346@qq.com', '7c4a8d09ca3762af61e59520943dc26494f8941b', 'FXS', 'F', '2016-03-21 21:51:13', 'WJH');
INSERT INTO `t10` VALUES ('13', 'test_7', '269347@qq.com', '7c4a8d09ca3762af61e59520943dc26494f8941b', 'FXS', 'F', '2016-03-21 21:51:13', 'WJH');
INSERT INTO `t10` VALUES ('14', 'test_8', '269348@qq.com', '7c4a8d09ca3762af61e59520943dc26494f8941b', 'FXS', 'F', '2016-03-21 21:51:13', 'WJH');
INSERT INTO `t10` VALUES ('15', 'test_9', '269349@qq.com', '7c4a8d09ca3762af61e59520943dc26494f8941b', 'FXS', 'F', '2016-03-21 21:51:13', 'WJH');
INSERT INTO `t10` VALUES ('16', 'test_10', '2693410@qq.com', '7c4a8d09ca3762af61e59520943dc26494f8941b', 'FXS', 'F', '2016-03-21 21:51:13', 'WJH');
INSERT INTO `t10` VALUES ('17', 'test_11', '2693411@qq.com', '7c4a8d09ca3762af61e59520943dc26494f8941b', 'FXS', 'F', '2016-03-21 21:51:13', 'WJH');
INSERT INTO `t10` VALUES ('18', 'test_12', '2693412@qq.com', '7c4a8d09ca3762af61e59520943dc26494f8941b', 'FXS', 'F', '2016-03-21 21:51:13', 'WJH');
INSERT INTO `t10` VALUES ('19', 'test_13', '2693413@qq.com', '7c4a8d09ca3762af61e59520943dc26494f8941b', 'FXS', 'F', '2016-03-21 21:51:13', 'WJH');
INSERT INTO `t10` VALUES ('20', 'test_14', '2693414@qq.com', '7c4a8d09ca3762af61e59520943dc26494f8941b', 'FXS', 'F', '2016-03-21 21:51:13', 'WJH');
INSERT INTO `t10` VALUES ('21', 'test_15', '2693415@qq.com', '7c4a8d09ca3762af61e59520943dc26494f8941b', 'FXS', 'F', '2016-03-21 21:51:13', 'WJH');
INSERT INTO `t10` VALUES ('22', 'test_16', '2693416@qq.com', '7c4a8d09ca3762af61e59520943dc26494f8941b', 'FXS', 'F', '2016-03-21 21:51:13', 'WJH');
INSERT INTO `t10` VALUES ('23', 'test_17', '2693417@qq.com', '7c4a8d09ca3762af61e59520943dc26494f8941b', 'FXS', 'F', '2016-03-21 21:51:13', 'WJH');
INSERT INTO `t10` VALUES ('24', 'test_18', '2693418@qq.com', '7c4a8d09ca3762af61e59520943dc26494f8941b', 'FXS', 'F', '2016-03-21 21:51:13', 'WJH');
INSERT INTO `t10` VALUES ('25', 'test_19', '2693419@qq.com', '7c4a8d09ca3762af61e59520943dc26494f8941b', 'FXS', 'F', '2016-03-21 21:51:13', 'WJH');
INSERT INTO `t10` VALUES ('26', 'test_20', '2693420@qq.com', '7c4a8d09ca3762af61e59520943dc26494f8941b', 'FXS', 'F', '2016-03-21 21:51:13', 'WJH');
INSERT INTO `t10` VALUES ('27', 'test_21', '2693421@qq.com', '7c4a8d09ca3762af61e59520943dc26494f8941b', 'FXS', 'F', '2016-03-21 21:51:13', 'WJH');
INSERT INTO `t10` VALUES ('28', 'test_22', '2693422@qq.com', '7c4a8d09ca3762af61e59520943dc26494f8941b', 'FXS', 'F', '2016-03-21 21:51:13', 'WJH');
INSERT INTO `t10` VALUES ('29', 'test_23', '2693423@qq.com', '7c4a8d09ca3762af61e59520943dc26494f8941b', 'FXS', 'F', '2016-03-21 21:51:13', 'WJH');
INSERT INTO `t10` VALUES ('30', 'test_24', '2693424@qq.com', '7c4a8d09ca3762af61e59520943dc26494f8941b', 'FXS', 'F', '2016-03-21 21:51:13', 'WJH');
INSERT INTO `t10` VALUES ('31', 'test_25', '2693425@qq.com', '7c4a8d09ca3762af61e59520943dc26494f8941b', 'FXS', 'F', '2016-03-21 21:51:13', 'WJH');
INSERT INTO `t10` VALUES ('32', 'test_26', '2693426@qq.com', '7c4a8d09ca3762af61e59520943dc26494f8941b', 'FXS', 'F', '2016-03-21 21:51:13', 'WJH');
INSERT INTO `t10` VALUES ('33', 'test_27', '2693427@qq.com', '7c4a8d09ca3762af61e59520943dc26494f8941b', 'FXS', 'F', '2016-03-21 21:51:13', 'WJH');
INSERT INTO `t10` VALUES ('34', 'test_28', '2693428@qq.com', '7c4a8d09ca3762af61e59520943dc26494f8941b', 'FXS', 'F', '2016-03-21 21:51:13', 'WJH');
INSERT INTO `t10` VALUES ('35', 'test_29', '2693429@qq.com', '7c4a8d09ca3762af61e59520943dc26494f8941b', 'FXS', 'F', '2016-03-21 21:51:13', 'WJH');
INSERT INTO `t10` VALUES ('36', 'fange123', '2313914391@qq.com', 'ea506d620623c93c17aa07c1d1ef89cbb15ec9a0', 'FXS', 'F', '2016-04-03 15:07:52', 'WJH');
INSERT INTO `t10` VALUES ('37', 'asd2014', 'zgljl20121@qq.com', 'ea506d620623c93c17aa07c1d1ef89cbb15ec9a0', 'FXS', 'F', '2016-05-03 12:48:54', 'WJH');
INSERT INTO `t10` VALUES ('38', 'asd2015', 'zgljl2012@qq.com', 'ea506d620623c93c17aa07c1d1ef89cbb15ec9a0', 'FXS', 'F', '2016-05-03 12:50:52', 'WJH');
INSERT INTO `t10` VALUES ('39', 'asd2011', 'zgljl2013@qq.com', 'ea506d620623c93c17aa07c1d1ef89cbb15ec9a0', 'QY', 'F', '2016-05-11 22:04:39', 'WJH');
INSERT INTO `t10` VALUES ('41', 'asd2025', '2693491512433243@qq.com', 'ea506d620623c93c17aa07c1d1ef89cbb15ec9a0', 'QY', 'F', '2016-05-14 22:47:26', 'WJH');
INSERT INTO `t10` VALUES ('42', 'asd2026', '19368558971@qq.com', 'ea506d620623c93c17aa07c1d1ef89cbb15ec9a0', 'QY', 'F', '2016-05-14 22:48:46', 'WJH');
INSERT INTO `t10` VALUES ('43', 'asd2027', '19368558972@qq.com', 'ea506d620623c93c17aa07c1d1ef89cbb15ec9a0', 'FXS', 'F', '2016-05-14 23:29:37', 'WJH');
INSERT INTO `t10` VALUES ('44', 'asd2030', '1936855897@qq.com', 'ea506d620623c93c17aa07c1d1ef89cbb15ec9a0', 'QY', 'F', '2016-05-17 22:12:54', 'WJH');

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
INSERT INTO `t11` VALUES ('5', '3423748738@qq.com', '8008', '2016-03-10 20:46:17');
INSERT INTO `t11` VALUES ('36', '2313914391@qq.com', '5973', '2016-04-03 15:07:57');
INSERT INTO `t11` VALUES ('37', 'zgljl2012@qq.com', '1037', '2016-05-03 12:50:31');
INSERT INTO `t11` VALUES ('38', 'zgljl2012@qq.com', '1416', '2016-05-03 12:50:54');
INSERT INTO `t11` VALUES ('39', 'zgljl2013@qq.com', '3360', '2016-05-11 22:04:43');
INSERT INTO `t11` VALUES ('41', '2693491512433243@qq.com', '5128', '2016-05-14 22:47:33');
INSERT INTO `t11` VALUES ('42', '1936855897@qq.com', '4431', '2016-05-14 22:48:57');
INSERT INTO `t11` VALUES ('43', '1936855897@qq.com', '3976', '2016-05-14 23:29:40');
INSERT INTO `t11` VALUES ('44', '1936855897@qq.com', '8802', '2016-05-17 22:12:57');

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
  `F10` enum('QT','BSH','BS','SS','BK','DZ') DEFAULT NULL COMMENT '学历',
  PRIMARY KEY (`F01`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='分析师-简介';

-- ----------------------------
-- Records of t20
-- ----------------------------
INSERT INTO `t20` VALUES ('3', '廖金龙', 'NAN', '2016-03-25', null, null, '', null, '/IMAGE/1457238660379.png', null);
INSERT INTO `t20` VALUES ('4', '张三', 'NAN', '2016-01-26', '个人简介123，这是我个人简介个人简介，这是我个人简介个人简介，这是我个人简介个人简介，这是我个人简介', '2016-03-02', '湖南省长沙市XXXXX某某某某学校1234', '湖南省长沙市某某某某某某某某某某某某某有限公司', '/IMAGE/1457251447527.jpg', 'BK');
INSERT INTO `t20` VALUES ('5', '王五', 'NAN', '1994-01-01', '个人简介个人简介个人简介个人简介个人简介个人简介个人简介', '2016-01-01', null, null, null, 'BK');
INSERT INTO `t20` VALUES ('6', '王五', 'NAN', '1994-01-01', '个人简介个人简介个人简介个人简介个人简介个人简介个人简介', '2016-01-01', null, null, null, 'BK');
INSERT INTO `t20` VALUES ('7', '牛十二', 'NAN', '1994-01-01', '个人简介个人简介个人简介个人简介个人简介个人简介个人简介', '2016-01-01', null, null, null, 'BK');
INSERT INTO `t20` VALUES ('8', '王五', 'NAN', '1994-01-01', '个人简介个人简介个人简介个人简介个人简介个人简介个人简介', '2016-01-01', null, null, null, 'BK');
INSERT INTO `t20` VALUES ('9', '王五', 'NAN', '1994-01-01', '个人简介个人简介个人简介个人简介个人简介个人简介个人简介', '2016-01-01', null, null, null, 'BK');
INSERT INTO `t20` VALUES ('10', '赵六', 'NAN', '1994-01-01', '个人简介个人简介个人简介个人简介个人简介个人简介个人简介', '2015-01-01', null, null, null, 'BK');
INSERT INTO `t20` VALUES ('11', '赵六', 'NAN', '1994-01-01', '个人简介个人简介个人简介个人简介个人简介个人简介个人简介', '2015-01-01', null, null, null, 'BK');
INSERT INTO `t20` VALUES ('12', '赵六', 'NAN', '1994-01-01', '个人简介个人简介个人简介个人简介个人简介个人简介个人简介', '2015-01-01', null, null, null, 'BK');
INSERT INTO `t20` VALUES ('13', '赵六', 'NAN', '1994-01-01', '个人简介个人简介个人简介个人简介个人简介个人简介个人简介', '2015-01-01', null, null, null, 'BK');
INSERT INTO `t20` VALUES ('14', '赵六', 'NAN', '1994-01-01', '个人简介个人简介个人简介个人简介个人简介个人简介个人简介', '2013-01-01', null, null, null, 'BK');
INSERT INTO `t20` VALUES ('15', '李四', 'NAN', '1994-01-01', '个人简介个人简介个人简介个人简介个人简介个人简介个人简介', '2013-01-01', null, null, null, 'BK');
INSERT INTO `t20` VALUES ('16', '李四', 'NAN', '1994-01-01', '个人简介个人简介个人简介个人简介个人简介个人简介个人简介', '2013-01-01', null, null, null, 'BK');
INSERT INTO `t20` VALUES ('17', '李四', 'NAN', '1994-01-01', '个人简介个人简介个人简介个人简介个人简介个人简介个人简介', '2013-01-01', null, null, null, 'BK');
INSERT INTO `t20` VALUES ('18', '李四', 'NAN', '1994-01-01', '个人简介个人简介个人简介个人简介个人简介个人简介个人简介', '2012-01-01', null, null, null, 'BK');
INSERT INTO `t20` VALUES ('19', '李四', 'NAN', '1994-01-01', '个人简介个人简介个人简介个人简介个人简介个人简介个人简介', '2012-01-01', null, null, null, 'BK');
INSERT INTO `t20` VALUES ('20', '孙七', 'NAN', '1994-01-01', '个人简介个人简介个人简介个人简介个人简介个人简介个人简介', '2012-01-01', null, null, null, 'BK');
INSERT INTO `t20` VALUES ('21', '孙七', 'NAN', '1994-01-01', '个人简介个人简介个人简介个人简介个人简介个人简介个人简介', '2012-01-01', null, null, null, 'BK');
INSERT INTO `t20` VALUES ('22', '孙七', 'NAN', '1994-01-01', '个人简介个人简介个人简介个人简介个人简介个人简介个人简介', '2010-01-01', null, null, null, 'SS');
INSERT INTO `t20` VALUES ('23', '孙七', 'NAN', '1994-01-01', '个人简介个人简介个人简介个人简介个人简介个人简介个人简介', '2010-01-01', null, null, null, 'SS');
INSERT INTO `t20` VALUES ('24', '孙七', 'NAN', '1994-01-01', '个人简介个人简介个人简介个人简介个人简介个人简介个人简介', '2010-01-01', null, null, null, 'SS');
INSERT INTO `t20` VALUES ('25', '陈八', 'NAN', '1994-01-01', '个人简介个人简介个人简介个人简介个人简介个人简介个人简介', '2010-01-01', null, null, null, 'SS');
INSERT INTO `t20` VALUES ('26', '陈八', 'NAN', '1994-01-01', '个人简介个人简介个人简介个人简介个人简介个人简介个人简介', '2010-01-01', null, null, null, 'SS');
INSERT INTO `t20` VALUES ('27', '卫九', 'NAN', '1994-01-01', '个人简介个人简介个人简介个人简介个人简介个人简介个人简介', '2010-01-01', null, null, null, 'BS');
INSERT INTO `t20` VALUES ('28', '卫九', 'NAN', '1994-01-01', '个人简介个人简介个人简介个人简介个人简介个人简介个人简介', '2010-01-01', null, null, null, 'BS');
INSERT INTO `t20` VALUES ('29', '卫九', 'NAN', '1994-01-01', '个人简介个人简介个人简介个人简介个人简介个人简介个人简介', '2010-01-01', null, null, null, 'BS');
INSERT INTO `t20` VALUES ('30', '卫九', 'NAN', '1994-01-01', '个人简介个人简介个人简介个人简介个人简介个人简介个人简介', '2010-01-01', null, null, null, 'BS');
INSERT INTO `t20` VALUES ('31', '褚十', 'NAN', '1994-01-01', '个人简介个人简介个人简介个人简介个人简介个人简介个人简介', '2010-01-01', null, null, null, 'BS');
INSERT INTO `t20` VALUES ('32', '褚十', 'NAN', '1994-01-01', '个人简介个人简介个人简介个人简介个人简介个人简介个人简介', '2010-01-01', null, null, null, 'BS');
INSERT INTO `t20` VALUES ('33', '褚十', 'NAN', '1994-01-01', '个人简介个人简介个人简介个人简介个人简介个人简介个人简介', '2010-01-01', null, null, null, 'BS');
INSERT INTO `t20` VALUES ('34', '褚十', 'NAN', '1994-01-01', '个人简介个人简介个人简介个人简介个人简介个人简介个人简介', '2010-01-01', null, null, null, 'BS');
INSERT INTO `t20` VALUES ('35', '曹十一', 'NAN', '1994-01-01', '个人简介个人简介个人简介个人简介个人简介个人简介个人简介', '2010-01-01', null, null, null, 'BS');
INSERT INTO `t20` VALUES ('36', '喻一帆', null, null, null, null, null, null, null, null);
INSERT INTO `t20` VALUES ('37', null, 'NAN', '2016-05-04', null, null, null, null, '/IMAGE/1463317583368.jpg', 'BK');
INSERT INTO `t20` VALUES ('38', null, null, null, null, null, null, null, null, null);
INSERT INTO `t20` VALUES ('43', null, null, null, null, null, null, null, null, null);

-- ----------------------------
-- Table structure for t21
-- ----------------------------
DROP TABLE IF EXISTS `t21`;
CREATE TABLE `t21` (
  `F01` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增ID',
  `F02` int(11) DEFAULT NULL COMMENT '用户ID',
  `F03` varchar(100) DEFAULT NULL COMMENT '公司名称',
  `F04` date DEFAULT NULL COMMENT '开始时间',
  `F05` date DEFAULT NULL COMMENT '结束时间',
  `F06` varchar(300) DEFAULT NULL COMMENT '职务说明',
  PRIMARY KEY (`F01`)
) ENGINE=InnoDB AUTO_INCREMENT=72 DEFAULT CHARSET=utf8 COMMENT='分析师工作经历';

-- ----------------------------
-- Records of t21
-- ----------------------------
INSERT INTO `t21` VALUES ('5', '4', '某某测试公司3', '2016-03-01', null, '测试可是打开数据库的');
INSERT INTO `t21` VALUES ('18', '4', '某某测试公司', '2015-03-01', '2015-04-06', '测试测试测试测试测试测试测试测试');
INSERT INTO `t21` VALUES ('22', '4', '某某测试公司', '2015-03-01', '2015-04-06', '测试测试测试测试测试测试测试测试');
INSERT INTO `t21` VALUES ('23', '4', '某某测试公司', '2015-03-01', '2015-04-06', '测试测试测试测试测试测试测试测试');
INSERT INTO `t21` VALUES ('24', '4', '某某测试公司', '2015-03-01', '2015-04-06', '测试测试测试测试测试测试测试测试');
INSERT INTO `t21` VALUES ('25', '4', '某某测试公司', '2015-03-01', '2015-04-06', '测试测试测试测试测试测试测试测试');
INSERT INTO `t21` VALUES ('26', '4', '某某测试公司', '2015-03-01', '2015-04-06', '测试测试测试测试测试测试测试测试');
INSERT INTO `t21` VALUES ('27', '4', '某某测试公司', '2015-03-01', '2015-04-06', '测试测试测试测试测试测试测试测试');
INSERT INTO `t21` VALUES ('28', '4', '某某测试公司', '2015-03-01', '2015-04-06', '测试测试测试测试测试测试测试测试');
INSERT INTO `t21` VALUES ('29', '4', '某某测试公司', '2015-03-01', '2015-04-06', '测试测试测试测试测试测试测试测试');
INSERT INTO `t21` VALUES ('30', '4', '某某测试公司', '2015-03-01', '2015-04-06', '测试测试测试测试测试测试测试测试');
INSERT INTO `t21` VALUES ('31', '4', '某某测试公司', '2015-03-01', '2015-04-06', '测试测试测试测试测试测试测试测试');
INSERT INTO `t21` VALUES ('32', '4', '某某测试公司', '2015-03-01', '2015-04-06', '测试测试测试测试测试测试测试测试');
INSERT INTO `t21` VALUES ('33', '4', '某某测试公司', '2015-03-01', '2015-04-06', '测试测试测试测试测试测试测试测试');
INSERT INTO `t21` VALUES ('34', '4', '某某测试公司', '2015-03-01', '2015-04-06', '测试测试测试测试测试测试测试测试');
INSERT INTO `t21` VALUES ('35', '4', '某某测试公司', '2015-03-01', '2015-04-06', '测试测试测试测试测试测试测试测试');
INSERT INTO `t21` VALUES ('36', '4', '某某测试公司', '2015-03-01', '2015-04-06', '测试测试测试测试测试测试测试测试');
INSERT INTO `t21` VALUES ('37', '4', '某某测试公司', '2015-03-01', '2015-04-06', '测试测试测试测试测试测试测试测试');
INSERT INTO `t21` VALUES ('38', '4', '某某测试公司', '2015-03-01', '2015-04-06', '测试测试测试测试测试测试测试测试');
INSERT INTO `t21` VALUES ('39', '4', '某某测试公司', '2015-03-01', '2015-04-06', '测试测试测试测试测试测试测试测试');
INSERT INTO `t21` VALUES ('40', '4', '某某测试公司', '2015-03-01', '2015-04-06', '测试测试测试测试测试测试测试测试');
INSERT INTO `t21` VALUES ('41', '4', '某某测试公司', '2015-03-01', '2015-04-06', '测试测试测试测试测试测试测试测试');
INSERT INTO `t21` VALUES ('42', '4', '某某测试公司', '2015-03-01', '2015-04-06', '测试测试测试测试测试测试测试测试');
INSERT INTO `t21` VALUES ('43', '4', '某某测试公司', '2015-03-01', '2015-04-06', '测试测试测试测试测试测试测试测试');
INSERT INTO `t21` VALUES ('48', '3', '某某测试公司', '2016-03-01', '2016-03-27', '测试测试测试测试测试测试测试测试测试测试测试测试');
INSERT INTO `t21` VALUES ('49', '3', '某某测试公司', '2016-03-25', '2016-03-26', '测试测试测试测试测试测试测试测试测试测试');
INSERT INTO `t21` VALUES ('50', '3', '某某测试公司', '2016-03-26', '2016-04-03', '测试测试测试测试测试测试测试测试测试测试');
INSERT INTO `t21` VALUES ('51', '3', '测试测试测试测试测试', '2016-03-26', '2016-03-27', '测试测试测试测试测试测试测试测试测试测试');
INSERT INTO `t21` VALUES ('52', '3', '测试测试测试测试测试测试测试测试', '2016-03-01', '2016-03-11', '测试测试测试测试测试测试测试测试测试测试测试测试');
INSERT INTO `t21` VALUES ('53', '3', '测试测试测试测试测试测试测试', '2016-03-03', '2016-04-08', '测试测试测试测试测试测试测试测试测试测试测试');
INSERT INTO `t21` VALUES ('55', '3', '某某测试XXX公司2', '2016-03-01', '2016-03-03', '测试测试测试测试测试测试测试测试测试');
INSERT INTO `t21` VALUES ('56', '4', '测试公司XXX', '2015-01-01', '2016-01-01', '测试职务测试职务测试职务测试职务');
INSERT INTO `t21` VALUES ('57', '4', '测试公司XXX', '2015-01-01', '2016-01-01', '测试职务测试职务测试职务测试职务');
INSERT INTO `t21` VALUES ('58', '4', '测试公司XXX', '2015-01-01', '2016-01-01', '测试职务测试职务测试职务测试职务');
INSERT INTO `t21` VALUES ('59', '4', '测试公司XXX', '2015-01-01', '2016-01-01', '测试职务测试职务测试职务测试职务');
INSERT INTO `t21` VALUES ('60', '4', '测试公司XXX', '2015-01-01', '2016-01-01', '测试职务测试职务测试职务测试职务');
INSERT INTO `t21` VALUES ('61', '4', '测试公司XXX', '2015-01-01', '2016-01-01', '测试职务测试职务测试职务测试职务');
INSERT INTO `t21` VALUES ('62', '4', '测试公司XXX', '2015-01-01', '2016-01-01', '测试职务测试职务测试职务测试职务');
INSERT INTO `t21` VALUES ('63', '4', '测试公司XXX', '2015-01-01', '2016-01-01', '测试职务测试职务测试职务测试职务');
INSERT INTO `t21` VALUES ('64', '4', '测试公司XXX', '2015-01-01', '2016-01-01', '测试职务测试职务测试职务测试职务');
INSERT INTO `t21` VALUES ('65', '4', '测试公司XXX', '2015-01-01', '2016-01-01', '测试职务测试职务测试职务测试职务');
INSERT INTO `t21` VALUES ('66', '4', '测试公司XXX', '2015-01-01', '2016-01-01', '测试职务测试职务测试职务测试职务');
INSERT INTO `t21` VALUES ('67', '4', '测试公司XXX', '2015-01-01', '2016-01-01', '测试职务测试职务测试职务测试职务');
INSERT INTO `t21` VALUES ('68', '4', '测试公司XXX', '2015-01-01', '2016-01-01', '测试职务测试职务测试职务测试职务');
INSERT INTO `t21` VALUES ('69', '36', '测试烦个公司', '2016-03-28', '2016-04-07', '测试dsfsdfdfsdfsdfsfdfsf');
INSERT INTO `t21` VALUES ('70', '4', '12321', '2016-05-05', '2016-05-08', '12333333333333333333333333333333333333');
INSERT INTO `t21` VALUES ('71', '4', 'xxxxxxxxxxxxxx', '2016-05-05', '2016-05-14', 'xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx');

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
INSERT INTO `t30` VALUES ('2', '测试1234', '测试主营业务23123测试主营业务测试主营业务测试主营业务测试主营', '测试');
INSERT INTO `t30` VALUES ('39', null, null, null);
INSERT INTO `t30` VALUES ('41', null, null, null);
INSERT INTO `t30` VALUES ('42', null, null, null);
INSERT INTO `t30` VALUES ('44', 'A企业123456', null, null);

-- ----------------------------
-- Table structure for t40
-- ----------------------------
DROP TABLE IF EXISTS `t40`;
CREATE TABLE `t40` (
  `F01` int(10) NOT NULL AUTO_INCREMENT COMMENT '自增ID',
  `F02` varchar(25) DEFAULT NULL COMMENT '项目名称',
  `F03` float DEFAULT NULL COMMENT '价格',
  `F04` int(11) DEFAULT NULL COMMENT '发布者（企业ID）',
  `F05` enum('YJS','JXZ','TBZ','DFB','DXG','DSH','BJZ') DEFAULT NULL COMMENT '项目状态',
  `F06` date DEFAULT NULL COMMENT '创建时间',
  `F07` date DEFAULT NULL COMMENT '审核时间',
  `F08` int(11) DEFAULT NULL COMMENT '审核人ID',
  `F09` varchar(80) DEFAULT NULL COMMENT '不通过原因',
  `F10` date DEFAULT NULL COMMENT '发布时间',
  `F11` date DEFAULT NULL COMMENT '项目完成时间',
  `F12` date DEFAULT NULL COMMENT '项目要求完成时间',
  `F13` text COMMENT '项目描述',
  `F14` enum('F','S') DEFAULT NULL COMMENT '是否删除',
  `F15` int(11) DEFAULT NULL COMMENT '中标用户ID',
  `F16` timestamp NULL DEFAULT NULL COMMENT '中标时间',
  `F17` int(11) DEFAULT NULL COMMENT '招标天数',
  PRIMARY KEY (`F01`)
) ENGINE=InnoDB AUTO_INCREMENT=76 DEFAULT CHARSET=utf8 COMMENT='项目单';

-- ----------------------------
-- Records of t40
-- ----------------------------
INSERT INTO `t40` VALUES ('2', '项目789', '100', '2', 'TBZ', '2016-04-17', null, null, null, null, null, '2016-04-20', '111111111111111111111111111111', 'F', null, '2016-04-26 00:54:50', '11111');
INSERT INTO `t40` VALUES ('3', '项目名称1111', '100', '2', 'TBZ', '2016-04-20', null, null, null, null, null, '2016-04-23', '项目描述项目描述项目描述项目描述项目描述项目描述', 'F', null, '2016-04-26 00:56:26', '2');
INSERT INTO `t40` VALUES ('4', '项目名称XXX', '0', '2', 'TBZ', '2015-04-08', null, null, null, null, null, '2016-01-01', '测试职务测试职务测试职务测试职务', null, null, '2016-04-26 00:38:23', '2');
INSERT INTO `t40` VALUES ('5', '项目名称XXX', '200', '2', 'JXZ', '2015-04-08', null, null, null, null, null, '2016-01-01', '测试职务测试职务测试职务测试职务', null, '37', '2016-05-10 00:23:04', '2');
INSERT INTO `t40` VALUES ('6', '项目名称XXX', '0', '2', 'TBZ', '2015-04-08', null, null, null, null, null, '2016-05-01', '测试职务测试职务测试职务测试职务', null, null, '2016-04-26 00:38:23', '2');
INSERT INTO `t40` VALUES ('7', '项目名称XXX', '0', '2', 'TBZ', '2015-04-08', null, null, null, null, null, '2016-05-01', '测试职务测试职务测试职务测试职务', null, null, '2016-04-26 00:38:23', '2');
INSERT INTO `t40` VALUES ('8', '项目名称XXX', '0', '2', 'TBZ', '2015-04-08', null, null, null, null, null, '2016-05-01', '测试职务测试职务测试职务测试职务', null, null, '2016-04-26 00:38:23', '2');
INSERT INTO `t40` VALUES ('9', '项目名称XXX', '5500', '2', 'YJS', '2015-04-08', null, null, null, null, '2016-05-15', '2016-05-01', '测试职务测试职务测试职务测试职务', null, '4', '2016-05-06 13:12:27', '2');
INSERT INTO `t40` VALUES ('10', '项目名称XXX', '0', '2', 'TBZ', '2015-04-08', null, null, null, null, null, '2016-05-01', '测试职务测试职务测试职务测试职务', null, null, '2016-05-06 12:19:28', '2');
INSERT INTO `t40` VALUES ('11', '4445XXX', '0', '2', 'TBZ', '2015-04-08', null, null, null, null, null, '2016-05-01', '测试职务测试职务测试职务测试职务', null, null, '2016-05-06 12:19:25', '2');
INSERT INTO `t40` VALUES ('12', '项目名称XXX', '0', '2', 'TBZ', '2015-04-08', null, null, null, null, null, '2016-05-01', '测试职务测试职务测试职务测试职务', null, null, '2016-05-06 12:19:21', '2');
INSERT INTO `t40` VALUES ('13', '3311XXX', '0', '2', 'TBZ', '2015-04-08', null, null, null, null, null, '2016-05-01', '测试职务测试职务测试职务测试职务', null, null, '2016-05-06 12:19:18', '2');
INSERT INTO `t40` VALUES ('14', '项目名称XXX', '0', '2', 'TBZ', '2015-04-08', null, null, null, null, null, '2016-05-01', '测试职务测试职务测试职务测试职务', null, null, '2016-05-06 12:19:16', '2');
INSERT INTO `t40` VALUES ('15', '项目名称XXX', '0', '2', 'TBZ', '2015-04-08', null, null, null, null, null, '2016-05-01', '测试职务测试职务测试职务测试职务', null, null, '2016-05-06 12:19:13', '2');
INSERT INTO `t40` VALUES ('16', '项目名称XXX', '0', '2', 'TBZ', '2015-04-08', null, null, null, null, null, '2016-05-01', '测试职务测试职务测试职务测试职务', null, null, '2016-05-06 12:19:08', '2');
INSERT INTO `t40` VALUES ('17', '项目名称XXX', '0', '2', 'TBZ', '2015-04-08', null, null, null, null, null, '2016-05-01', '测试职务测试职务测试职务测试职务', null, null, '2016-05-06 12:19:05', '2');
INSERT INTO `t40` VALUES ('18', '项目名称XXX', '0', '2', 'TBZ', '2015-04-08', null, null, null, null, null, '2016-05-01', '测试职务测试职务测试职务测试职务', null, null, '2016-05-06 12:19:01', '2');
INSERT INTO `t40` VALUES ('19', '项目名称XXX', '0', '2', 'TBZ', '2015-04-08', null, null, null, null, null, '2016-05-01', '测试职务测试职务测试职务测试职务', null, null, '2016-05-06 12:18:58', '2');
INSERT INTO `t40` VALUES ('20', '项目名称YYY', '0', '2', 'TBZ', '2015-04-08', null, null, null, null, null, '2016-05-01', '测试职务测试职务测试职务测试职务', null, null, '2016-04-26 00:38:23', '2');
INSERT INTO `t40` VALUES ('21', '1122XXX', '0', '2', 'TBZ', '2015-04-08', null, null, null, null, null, '2016-05-01', '测试职务测试职务测试职务测试职务', null, null, '2016-04-26 00:38:23', '2');
INSERT INTO `t40` VALUES ('22', '项目名称XXX', '0', '2', 'TBZ', '2015-04-08', null, null, null, null, null, '2016-05-01', '测试职务测试职务测试职务测试职务', null, null, '2016-04-26 00:38:23', '2');
INSERT INTO `t40` VALUES ('23', '项目名称XXX', '0', '2', 'TBZ', '2015-04-08', null, null, null, null, null, '2016-05-01', '测试职务测试职务测试职务测试职务', null, null, '2016-04-26 00:38:23', '2');
INSERT INTO `t40` VALUES ('24', '项目名称XXX', '0', '2', 'TBZ', '2015-04-08', null, null, null, null, null, '2016-05-01', '测试职务测试职务测试职务测试职务', null, null, '2016-04-26 00:38:23', '2');
INSERT INTO `t40` VALUES ('25', '项目名称XXX', '0', '2', 'TBZ', '2015-04-08', null, null, null, null, null, '2016-05-01', '测试职务测试职务测试职务测试职务', null, null, '2016-04-26 00:38:23', '2');
INSERT INTO `t40` VALUES ('26', '项目名称XXX', '0', '2', 'TBZ', '2015-04-08', null, null, null, null, null, '2016-05-01', '测试职务测试职务测试职务测试职务', null, null, '2016-04-26 00:38:23', '2');
INSERT INTO `t40` VALUES ('27', '项目名称XXX', '0', '2', 'TBZ', '2015-04-08', null, null, null, null, null, '2016-05-01', '测试职务测试职务测试职务测试职务', null, null, '2016-04-26 00:38:23', '2');
INSERT INTO `t40` VALUES ('28', '项目名称XXX', '0', '2', 'TBZ', '2015-04-08', null, null, null, null, null, '2016-05-01', '测试职务测试职务测试职务测试职务', null, null, '2016-04-26 00:38:23', '2');
INSERT INTO `t40` VALUES ('29', '项目名称XXX', '0', '2', 'TBZ', '2015-04-08', null, null, null, null, null, '2016-05-01', '测试职务测试职务测试职务测试职务', null, null, '2016-04-26 00:38:23', '2');
INSERT INTO `t40` VALUES ('30', '555项目名称XXX', '1000', '2', 'YJS', '2015-04-08', null, null, null, null, '2016-05-15', '2016-05-12', '测试职务测试职务测试职务测试职务', null, '4', '2016-05-11 00:35:36', '5');
INSERT INTO `t40` VALUES ('31', '444项目名称XXX', '0', '2', 'TBZ', '2015-04-08', null, null, null, null, null, '2016-05-01', '测试职务测试职务测试职务测试职务', null, null, null, '2');
INSERT INTO `t40` VALUES ('32', '444项目名称XXX', '0', '2', 'TBZ', '2015-04-08', null, null, null, null, null, '2016-05-01', '测试职务测试职务测试职务测试职务', null, null, null, '2');
INSERT INTO `t40` VALUES ('33', '444项目名称YYY', '0', '2', 'DSH', '2015-04-08', '2016-05-21', '0', '不通过不通过', null, null, '2016-05-01', '测试职务测试职务测试职务测试职务', null, null, null, '3');
INSERT INTO `t40` VALUES ('34', '444项目名称ZZZ', '0', '2', 'DXG', '2015-04-08', '2016-05-21', '0', '不通过不通过', null, null, '2016-05-01', '测试职务测试职务测试职务测试职务', null, null, null, '2');
INSERT INTO `t40` VALUES ('35', '444项目名称ZZZ', '0', '2', 'DSH', '2015-04-08', '2016-05-21', '0', '不通过\r\n不通过', null, null, '2016-05-01', '测试职务测试职务测试职务测试职务', null, null, null, '2');
INSERT INTO `t40` VALUES ('36', '444项目名称XXX', '0', '2', 'DXG', '2015-04-08', '2016-05-17', '0', '尊敬的用户您好，您于2015-04-08发布的项目【444项目名称XXX】没有通过审核', null, null, '2016-05-01', '测试职务测试职务测试职务测试职务', null, null, null, '2');
INSERT INTO `t40` VALUES ('37', '444项目名称XXX', '0', '2', 'DXG', '2015-04-08', '2016-05-17', '0', '尊敬的用户您好，您于2015-04-08发布的项目【444项目名称XXX】没有通过审核', null, null, '2016-05-01', '测试职务测试职务测试职务测试职务', null, null, null, '2');
INSERT INTO `t40` VALUES ('38', '444项目名称XXX', '0', '2', 'TBZ', '2015-04-08', null, null, null, null, null, '2016-05-01', '测试职务测试职务测试职务测试职务', null, null, null, '2');
INSERT INTO `t40` VALUES ('39', '444项目名称XXX', '0', '2', 'DXG', '2015-04-08', '2016-05-17', '0', '尊敬的用户您好，您于2015-04-08发布的项目【444项目名称XXX】没有通过审核', null, null, '2016-05-01', '测试职务测试职务测试职务测试职务', null, null, null, '2');
INSERT INTO `t40` VALUES ('40', '444项目名称ZZZ', '0', '2', 'DXG', '2015-04-08', '2016-05-21', '0', '尊敬的用户您好，您于2015-04-08发布的项目【444项目名称ZZZ】没有通过审核 项目不通过不通过', null, null, '2016-05-01', '测试职务测试职务测试职务测试职务', null, null, null, '2');
INSERT INTO `t40` VALUES ('41', '555项目名称XXX', '0', '2', 'DSH', '2015-04-08', null, null, null, null, null, '2016-05-01', '测试职务测试职务测试职务测试职务', null, null, '2016-04-20 22:29:32', '2');
INSERT INTO `t40` VALUES ('42', '555项目名称XXX', '0', '2', 'DSH', '2015-04-08', null, null, null, null, null, '2016-05-01', '测试职务测试职务测试职务测试职务', null, null, '2016-04-20 22:29:37', '2');
INSERT INTO `t40` VALUES ('43', '444项目名称XXX', '0', '2', 'DSH', '2015-04-08', null, null, null, null, null, '2016-05-01', '测试职务测试职务测试职务测试职务', null, null, null, '2');
INSERT INTO `t40` VALUES ('44', '555项目名称XXX', '0', '2', 'DSH', '2015-04-08', null, null, null, null, null, '2016-05-01', '测试职务测试职务测试职务测试职务', null, null, '2016-04-20 22:29:42', '2');
INSERT INTO `t40` VALUES ('45', '444项目名称XXX', '0', '2', 'DSH', '2015-04-08', null, null, null, null, null, '2016-05-01', '测试职务测试职务测试职务测试职务', null, null, null, '2');
INSERT INTO `t40` VALUES ('46', '444项目名称XXX', '0', '2', 'DSH', '2015-04-08', null, null, null, null, null, '2016-05-01', '测试职务测试职务测试职务测试职务', null, null, null, '2');
INSERT INTO `t40` VALUES ('47', '444项目名称XXX', '0', '2', 'DSH', '2015-04-08', null, null, null, null, null, '2016-05-01', '测试职务测试职务测试职务测试职务', null, null, null, '2');
INSERT INTO `t40` VALUES ('48', '444项目名称XXX', '0', '2', 'DSH', '2015-04-08', null, null, null, null, null, '2016-05-01', '测试职务测试职务测试职务测试职务', null, null, null, '2');
INSERT INTO `t40` VALUES ('49', '444项目名称XXX', '0', '2', 'DSH', '2015-04-08', null, null, null, null, null, '2016-05-01', '测试职务测试职务测试职务测试职务', null, null, null, '2');
INSERT INTO `t40` VALUES ('50', '444项目名称XXX', '0', '2', 'DSH', '2015-04-08', null, null, null, null, null, '2016-05-01', '测试职务测试职务测试职务测试职务', null, null, null, '2');
INSERT INTO `t40` VALUES ('51', '444项目名称XXX', '0', '2', 'DSH', '2015-04-08', null, null, null, null, null, '2016-05-01', '测试职务测试职务测试职务测试职务', null, null, null, '2');
INSERT INTO `t40` VALUES ('52', '666项目名称XXX', '0', '2', 'DSH', '2015-04-08', null, null, null, null, null, '2016-05-01', '测试职务测试职务测试职务测试职务', null, null, '2016-04-20 22:29:50', '2');
INSERT INTO `t40` VALUES ('53', '666项目名称XXX', '0', '2', 'DSH', '2015-04-08', null, null, null, null, null, '2016-05-01', '测试职务测试职务测试职务测试职务', null, null, '2016-04-20 22:29:55', '2');
INSERT INTO `t40` VALUES ('54', '666项目名称XXX', '0', '2', 'DSH', '2015-04-08', null, null, null, null, null, '2016-05-01', '测试职务测试职务测试职务测试职务', null, null, '2016-04-20 22:29:59', '2');
INSERT INTO `t40` VALUES ('55', '444项目名称XXX', '0', '2', 'DSH', '2015-04-08', null, null, null, null, null, '2016-05-01', '测试职务测试职务测试职务测试职务', null, null, null, '2');
INSERT INTO `t40` VALUES ('56', '444项目名称XXX', '0', '2', 'DSH', '2015-04-08', null, null, null, null, null, '2016-05-01', '测试职务测试职务测试职务测试职务', null, null, null, '2');
INSERT INTO `t40` VALUES ('57', '444项目名称XXX', '0', '2', 'DSH', '2015-04-08', null, null, null, null, null, '2016-05-01', '测试职务测试职务测试职务测试职务', null, null, null, '2');
INSERT INTO `t40` VALUES ('58', '444项目名称XXX', '0', '2', 'DSH', '2015-04-08', null, null, null, null, null, '2016-05-01', '测试职务测试职务测试职务测试职务', null, null, null, '2');
INSERT INTO `t40` VALUES ('59', '444项目名称XXX', '0', '2', 'DSH', '2015-04-08', null, null, null, null, null, '2016-05-01', '测试职务测试职务测试职务测试职务', null, null, null, '2');
INSERT INTO `t40` VALUES ('60', '444项目名称XXX', '0', '2', 'DSH', '2015-04-08', null, null, null, null, null, '2016-05-01', '测试职务测试职务测试职务测试职务', null, null, null, '2');
INSERT INTO `t40` VALUES ('61', '444项目名称XXX', '0', '2', 'DSH', '2015-04-08', null, null, null, null, null, '2016-05-01', '测试职务测试职务测试职务测试职务', null, null, null, '2');
INSERT INTO `t40` VALUES ('62', '444项目名称XXX', '0', '2', 'DSH', '2015-04-08', null, null, null, null, null, '2016-05-01', '测试职务测试职务测试职务测试职务', null, null, null, '2');
INSERT INTO `t40` VALUES ('63', '444项目名称XXX', '0', '2', 'DSH', '2015-04-08', null, null, null, null, null, '2016-05-01', '测试职务测试职务测试职务测试职务', null, null, null, '2');
INSERT INTO `t40` VALUES ('64', '444项目名称XXX', '0', '2', 'DSH', '2015-04-08', null, null, null, null, null, '2016-05-01', '测试职务测试职务测试职务测试职务', null, null, null, '2');
INSERT INTO `t40` VALUES ('65', '444项目名称XXX', '0', '2', 'DSH', '2015-04-08', null, null, null, null, null, '2016-05-01', '测试职务测试职务测试职务测试职务', null, null, null, '2');
INSERT INTO `t40` VALUES ('66', '444项目名称XXX', '0', '2', 'DSH', '2015-04-08', null, null, null, null, null, '2016-05-01', '测试职务测试职务测试职务测试职务', null, null, null, '2');
INSERT INTO `t40` VALUES ('67', '444项目名称XXX', '0', '2', 'DSH', '2015-04-08', null, null, null, null, null, '2016-05-01', '测试职务测试职务测试职务测试职务', null, null, null, '2');
INSERT INTO `t40` VALUES ('68', '444项目名称XXX', '0', '2', 'DSH', '2015-04-08', null, null, null, null, null, '2016-05-01', '测试职务测试职务测试职务测试职务', null, null, null, '2');
INSERT INTO `t40` VALUES ('69', '444项目名称XXX', '0', '2', 'DSH', '2015-04-08', null, null, null, null, null, '2016-05-01', '测试职务测试职务测试职务测试职务', null, null, null, '2');
INSERT INTO `t40` VALUES ('70', '444项目名称XXX', '0', '2', 'DSH', '2015-04-08', null, null, null, null, null, '2016-05-01', '测试职务测试职务测试职务测试职务', null, null, null, '2');
INSERT INTO `t40` VALUES ('71', '444项目名称XXX', '0', '2', 'DSH', '2015-04-08', null, null, null, null, null, '2016-05-01', '测试职务测试职务测试职务测试职务', null, null, null, '2');
INSERT INTO `t40` VALUES ('72', '444项目名称XXX', '100', '2', 'DSH', '2015-04-08', null, null, null, null, null, '2016-05-01', '测试职务测试职务测试职务测试职务', null, null, '2016-04-21 00:48:15', '2');
INSERT INTO `t40` VALUES ('73', '项目测试2222', '100', '39', 'TBZ', '2016-05-11', null, null, null, null, null, '2016-05-27', '项目描述项目描述项目描述项目描述项目描述项目描述', 'F', null, null, '1');
INSERT INTO `t40` VALUES ('74', '232423432', '123213', '2', 'DSH', '2016-05-15', null, null, null, null, null, '2016-06-05', '12333333333333333333333333', 'F', null, null, '23');
INSERT INTO `t40` VALUES ('75', '项目1234', '0', '44', 'DXG', '2016-05-17', '2016-05-17', '0', '尊敬的用户您好，您于2016-05-17发布的项目【项目1234】没有通过审核，需求描述不清晰', null, null, '2016-06-05', '项目描述项目描述项目描述项目描述项目描述项目描述项目描述', 'F', null, null, '5');

-- ----------------------------
-- Table structure for t41
-- ----------------------------
DROP TABLE IF EXISTS `t41`;
CREATE TABLE `t41` (
  `F01` int(11) NOT NULL AUTO_INCREMENT,
  `F02` int(11) DEFAULT NULL,
  `F03` varchar(100) DEFAULT NULL,
  `F04` timestamp NULL DEFAULT NULL,
  `F05` enum('F','S') DEFAULT NULL,
  PRIMARY KEY (`F01`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t41
-- ----------------------------
INSERT INTO `t41` VALUES ('1', '40', '/FILE/1463582624550.xls', '2016-05-18 22:43:45', 'F');
INSERT INTO `t41` VALUES ('2', '42', '/FILE/1463584640627.xlsx', '2016-05-18 23:17:21', 'F');
INSERT INTO `t41` VALUES ('3', '2', '/FILE/1463627174575.xlsx', '2016-05-19 11:06:15', 'F');

-- ----------------------------
-- Table structure for t50
-- ----------------------------
DROP TABLE IF EXISTS `t50`;
CREATE TABLE `t50` (
  `F01` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增ID',
  `F02` int(11) DEFAULT NULL COMMENT '项目ID',
  `F03` int(11) DEFAULT NULL COMMENT '用户ID',
  `F04` float DEFAULT NULL COMMENT '报价',
  `F05` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '时间戳',
  `F06` enum('F','S') DEFAULT NULL COMMENT '是否删除',
  PRIMARY KEY (`F01`)
) ENGINE=InnoDB AUTO_INCREMENT=43 DEFAULT CHARSET=utf8 COMMENT='投标单';

-- ----------------------------
-- Records of t50
-- ----------------------------
INSERT INTO `t50` VALUES ('1', '9', '4', '222', '2016-05-05 23:22:45', 'F');
INSERT INTO `t50` VALUES ('2', '9', '4', '222', '2016-05-05 19:04:09', 'S');
INSERT INTO `t50` VALUES ('3', '9', '4', '222', '2016-05-05 19:04:48', 'S');
INSERT INTO `t50` VALUES ('4', '9', '4', '123', '2016-05-05 19:05:55', 'S');
INSERT INTO `t50` VALUES ('5', '9', '37', '22222', '2016-05-06 00:15:35', 'S');
INSERT INTO `t50` VALUES ('6', '9', '4', '123', '2016-05-05 19:06:06', 'S');
INSERT INTO `t50` VALUES ('7', '9', '4', '343', '2016-05-05 19:06:13', 'S');
INSERT INTO `t50` VALUES ('8', '9', '38', '3434', '2016-05-05 19:06:16', 'S');
INSERT INTO `t50` VALUES ('9', '9', '4', '123', '2016-05-05 23:54:52', 'S');
INSERT INTO `t50` VALUES ('10', '9', '4', '123', '2016-05-05 23:51:26', 'S');
INSERT INTO `t50` VALUES ('11', '9', '4', '123', '2016-05-05 23:51:32', 'S');
INSERT INTO `t50` VALUES ('12', '9', '4', '123', '2016-05-05 23:53:29', 'S');
INSERT INTO `t50` VALUES ('13', '9', '4', '123', '2016-05-05 23:53:41', 'S');
INSERT INTO `t50` VALUES ('14', '9', '4', '123', '2016-05-05 23:53:48', 'S');
INSERT INTO `t50` VALUES ('15', '9', '4', '123', '2016-05-05 23:54:23', 'S');
INSERT INTO `t50` VALUES ('16', '9', '4', '123', '2016-05-06 00:15:38', 'S');
INSERT INTO `t50` VALUES ('17', '9', '4', '123', '2016-05-04 10:18:22', 'F');
INSERT INTO `t50` VALUES ('18', '9', '4', '123', '2016-05-04 10:18:23', 'F');
INSERT INTO `t50` VALUES ('19', '9', '4', '123', '2016-05-04 10:18:23', 'F');
INSERT INTO `t50` VALUES ('20', '9', '4', '123', '2016-05-04 10:18:23', 'F');
INSERT INTO `t50` VALUES ('21', '9', '4', '123', '2016-05-04 10:18:24', 'F');
INSERT INTO `t50` VALUES ('22', '9', '4', '123', '2016-05-04 10:18:25', 'F');
INSERT INTO `t50` VALUES ('23', '9', '4', '123', '2016-05-04 10:18:49', 'F');
INSERT INTO `t50` VALUES ('24', '9', '4', '123', '2016-05-04 10:18:49', 'F');
INSERT INTO `t50` VALUES ('25', '9', '4', '123', '2016-05-04 10:18:49', 'F');
INSERT INTO `t50` VALUES ('26', '9', '4', '123', '2016-05-04 10:18:50', 'F');
INSERT INTO `t50` VALUES ('27', '9', '4', '123', '2016-05-04 10:18:50', 'F');
INSERT INTO `t50` VALUES ('28', '9', '4', '123', '2016-05-04 10:18:50', 'F');
INSERT INTO `t50` VALUES ('29', '9', '4', '123', '2016-05-05 19:06:39', 'S');
INSERT INTO `t50` VALUES ('30', '9', '4', '123', '2016-05-05 19:06:41', 'S');
INSERT INTO `t50` VALUES ('31', '9', '4', '123', '2016-05-05 19:06:43', 'S');
INSERT INTO `t50` VALUES ('32', '9', '4', '123', '2016-05-05 19:06:33', 'S');
INSERT INTO `t50` VALUES ('33', '9', '4', '123', '2016-05-05 19:06:45', 'S');
INSERT INTO `t50` VALUES ('34', '9', '4', '123', '2016-05-05 19:06:36', 'S');
INSERT INTO `t50` VALUES ('35', '9', '4', '123', '2016-05-05 19:06:47', 'S');
INSERT INTO `t50` VALUES ('36', '9', '4', '123', '2016-05-04 10:18:53', 'F');
INSERT INTO `t50` VALUES ('37', '9', '4', '123', '2016-05-05 23:52:16', 'S');
INSERT INTO `t50` VALUES ('38', '9', '4', '123', '2016-05-05 23:52:01', 'S');
INSERT INTO `t50` VALUES ('39', '5', '37', '456', '2016-05-10 00:10:36', 'F');
INSERT INTO `t50` VALUES ('40', '5', '38', '123', '2016-05-10 00:16:23', 'F');
INSERT INTO `t50` VALUES ('41', '30', '4', '200', '2016-05-11 00:33:09', 'F');
INSERT INTO `t50` VALUES ('42', '2', '4', '100', '2016-05-21 12:01:43', 'F');

-- ----------------------------
-- Table structure for t51
-- ----------------------------
DROP TABLE IF EXISTS `t51`;
CREATE TABLE `t51` (
  `F01` int(11) NOT NULL COMMENT '投标单ID',
  `F02` varchar(255) DEFAULT NULL COMMENT '留言',
  PRIMARY KEY (`F01`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t51
-- ----------------------------
INSERT INTO `t51` VALUES ('2', '1111111111111111111');
INSERT INTO `t51` VALUES ('3', '1111111111111111111');
INSERT INTO `t51` VALUES ('4', 'dfsdfsdffdfsdfsdffdfsdfsdffdfsdfsdffdfsdfsdffdfsdfsdffdfsdfsdffdfsdfsdffdfsdfsdff\\ndsfsdfdfsdfsdffdfsdfsdffdfsdfsdffdfsdfsdffdfsdfsdffdfsdfsdffdfsdfsdffdfsdfsdffdfsdfsdff');
INSERT INTO `t51` VALUES ('5', '22222222222222222');
INSERT INTO `t51` VALUES ('6', '23123123213');
INSERT INTO `t51` VALUES ('7', '3214324234324');
INSERT INTO `t51` VALUES ('8', '4234234214324324343');
INSERT INTO `t51` VALUES ('9', 'commentcommentcommentcommentcommentcommentcomment');
INSERT INTO `t51` VALUES ('10', 'commentcommentcommentcommentcommentcommentcomment');
INSERT INTO `t51` VALUES ('11', 'commentcommentcommentcommentcommentcommentcomment');
INSERT INTO `t51` VALUES ('12', 'commentcommentcommentcommentcommentcommentcomment');
INSERT INTO `t51` VALUES ('13', 'commentcommentcommentcommentcommentcommentcomment');
INSERT INTO `t51` VALUES ('14', 'commentcommentcommentcommentcommentcommentcomment');
INSERT INTO `t51` VALUES ('15', 'commentcommentcommentcommentcommentcommentcomment');
INSERT INTO `t51` VALUES ('16', 'commentcommentcommentcommentcommentcommentcomment');
INSERT INTO `t51` VALUES ('17', 'commentcommentcommentcommentcommentcommentcomment');
INSERT INTO `t51` VALUES ('18', 'commentcommentcommentcommentcommentcommentcomment');
INSERT INTO `t51` VALUES ('19', 'commentcommentcommentcommentcommentcommentcomment');
INSERT INTO `t51` VALUES ('20', 'commentcommentcommentcommentcommentcommentcomment');
INSERT INTO `t51` VALUES ('21', 'commentcommentcommentcommentcommentcommentcomment');
INSERT INTO `t51` VALUES ('22', 'commentcommentcommentcommentcommentcommentcomment');
INSERT INTO `t51` VALUES ('23', 'commentcommentcommentcommentcommentcommentcomment');
INSERT INTO `t51` VALUES ('24', 'commentcommentcommentcommentcommentcommentcomment');
INSERT INTO `t51` VALUES ('25', 'commentcommentcommentcommentcommentcommentcomment');
INSERT INTO `t51` VALUES ('26', 'commentcommentcommentcommentcommentcommentcomment');
INSERT INTO `t51` VALUES ('27', 'commentcommentcommentcommentcommentcommentcomment');
INSERT INTO `t51` VALUES ('28', 'commentcommentcommentcommentcommentcommentcomment');
INSERT INTO `t51` VALUES ('29', 'commentcommentcommentcommentcommentcommentcomment');
INSERT INTO `t51` VALUES ('30', 'commentcommentcommentcommentcommentcommentcomment');
INSERT INTO `t51` VALUES ('31', 'commentcommentcommentcommentcommentcommentcomment');
INSERT INTO `t51` VALUES ('32', 'commentcommentcommentcommentcommentcommentcomment');
INSERT INTO `t51` VALUES ('33', 'commentcommentcommentcommentcommentcommentcomment');
INSERT INTO `t51` VALUES ('34', 'commentcommentcommentcommentcommentcommentcomment');
INSERT INTO `t51` VALUES ('35', 'commentcommentcommentcommentcommentcommentcomment');
INSERT INTO `t51` VALUES ('36', 'commentcommentcommentcommentcommentcommentcomment');
INSERT INTO `t51` VALUES ('37', 'commentcommentcommentcommentcommentcommentcomment');
INSERT INTO `t51` VALUES ('38', 'commentcommentcommentcommentcommentcommentcomment');
INSERT INTO `t51` VALUES ('39', '投标投标投标投标投标投标');
INSERT INTO `t51` VALUES ('40', 'toubiaotoubiaotoubiaotoubiaotoubiaotoubiao');
INSERT INTO `t51` VALUES ('41', '..................................................');
INSERT INTO `t51` VALUES ('42', '投标\n投标\n投标投标投标\n投标投标投标投标投标');

-- ----------------------------
-- Table structure for t60
-- ----------------------------
DROP TABLE IF EXISTS `t60`;
CREATE TABLE `t60` (
  `F01` int(11) NOT NULL AUTO_INCREMENT,
  `F02` int(11) DEFAULT NULL COMMENT '发信人ID',
  `F03` int(11) DEFAULT NULL COMMENT '收信人ID',
  `F04` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `F05` varchar(30) DEFAULT NULL COMMENT '标题',
  `F06` enum('F','S') DEFAULT NULL COMMENT '是否已读',
  `F07` enum('F','S') DEFAULT NULL COMMENT '是否删除',
  PRIMARY KEY (`F01`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t60
-- ----------------------------
INSERT INTO `t60` VALUES ('1', '0', '2', '2016-05-16 04:54:28', '测试1', 'S', 'S');
INSERT INTO `t60` VALUES ('2', '0', '2', '2016-05-16 05:06:44', '测试2', 'S', 'F');
INSERT INTO `t60` VALUES ('3', '0', '2', '2016-05-16 04:53:49', '测试3', 'S', 'F');
INSERT INTO `t60` VALUES ('4', '0', '43', '2016-05-14 23:29:37', '注册成功', 'F', 'F');
INSERT INTO `t60` VALUES ('5', '0', '2', '2016-05-16 05:06:38', '测试4', 'F', 'S');
INSERT INTO `t60` VALUES ('6', '0', '2', '2016-05-16 04:54:12', '测试5', 'S', 'S');
INSERT INTO `t60` VALUES ('7', '0', '2', '2016-05-16 04:54:32', '测试6', 'S', 'F');
INSERT INTO `t60` VALUES ('8', '0', '2', '2016-05-16 04:53:44', '测试7', 'S', 'F');
INSERT INTO `t60` VALUES ('9', '0', '2', '2016-05-16 04:53:43', '测试8', 'S', 'F');
INSERT INTO `t60` VALUES ('10', '0', '2', '2016-05-17 19:26:37', '审核未通过', 'S', 'F');
INSERT INTO `t60` VALUES ('11', '0', '2', '2016-05-17 19:26:36', '审核未通过', 'S', 'F');
INSERT INTO `t60` VALUES ('12', '0', '2', '2016-05-17 19:26:34', '审核未通过', 'S', 'F');
INSERT INTO `t60` VALUES ('13', '0', '2', '2016-05-17 19:26:33', '审核未通过', 'S', 'F');
INSERT INTO `t60` VALUES ('14', '0', '2', '2016-05-17 19:27:39', '审核通过', 'S', 'F');
INSERT INTO `t60` VALUES ('15', '0', '2', '2016-05-17 19:42:21', '审核未通过', 'S', 'F');
INSERT INTO `t60` VALUES ('16', '0', '44', '2016-05-17 22:13:18', '注册成功', 'S', 'F');
INSERT INTO `t60` VALUES ('17', '0', '44', '2016-05-17 23:57:49', '审核未通过', 'S', 'F');
INSERT INTO `t60` VALUES ('18', '0', '2', '2016-05-21 11:38:14', '审核未通过', 'S', 'F');
INSERT INTO `t60` VALUES ('19', '0', '2', '2016-05-21 11:49:46', '审核未通过', 'S', 'F');
INSERT INTO `t60` VALUES ('20', '0', '2', '2016-05-21 11:49:45', '测试', 'S', 'F');
INSERT INTO `t60` VALUES ('21', '0', '2', '2016-05-21 11:49:42', '测试', 'S', 'F');
INSERT INTO `t60` VALUES ('22', '0', '2', '2016-05-21 12:18:00', '审核未通过', 'S', 'F');
INSERT INTO `t60` VALUES ('23', '0', '2', '2016-05-21 14:39:13', '审核未通过', 'S', 'F');
INSERT INTO `t60` VALUES ('24', '0', '2', '2016-05-21 14:39:10', '审核未通过', 'S', 'F');
INSERT INTO `t60` VALUES ('25', '0', '2', '2016-05-21 14:39:08', '审核未通过', 'S', 'F');
INSERT INTO `t60` VALUES ('26', '0', '2', '2016-05-23 21:32:37', '测试', 'S', 'F');

-- ----------------------------
-- Table structure for t61
-- ----------------------------
DROP TABLE IF EXISTS `t61`;
CREATE TABLE `t61` (
  `F01` int(11) NOT NULL,
  `F02` text,
  PRIMARY KEY (`F01`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t61
-- ----------------------------
INSERT INTO `t61` VALUES ('1', '测试content');
INSERT INTO `t61` VALUES ('2', '测试测试测试测试测试');
INSERT INTO `t61` VALUES ('3', '测试');
INSERT INTO `t61` VALUES ('4', '尊敬的用户asd2027，欢迎注册我们网站.');
INSERT INTO `t61` VALUES ('5', '测试');
INSERT INTO `t61` VALUES ('6', '测试');
INSERT INTO `t61` VALUES ('7', '测试');
INSERT INTO `t61` VALUES ('8', '测试');
INSERT INTO `t61` VALUES ('9', 'Test');
INSERT INTO `t61` VALUES ('10', '项目审核不通过');
INSERT INTO `t61` VALUES ('11', '');
INSERT INTO `t61` VALUES ('12', '');
INSERT INTO `t61` VALUES ('13', '此项目不通过');
INSERT INTO `t61` VALUES ('14', '尊敬的用户您好，您于2015-04-08发布的项目【444项目名称XXX】已审核通过。');
INSERT INTO `t61` VALUES ('15', '尊敬的用户您好，您于2015-04-08发布的项目【444项目名称XXX】没有通过审核，具体原因为:\n不通过');
INSERT INTO `t61` VALUES ('16', '尊敬的用户asd2030，欢迎注册我们网站.');
INSERT INTO `t61` VALUES ('17', '尊敬的用户您好，您于2016-05-17发布的项目【项目1234】没有通过审核，具体原因为:\n需求描述不清晰');
INSERT INTO `t61` VALUES ('18', '尊敬的用户您好，您于2015-04-08发布的项目【444项目名称YYY】没有通过审核，具体原因为:\n项目审核不通过不通过');
INSERT INTO `t61` VALUES ('19', '尊敬的用户您好，您于2015-04-08发布的项目【444项目名称ZZZ】没有通过审核，具体原因为:\n项目不通过不通过');
INSERT INTO `t61` VALUES ('20', '测试\r\n测试\r\n测试');
INSERT INTO `t61` VALUES ('21', '测试\r\n测试\r\n测试');
INSERT INTO `t61` VALUES ('22', '尊敬的用户您好，您于2015-04-08发布的项目【444项目名称YYY】没有通过审核，具体原因为:项目审核不通过不通过');
INSERT INTO `t61` VALUES ('23', '尊敬的用户您好，您于2015-04-08发布的项目【444项目名称YYY】没有通过审核，具体原因为:不通过不通过');
INSERT INTO `t61` VALUES ('24', '尊敬的用户您好，您于2015-04-08发布的项目【444项目名称ZZZ】没有通过审核，具体原因为:不通过不通过');
INSERT INTO `t61` VALUES ('25', '尊敬的用户您好，您于2015-04-08发布的项目【444项目名称ZZZ】没有通过审核，具体原因为:不通过\r\n不通过');
INSERT INTO `t61` VALUES ('26', '测试一下');

-- ----------------------------
-- Table structure for t70
-- ----------------------------
DROP TABLE IF EXISTS `t70`;
CREATE TABLE `t70` (
  `F01` int(11) DEFAULT NULL COMMENT '项目单',
  `F02` text COMMENT '企业评论分析师',
  `F03` float DEFAULT NULL COMMENT '评分'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='交易-评论表-企业评论分析师';

-- ----------------------------
-- Records of t70
-- ----------------------------
INSERT INTO `t70` VALUES ('9', '好好好好', '4.6');
INSERT INTO `t70` VALUES ('30', 'xxxxxxxxxxxxxxx', '5');

-- ----------------------------
-- Table structure for t71
-- ----------------------------
DROP TABLE IF EXISTS `t71`;
CREATE TABLE `t71` (
  `F01` int(11) DEFAULT NULL,
  `F02` text COMMENT '分析师评论企业',
  `F03` float DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='交易-评论表-分析师评论企业';

-- ----------------------------
-- Records of t71
-- ----------------------------
INSERT INTO `t71` VALUES ('9', 'fsdfsdfdsfdf', '2.6');

-- ----------------------------
-- Table structure for t80
-- ----------------------------
DROP TABLE IF EXISTS `t80`;
CREATE TABLE `t80` (
  `F01` int(11) NOT NULL AUTO_INCREMENT,
  `F02` varchar(50) DEFAULT NULL,
  `F03` varchar(100) DEFAULT NULL,
  `F04` varchar(100) DEFAULT NULL,
  `F05` timestamp NULL DEFAULT NULL,
  `F06` enum('XJ','SJ') DEFAULT NULL,
  `F07` enum('F','S') DEFAULT NULL,
  PRIMARY KEY (`F01`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COMMENT='广告管理';

-- ----------------------------
-- Records of t80
-- ----------------------------
INSERT INTO `t80` VALUES ('1', '/IMAGE/1464004684486.jpg', '广告', 'http://www.baidu.com', '2016-05-23 19:58:04', 'XJ', 'F');
INSERT INTO `t80` VALUES ('2', '/IMAGE/1464004871108.jpg', '广告', 'http://www.baidu.com', '2016-05-23 20:01:11', 'SJ', 'S');
INSERT INTO `t80` VALUES ('3', '/IMAGE/1464005033607.jpg', '广告', 'http://www.baidu.com', '2016-05-23 20:03:54', 'XJ', 'F');
INSERT INTO `t80` VALUES ('4', '/IMAGE/1464005106424.jpg', '广告', 'http://www.baidu.com', '2016-05-23 20:05:06', 'XJ', 'F');
INSERT INTO `t80` VALUES ('5', '/IMAGE/1464005191648.jpg', '广告4', 'http://www.baidu.com', '2016-05-23 20:06:32', 'XJ', 'F');
INSERT INTO `t80` VALUES ('6', '/IMAGE/1464010036423.jpg', '广告', 'http://www.baidu.com', '2016-05-23 21:27:16', 'SJ', 'F');
INSERT INTO `t80` VALUES ('7', '/IMAGE/1464010057757.jpg', '广告4', 'http://www.baidu.com', '2016-05-23 21:27:38', 'SJ', 'F');
INSERT INTO `t80` VALUES ('8', '/IMAGE/1464010076174.jpg', '广告5', 'http://www.baidu.com', '2016-05-23 21:27:56', 'SJ', 'F');
