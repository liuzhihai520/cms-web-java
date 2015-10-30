/*
SQLyog v10.2 
MySQL - 5.7.9-log : Database - cms
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`cms` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `cms`;

/*Table structure for table `t_sys_menu` */

DROP TABLE IF EXISTS `t_sys_menu`;

CREATE TABLE `t_sys_menu` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL COMMENT '菜单名',
  `parentId` bigint(11) DEFAULT NULL COMMENT '父ID',
  `resKey` varchar(20) DEFAULT NULL COMMENT 'resKey',
  `type` varchar(40) DEFAULT NULL COMMENT '1.目录2.菜单3.元素',
  `url` varchar(200) DEFAULT NULL COMMENT 'url',
  `level` int(4) DEFAULT NULL COMMENT '排序',
  `icon` varchar(20) DEFAULT NULL COMMENT '图标',
  `ishide` int(2) DEFAULT NULL COMMENT '1.显示 2隐藏',
  `description` varchar(50) DEFAULT NULL COMMENT '描述',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;

/*Data for the table `t_sys_menu` */

insert  into `t_sys_menu`(`id`,`name`,`parentId`,`resKey`,`type`,`url`,`level`,`icon`,`ishide`,`description`) values (3,'系统 & 设置',0,'system','1','system',0,'fa-desktop',1,'系统基础设置'),(4,'操作 & 日志',0,'log','1','log',0,'fa-book',1,'操作日志管理'),(17,'用户管理',3,'account','2','user/userList',0,'',1,'用户管理'),(18,'角色管理',3,'role','2','user/roleList',0,'',1,'角色管理'),(19,'菜单管理',3,'menu','2','sys/menusList',0,'',1,'菜单管理');

/*Table structure for table `t_sys_res_user` */

DROP TABLE IF EXISTS `t_sys_res_user`;

CREATE TABLE `t_sys_res_user` (
  `userId` bigint(11) NOT NULL COMMENT '用户ID',
  `resId` bigint(11) NOT NULL COMMENT '菜单ID',
  PRIMARY KEY (`userId`,`resId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_sys_res_user` */

/*Table structure for table `t_sys_role` */

DROP TABLE IF EXISTS `t_sys_role`;

CREATE TABLE `t_sys_role` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) DEFAULT NULL COMMENT '角色名称',
  `roleKey` varchar(20) DEFAULT NULL COMMENT 'roleKey',
  `status` int(2) DEFAULT NULL COMMENT '状态',
  `description` varchar(50) DEFAULT NULL COMMENT '描述',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

/*Data for the table `t_sys_role` */

insert  into `t_sys_role`(`id`,`name`,`roleKey`,`status`,`description`) values (7,'管理员','admin',2,'管理员'),(8,'普通用户','normal',1,'普通用户');

/*Table structure for table `t_sys_user` */

DROP TABLE IF EXISTS `t_sys_user`;

CREATE TABLE `t_sys_user` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(20) DEFAULT NULL COMMENT '用户名',
  `accountname` varchar(20) DEFAULT NULL COMMENT '称谓',
  `password` varchar(100) DEFAULT NULL COMMENT '密码',
  `salt` varchar(10) DEFAULT NULL COMMENT '盐',
  `status` int(2) DEFAULT NULL COMMENT '1.正常2.锁定',
  `createTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `description` varchar(100) DEFAULT NULL COMMENT '描述',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `t_sys_user` */

insert  into `t_sys_user`(`id`,`username`,`accountname`,`password`,`salt`,`status`,`createTime`,`description`) values (2,'管理员','admin','2E997EF34E1BD3AD6A0BCAF092FE9ABF','jt1d',1,'2015-10-26 21:36:59','管理员');

/*Table structure for table `t_sys_user_role` */

DROP TABLE IF EXISTS `t_sys_user_role`;

CREATE TABLE `t_sys_user_role` (
  `userId` bigint(11) NOT NULL COMMENT '用户ID',
  `roleId` bigint(11) NOT NULL COMMENT '角色ID',
  PRIMARY KEY (`userId`,`roleId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_sys_user_role` */

insert  into `t_sys_user_role`(`userId`,`roleId`) values (2,7);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
