/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

/*Table structure for table `tb_passage` */

DROP TABLE IF EXISTS `tb_passage`;

CREATE TABLE `tb_passage` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '博客表主键id',
  `userId` bigint(20) NOT NULL COMMENT '博客作者id',
  `title` varchar(200) NOT NULL COMMENT '博客标题',
  `content` mediumtext NOT NULL COMMENT '博客内容',
  `createTime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '添加时间',
  `recentEditTime` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间',
  `status` int(11) NOT NULL COMMENT '博客状态 0草稿1公开显示2不公开显示',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `tb_passage` */

insert into `tb_passage`(`id`,`userId`,`title`,`content`,`createTime`,`recentEditTime`,`status`) values (2,1,'震惊！某高校寒假居然长达八个月！原因竟然是。。','寒假是指冬季1-2月份期间的假期。
在中国，学校通常将每个学年分为上、下两个学期。上学期从秋季九月份开始，到农历腊月初十左右，各学校开始放假，至元宵节后寒假结束。而这个时候正处于中国寒冷的冬季，交‘九’之际，被称为寒假。假期一般1个月左右。但在寒冷的中国东北地区及其他高纬度地区，有时多达45天左右，多者甚至会两个月左右。','2017-03-12 00:31:15','2018-11-12 00:31:15',1);

DROP TABLE IF EXISTS `tb_comment`;

CREATE TABLE `tb_comment` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '评论Id',
  `passageId` bigint(20) NOT NULL COMMENT '对应文章Id',
  `userId` bigint(20) NOT NULL COMMENT '评论者Id',
  `content` mediumtext NOT NULL COMMENT '评论内容',
  `userName` varchar(255) NOT NULL COMMENT '用户id',
  `commentTime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '评论时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

insert into `tb_comment`(`id`,`passageId`,`userId`,`content`,`commentTime`) values(1,2,1,'天哪！你说的是真的嘛！这头也太大了吧！','2018-11-12 00:31:15');

DROP TABLE IF EXISTS `tb_User`;

CREATE TABLE `tb_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '用户Id',
  `email` varchar(200) NOT NULL COMMENT '邮箱',
  `password` varchar(200) NOT NULL COMMENT '密码',
  `userName` varchar(200) NOT NULL COMMENT '用户名',
  `description` varchar(200) DEFAULT NULL COMMENT '个人简介',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

insert into `tb_user`(`id`,`email`,`password`,`userName`,`description`) values(0,'9959@qq.com','4527c9b5fc3955d911b2df21c81f4563','ljy','');

DROP TABLE IF EXISTS `tb_collection`;

CREATE TABLE `tb_collection` (
  `userId` int(20) NOT NULL COMMENT '用户id',
  `passageId` int(20) NOT NULL COMMENT '文章id',
  `collectTime` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '收藏时间'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `tb_friendurl`;

CREATE TABLE `tb_friendurl` (
                                 `userId` int(20) NOT NULL COMMENT '用户id',
                                 `url` varchar(255) NOT NULL COMMENT '链接',
                                 PRIMARY KEY (`userId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
