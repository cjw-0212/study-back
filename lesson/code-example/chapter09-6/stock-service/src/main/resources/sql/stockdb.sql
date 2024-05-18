#创建数据库
CREATE DATABASE stockdb;
#选择使用数据库
USE stockdb;
#创建表t_stock并插入相关数据
DROP TABLE IF EXISTS t_stock;
create table t_stock
(
  id    int(20) auto_increment comment '记录id' primary key,
  p_id  varchar(200)  null comment '商品代码',
  count int(20) default '0' null comment '库存量',
  constraint p_id unique (p_id)
)charset = utf8;
insert into t_stock values ('1', 'p001', '1000');
insert into t_stock values ('2', 'p002', '2000');

DROP TABLE IF EXISTS `undo_log`;
CREATE TABLE `undo_log` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `branch_id` bigint(20) NOT NULL,
  `xid` varchar(100) NOT NULL,
  `context` varchar(128) NOT NULL,
  `rollback_info` longblob NOT NULL,
  `log_status` int(11) NOT NULL,
  `log_created` datetime NOT NULL,
  `log_modified` datetime NOT NULL,
  `ext` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `ux_undo_log` (`xid`,`branch_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;