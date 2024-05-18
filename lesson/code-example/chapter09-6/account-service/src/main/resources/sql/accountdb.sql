#创建数据库
CREATE DATABASE accountdb;
#选择使用数据库
USE accountdb;
#创建表t_account并插入相关数据
DROP TABLE IF EXISTS t_account;
create table t_account
(
  id      int(20) auto_increment comment '记录id' primary key,
  a_id    varchar(200) null comment '账户号码',
  balance float default '0' null comment '账户余额',
  constraint a_id unique (a_id)
)charset = utf8;
insert into t_account values ('1', 'a001', '1000');
insert into t_account values ('2', 'a002', '2000.5');

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