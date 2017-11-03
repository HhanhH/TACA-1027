/*
Navicat MySQL Data Transfer

Source Server         : 47.90.120.141
Source Server Version : 50719
Source Host           : 47.90.120.141:3306
Source Database       : TACA

Target Server Type    : MYSQL
Target Server Version : 50719
File Encoding         : 65001

Date: 2017-11-03 10:31:36
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `IM_B_GOODS_INFO`
-- ----------------------------
DROP TABLE IF EXISTS `IM_B_GOODS_INFO`;
CREATE TABLE `IM_B_GOODS_INFO` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `TYPE` varchar(10) DEFAULT NULL,
  `CATEGORY` varchar(10) DEFAULT NULL,
  `NAME` varchar(100) DEFAULT NULL,
  `STAR_NUMBER` bigint(20) DEFAULT NULL,
  `DESCRIPTION` text,
  `ICON_ADDRESS` varchar(100) DEFAULT NULL,
  `STATUS` varchar(10) DEFAULT NULL,
  `COUNT` bigint(20) DEFAULT NULL,
  `AVAILABLE_STOCK` bigint(20) DEFAULT NULL,
  `CREATE_TIME` datetime DEFAULT NULL,
  `UPDATE_TIME` datetime DEFAULT NULL,
  `STAR_LEVEL` bigint(10) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of IM_B_GOODS_INFO
-- ----------------------------

-- ----------------------------
-- Table structure for `IM_B_HONOR_TITLE`
-- ----------------------------
DROP TABLE IF EXISTS `IM_B_HONOR_TITLE`;
CREATE TABLE `IM_B_HONOR_TITLE` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `TITLE` varchar(100) DEFAULT NULL,
  `STAR_NUMBER` bigint(20) DEFAULT NULL,
  `CREATE_TIME` datetime DEFAULT NULL,
  `UPDATE_TIME` datetime DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of IM_B_HONOR_TITLE
-- ----------------------------



-- ----------------------------
-- Table structure for `IM_B_NOTICE_INFO`
-- ----------------------------
DROP TABLE IF EXISTS `IM_B_NOTICE_INFO`;
CREATE TABLE `IM_B_NOTICE_INFO` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `TITLE` varchar(100) DEFAULT NULL,
  `CONTENT` text,
  `ICON_ADDRESS` varchar(100) DEFAULT NULL,
  `STATUS` varchar(10) DEFAULT NULL,
  `CREATE_TIME` datetime DEFAULT NULL,
  `UPDATE_TIME` datetime DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of IM_B_NOTICE_INFO
-- ----------------------------

-- ----------------------------
-- Table structure for `IM_B_TASK_INFO`
-- ----------------------------
DROP TABLE IF EXISTS `IM_B_TASK_INFO`;
CREATE TABLE `IM_B_TASK_INFO` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `TYPE` varchar(10) DEFAULT NULL,
  `NAME` varchar(100) DEFAULT NULL,
  `CONTENT` text,
  `ICON_ADDRESS` varchar(100) DEFAULT NULL,
  `STAR_LEVEL` bigint(20) DEFAULT NULL,
  `STAR_PROFIT` bigint(20) DEFAULT NULL,
  `TIME_LENGTH` bigint(10) DEFAULT NULL,
  `STATUS` varchar(10) DEFAULT NULL,
  `AVAILABLE_STOCK` bigint(20) DEFAULT NULL,
  `PERSON_AVAILABLE_STOCK` bigint(20) DEFAULT NULL,
  `FEEDBACK_WAY` text,
  `COUNT` bigint(20) DEFAULT NULL,
  `CATEGORY` varchar(10) DEFAULT NULL,
  `CREATE_TIME` datetime DEFAULT NULL,
  `UPDATE_TIME` datetime DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of IM_B_TASK_INFO
-- ----------------------------

-- ----------------------------
-- Table structure for `IM_B_TASK_MUTEX`
-- ----------------------------
DROP TABLE IF EXISTS `IM_B_TASK_MUTEX`;
CREATE TABLE `IM_B_TASK_MUTEX` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `TASK_FIRST_ID` bigint(20) NOT NULL,
  `TASK_SECOND_ID` bigint(20) NOT NULL,
  `CREATE_TIME` datetime DEFAULT NULL,
  `UPDATE_TIME` datetime DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of IM_B_TASK_MUTEX
-- ----------------------------

-- ----------------------------
-- Table structure for `IM_D_RECEIVE_TASK`
-- ----------------------------
DROP TABLE IF EXISTS `IM_D_RECEIVE_TASK`;
CREATE TABLE `IM_D_RECEIVE_TASK` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `TASK_ID` bigint(20) DEFAULT NULL,
  `USER_NAME` varchar(20) DEFAULT NULL,
  `NAME` varchar(100) DEFAULT NULL,
  `CONTENT` text,
  `ACT_STAR_NUMBER` bigint(20) DEFAULT NULL,
  `PRE_STAR_NUMBER` bigint(20) DEFAULT NULL,
  `STATUS` varchar(10) DEFAULT NULL,
  `TRANS_ID` bigint(20) NOT NULL,
  `START_TIME` datetime DEFAULT NULL,
  `EXPECTED_TIME` datetime DEFAULT NULL,
  `FINISHED_TIME` datetime DEFAULT NULL,
  `CREATE_TIME` datetime DEFAULT NULL,
  `UPDATE_TIME` datetime DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of IM_D_RECEIVE_TASK
-- ----------------------------

-- ----------------------------
-- Table structure for `IM_D_SHOPPING`
-- ----------------------------
DROP TABLE IF EXISTS `IM_D_SHOPPING`;
CREATE TABLE `IM_D_SHOPPING` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `USERNAME` varchar(20) DEFAULT NULL,
  `GOODS_ID` bigint(20) NOT NULL,
  `NAME` varchar(100) DEFAULT NULL,
  `CONTENT` text,
  `STAR_NUMBER` bigint(20) DEFAULT NULL,
  `STATUS` varchar(10) DEFAULT NULL,
  `MESSAGE` varchar(100) DEFAULT NULL,
  `TRANS_ID` bigint(20) NOT NULL,
  `START_TIME` datetime DEFAULT NULL,
  `FINISH_TIME` datetime DEFAULT NULL,
  `CREATE_TIME` datetime DEFAULT NULL,
  `UPDATE_TIME` datetime DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of IM_D_SHOPPING
-- ----------------------------

-- ----------------------------
-- Table structure for `IM_D_SUBMISSIONS`
-- ----------------------------
DROP TABLE IF EXISTS `IM_D_SUBMISSIONS`;
CREATE TABLE `IM_D_SUBMISSIONS` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `RECEIVE_TASK_ID` bigint(20) NOT NULL,
  `RECEIVE_BOOK` varchar(100) DEFAULT NULL,
  `FILE_ADDRESS` varchar(100) DEFAULT NULL,
  `STATUS` varchar(100) DEFAULT NULL,
  `MESSAGE` text,
  `CREATE_TIME` datetime DEFAULT NULL,
  `UPDATE_TIME` datetime DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of IM_D_SUBMISSIONS
-- ----------------------------

-- ----------------------------
-- Table structure for `IM_D_TRANS_RECORD`
-- ----------------------------
DROP TABLE IF EXISTS `IM_D_TRANS_RECORD`;
CREATE TABLE `IM_D_TRANS_RECORD` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `USERNAME` varchar(20) DEFAULT NULL,
  `STAR_NUMBER` bigint(20) DEFAULT NULL,
  `STATUS` varchar(10) DEFAULT NULL,
  `START_TIME` datetime DEFAULT NULL,
  `FINISHED_TIME` datetime DEFAULT NULL,
  `CREATE_TIME` datetime DEFAULT NULL,
  `UPDATE_TIME` datetime DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of IM_D_TRANS_RECORD
-- ----------------------------

-- ----------------------------
-- Table structure for `IM_D_USER_INFO`
-- ----------------------------
DROP TABLE IF EXISTS `IM_D_USER_INFO`;
CREATE TABLE `IM_D_USER_INFO` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `USER_NAME` varchar(20) DEFAULT NULL,
  `NICK_NAME` varchar(100) DEFAULT NULL,
  `ICON_ADDRESS` varchar(100) DEFAULT NULL,
  `USER_NAME_CN` varchar(10) DEFAULT NULL,
  `PASSWORD` varchar(100) DEFAULT NULL,
  `WX_OPEN_ID` varchar(100) DEFAULT NULL,
  `AVAILABLE_STAR` bigint(20) DEFAULT NULL,
  `EMAIL_ADDRESS` varchar(100) DEFAULT NULL,
  `FREEZE_STAR` bigint(20) DEFAULT NULL,
  `HISTORY_STAR` bigint(20) DEFAULT NULL,
  `GROUP_ID` bigint(20) DEFAULT NULL,
  `GROUP_NAME` varchar(100) DEFAULT NULL,
  `HONOR_TITLE` varchar(20) DEFAULT NULL,
  `UM` varchar(20) DEFAULT NULL,
  `STATUS` varchar(20) DEFAULT NULL,
  `CREATE_TIME` datetime DEFAULT NULL,
  `UPDATE_TIME` datetime DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of IM_D_USER_INFO
-- ----------------------------
