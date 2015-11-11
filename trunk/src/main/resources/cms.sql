/*
SQLyog v10.2 
MySQL - 5.6.16 : Database - ruijiutou
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`ruijiutou` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `ruijiutou`;

/*Table structure for table `t_sys_menu` */

DROP TABLE IF EXISTS `t_sys_menu`;

CREATE TABLE `t_sys_menu` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL COMMENT '菜单名',
  `parentId` bigint(11) DEFAULT NULL COMMENT '父ID',
  `resKey` varchar(50) DEFAULT NULL COMMENT 'resKey',
  `type` varchar(40) DEFAULT NULL COMMENT '1.目录2.菜单3.元素',
  `url` varchar(200) DEFAULT NULL COMMENT 'url',
  `level` int(4) DEFAULT NULL COMMENT '排序',
  `icon` varchar(20) DEFAULT '' COMMENT '图标',
  `ishide` int(2) DEFAULT NULL COMMENT '1.显示 2隐藏',
  `description` varchar(50) DEFAULT NULL COMMENT '描述',
  `parent_ids` varchar(200) DEFAULT NULL COMMENT 'id序列',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=59 DEFAULT CHARSET=utf8;

/*Data for the table `t_sys_menu` */

insert  into `t_sys_menu`(`id`,`name`,`parentId`,`resKey`,`type`,`url`,`level`,`icon`,`ishide`,`description`,`parent_ids`) values (1,'系统 & 设置',0,'system:*','1','',0,'fa-desktop',1,'系统基础设置','0'),(2,'用户管理',1,'user:userList','1','user/userList',0,'',1,'用户管理','0/1'),(3,'添加用户',2,'user:add','3','user/addUser',0,'',1,'添加用户','0/1/2'),(4,'更新用户',2,'user:update','3','user/updateUser',0,'',1,'更新用户','0/1/2'),(5,'删除用户',2,'user:delete','3','user/deleteUser',0,'',1,'删除用户','0/1/2'),(6,'角色管理',1,'role:roleList','1','role/roleList',0,'',1,'角色管理','0/1'),(7,'添加角色',6,'role:roleList','3','role/roleList',0,'',1,'添加角色','0/1/6'),(8,'更新角色',6,'role:updateRole','3','role/updateRole',0,'',1,'修改角色','0/1/6'),(9,'删除角色',6,'role:delete','3','role/deleteRole',0,'',1,'删除角色','0/1/6'),(10,'菜单管理',1,'menu:menusList','1','menu/menusList',0,'',1,'菜单管理','0/1'),(11,'添加菜单',10,'menu:add','3','menu/addMenu',0,'',1,'添加菜单','0/1/10'),(12,'角色权限查看',10,'menu:roleRootList','3','menu/roleRootList',0,'',1,'角色权限查看','0/1/10'),(13,'角色授权',10,'menu:roleRoot','3','menu/roleRoot',0,'',1,'角色授权','0/1/10'),(14,'查看菜单',10,'menu:menu','3','menu/menu',0,'',1,'查看菜单','0/1/10'),(15,'更新菜单',10,'menu:update','3','menu/updateMenu',0,'',1,'更新菜单','0/1/10'),(16,'删除菜单',10,'menu:delete','3','menu/deleteMenu',0,'',1,'删除菜单','0/1/10'),(37,'类型管理',1,'type:typeList','2','type/typeList',0,'',1,'类型管理','0/1'),(38,'新增类型',37,'type:add','3','type/addType',0,'',1,'新增类型','0/1/37'),(39,'更新类型',37,'type:update','3','type/updateType',0,'',1,'更新类型','0/1/37'),(40,'删除类型',37,'type:delete','3','type/deleteType',0,'',1,'删除类型','0/1/37'),(41,'Banner管理',0,'banner:bannerList','1','banner/bannerList',0,'fa-film',1,'Banner管理','0/41'),(42,'添加Banner',41,'banner:add','3','banner/addBanner',0,'',1,'添加Banner','0/41/42'),(43,'查看Banner',41,'banner:look','3','banner/lookBanner',0,'',1,'查看Banner','0/41/43'),(44,'更新Banner',41,'banner:update','3','banner/update',0,'',1,'更新Banner','0/41/44'),(45,'删除Banner',41,'banner:delete','3','banner/delete',0,'',1,'删除Banner','0/41/45'),(46,'查看类型',37,'type:type','3','type/type',0,'',1,'查看类型','0/1/37'),(47,'合作&友情管理',0,'partners:partnersList','1','partners/partnersList',0,'fa-users',1,'合作伙伴和友情链接管理','null/0'),(48,'查看合作友情',47,'partners:partners','3','partners/partners',0,'',1,'查看合作伙伴和友情链接','null/0/47'),(49,'新增合作&友情',47,'partners:addPartners','3','partners/addPartners',0,'',1,'新增活动伙伴和友情链接','null/0/47'),(51,'更新合作或友情',47,'partners:updatePartners','3','partners/updatePartners',0,'',1,'更新合作或友情','null/0/47'),(52,'删除合作&友情',47,'partners:deletePartners','3','partners/deletePartners',0,'',1,'删除合作&友情','null/0'),(53,'资讯管理',0,'news:newsList','1','news/newsList',0,'fa-bullhorn',1,'新闻资讯管理','null/0'),(54,'新增新闻',53,'news:addnews','3','news/addNews',0,'',1,'新增新闻','null/0/53'),(55,'注册用户管理',0,'member:memberList','1','member/memberList',0,'fa-users',1,'注册用户管理','null/0'),(56,'查看用户',55,'member:look','3','member/look',0,'',1,'查看用户','null/0/55'),(57,'用户审核',55,'member:check','3','member/check',0,'',1,'用户审核','null/0/55'),(58,'锁定用户',55,'member:lock','3','member/lock',0,'',1,'锁定用户','null/0/55');

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
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

/*Data for the table `t_sys_role` */

insert  into `t_sys_role`(`id`,`name`,`roleKey`,`status`,`description`) values (1,'管理员','admin',1,'管理员');

/*Table structure for table `t_sys_role_res` */

DROP TABLE IF EXISTS `t_sys_role_res`;

CREATE TABLE `t_sys_role_res` (
  `roleId` bigint(11) NOT NULL COMMENT '角色ID',
  `resId` bigint(11) NOT NULL COMMENT '菜单ID',
  PRIMARY KEY (`roleId`,`resId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_sys_role_res` */

insert  into `t_sys_role_res`(`roleId`,`resId`) values (1,1),(1,2),(1,3),(1,4),(1,5),(1,6),(1,7),(1,8),(1,9),(1,10),(1,11),(1,12),(1,13),(1,14),(1,15),(1,16),(1,37),(1,38),(1,39),(1,40),(1,41),(1,42),(1,43),(1,44),(1,45),(1,46),(1,47),(1,48),(1,49),(1,51),(1,52),(1,53),(1,54),(1,55),(1,56),(1,57),(1,58);

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
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

/*Data for the table `t_sys_user` */

insert  into `t_sys_user`(`id`,`username`,`accountname`,`password`,`salt`,`status`,`createTime`,`description`) values (1,'管理员','admin','102dccdb7330746348c46d96468ee2df','jt1d',1,'2015-11-04 09:38:14','管理员');

/*Table structure for table `t_sys_user_role` */

DROP TABLE IF EXISTS `t_sys_user_role`;

CREATE TABLE `t_sys_user_role` (
  `userId` bigint(11) NOT NULL COMMENT '用户ID',
  `roleId` bigint(11) NOT NULL COMMENT '角色ID',
  PRIMARY KEY (`userId`,`roleId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_sys_user_role` */

insert  into `t_sys_user_role`(`userId`,`roleId`) values (1,1);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
