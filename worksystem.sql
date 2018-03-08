/*
SQLyog Professional v12.09 (64 bit)
MySQL - 5.7.17-log : Database - lingshi_worksystem
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`lingshi_worksystem` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `lingshi_worksystem`;

/*Table structure for table `questions` */

DROP TABLE IF EXISTS `questions`;

CREATE TABLE `questions` (
  `QuestionID` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '问题编号',
  `QuestionDesc` varchar(500) NOT NULL DEFAULT '' COMMENT '问题描述',
  `StudentID` bigint(20) NOT NULL COMMENT '学生编号',
  `TeacherID` bigint(20) NOT NULL COMMENT '老师编号',
  `QuestionAnswer` varchar(500) NOT NULL DEFAULT '' COMMENT '问题回答',
  `QuestionTime` datetime NOT NULL COMMENT '问题时间',
  `AnswerTime` datetime DEFAULT NULL COMMENT '回答时间',
  PRIMARY KEY (`QuestionID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `questions` */

insert  into `questions`(`QuestionID`,`QuestionDesc`,`StudentID`,`TeacherID`,`QuestionAnswer`,`QuestionTime`,`AnswerTime`) values (1,'测试提问',2,1,'你不是周杰伦，所以不告诉你','2018-03-05 16:18:33','2018-03-06 09:46:40'),(2,'测试问题',2,1,'测试个鬼，你又不是周杰伦','2018-03-06 14:07:47','2018-03-07 13:14:45');

/*Table structure for table `studentclass` */

DROP TABLE IF EXISTS `studentclass`;

CREATE TABLE `studentclass` (
  `StudentClassID` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '班级编号',
  `StudentClassName` varchar(20) NOT NULL DEFAULT '' COMMENT '班级名称',
  PRIMARY KEY (`StudentClassID`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

/*Data for the table `studentclass` */

insert  into `studentclass`(`StudentClassID`,`StudentClassName`) values (2,'三年2班'),(3,'三年3班'),(4,'三年1班');

/*Table structure for table `students` */

DROP TABLE IF EXISTS `students`;

CREATE TABLE `students` (
  `StudentID` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '学生编号',
  `StudentClassID` bigint(20) NOT NULL COMMENT '班级编号',
  `StudentIDCard` varchar(20) NOT NULL DEFAULT '' COMMENT '学生身份证',
  `StudentAge` int(11) NOT NULL DEFAULT '0' COMMENT '学生年龄',
  `StudentName` varchar(20) NOT NULL DEFAULT '' COMMENT '学生名字',
  `StudentSex` int(11) NOT NULL DEFAULT '0' COMMENT '学生性别',
  `StudentPwd` varchar(50) NOT NULL DEFAULT '' COMMENT '学生密码',
  PRIMARY KEY (`StudentID`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

/*Data for the table `students` */

insert  into `students`(`StudentID`,`StudentClassID`,`StudentIDCard`,`StudentAge`,`StudentName`,`StudentSex`,`StudentPwd`) values (2,2,'666',9,'周杰伦',1,'202CB962AC59075B964B07152D234B70'),(3,2,'777',9,'林俊杰',1,'202CB962AC59075B964B07152D234B70'),(4,4,'999',9,'洋子',0,'202CB962AC59075B964B07152D234B70');

/*Table structure for table `studentworkimgs` */

DROP TABLE IF EXISTS `studentworkimgs`;

CREATE TABLE `studentworkimgs` (
  `StudentWorkImgID` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `StudentWorkID` bigint(20) NOT NULL COMMENT '作业编号',
  `StudentWorkImgUrl` varchar(200) NOT NULL DEFAULT '' COMMENT '作业图路径',
  PRIMARY KEY (`StudentWorkImgID`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

/*Data for the table `studentworkimgs` */

insert  into `studentworkimgs`(`StudentWorkImgID`,`StudentWorkID`,`StudentWorkImgUrl`) values (9,5,'/Uploadfile/studentworks/LG77210380892410.png'),(14,6,'/Uploadfile/studentworks/LG79410401674510.png');

/*Table structure for table `studentworks` */

DROP TABLE IF EXISTS `studentworks`;

CREATE TABLE `studentworks` (
  `StudentWorkID` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '作业编号',
  `StudentID` bigint(20) NOT NULL COMMENT '学生编号',
  `TeacherID` bigint(20) DEFAULT NULL COMMENT '老师编号',
  `WorkID` bigint(20) NOT NULL COMMENT '作业编号',
  `WorkScore` int(11) DEFAULT NULL COMMENT '作业成绩',
  `WorkAssess` varchar(1000) DEFAULT '' COMMENT '作业评价',
  PRIMARY KEY (`StudentWorkID`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

/*Data for the table `studentworks` */

insert  into `studentworks`(`StudentWorkID`,`StudentID`,`TeacherID`,`WorkID`,`WorkScore`,`WorkAssess`) values (6,2,NULL,2,100,'不错');

/*Table structure for table `studydatas` */

DROP TABLE IF EXISTS `studydatas`;

CREATE TABLE `studydatas` (
  `StudyDataID` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '资料编号',
  `StudyDataUrl` varchar(200) NOT NULL DEFAULT '' COMMENT '资料路径',
  `StudyDataDesc` varchar(200) NOT NULL DEFAULT '' COMMENT '资料描述',
  PRIMARY KEY (`StudyDataID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `studydatas` */

/*Table structure for table `teacherclasses` */

DROP TABLE IF EXISTS `teacherclasses`;

CREATE TABLE `teacherclasses` (
  `StudentClassID` bigint(20) NOT NULL COMMENT '班级编号',
  `TeacherID` bigint(20) NOT NULL COMMENT '老师编号',
  `TeacherClassID` varchar(20) NOT NULL COMMENT '编号',
  PRIMARY KEY (`TeacherClassID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `teacherclasses` */

insert  into `teacherclasses`(`StudentClassID`,`TeacherID`,`TeacherClassID`) values (4,1,'LG26117251784510'),(3,2,'LG58817255258711'),(2,1,'LG75917255854312');

/*Table structure for table `teachers` */

DROP TABLE IF EXISTS `teachers`;

CREATE TABLE `teachers` (
  `TeacherID` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '老师编号',
  `TeacherIDCard` varchar(20) NOT NULL DEFAULT '' COMMENT '老师身份证',
  `TeacherName` varchar(20) NOT NULL DEFAULT '' COMMENT '老师名字',
  `TeacherAge` int(11) NOT NULL DEFAULT '0' COMMENT '老师年龄',
  `TeacherPwd` varchar(50) NOT NULL DEFAULT '' COMMENT '老师密码',
  `TeacherSex` int(11) NOT NULL DEFAULT '0' COMMENT '老师性别',
  `Remarks` varchar(20) NOT NULL DEFAULT '' COMMENT '备注',
  PRIMARY KEY (`TeacherID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `teachers` */

insert  into `teachers`(`TeacherID`,`TeacherIDCard`,`TeacherName`,`TeacherAge`,`TeacherPwd`,`TeacherSex`,`Remarks`) values (1,'123456789','小小',30,'202CB962AC59075B964B07152D234B70',0,''),(2,'1234567984','大大',50,'202CB962AC59075B964B07152D234B70',0,'');

/*Table structure for table `works` */

DROP TABLE IF EXISTS `works`;

CREATE TABLE `works` (
  `WorkID` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '作业编号',
  `StudentClassID` bigint(20) NOT NULL COMMENT '班级编号',
  `WorkUrl` varchar(200) NOT NULL DEFAULT '' COMMENT '作业路径',
  `WorkDesc` varchar(200) NOT NULL DEFAULT '' COMMENT '作业描述',
  `WorkCreateTime` datetime NOT NULL COMMENT '作业设置时间',
  `WorkCommitTime` datetime NOT NULL COMMENT '作业完成时间',
  `TeacherID` bigint(20) NOT NULL COMMENT '老师编号',
  PRIMARY KEY (`WorkID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*Data for the table `works` */

insert  into `works`(`WorkID`,`StudentClassID`,`WorkUrl`,`WorkDesc`,`WorkCreateTime`,`WorkCommitTime`,`TeacherID`) values (2,2,'/Uploadfile/works/LG32414153982311.docx','好好干','2018-03-05 14:15:51','2018-03-05 20:00:00',1),(3,4,'/Uploadfile/works/LG67914440029510.docx','这是一份过期的作业','2018-03-05 14:44:02','2018-03-04 00:00:00',1);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
