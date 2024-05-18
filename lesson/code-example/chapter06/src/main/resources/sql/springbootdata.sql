#创建数据库
#CREATE DATABASE springbootdata;
#选择使用数据库
USE springbootdata;
#创建表t_article并插入相关数据
DROP TABLE IF EXISTS t_article;
CREATE TABLE t_article (
  id      int(20) NOT NULL AUTO_INCREMENT
  COMMENT '文章id',
  title   varchar(200)     DEFAULT NULL
  COMMENT '文章标题',
  content longtext COMMENT '文章内容',
  PRIMARY KEY (id)
)
  ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = utf8;
insert into t_article
values ('1', 'Spring Boot基础入门', '从入门到精通讲解...');
insert into t_article
values ('2', 'Spring Cloud基础入门', '从入门到精通讲解...');
#创建表t_comment并插入相关数据
drop table if exists t_comment;
create table t_comment (
  id      int(20) not null auto_increment
  comment '评论id',
  content longtext comment '评论内容',
  u_id    int(20)          default null
  comment '评论用户',
  a_id    int(20)          default null
  comment '关联的文章id',
  primary key (id)
)
  engine = InnoDB
  auto_increment = 3
  default charset = utf8;
insert into t_comment
values ('1', '很全、很详细', '1', '1');
insert into t_comment
values ('2', '赞一个', '2', '1');
insert into t_comment
values ('3', '很详细', '4', '1');
insert into t_comment
values ('4', '很好、非常详细', '3', '1');
insert into t_comment
values ('5', '很不错', '5', '2');
#创建表t_user并插入相关数据
drop table if exists t_user;
CREATE TABLE t_user (
  id        bigint(20)  NOT NULL AUTO_INCREMENT
  COMMENT '主键ID',
  user_name varchar(20) NOT NULL
  COMMENT '用户名',
  password  varchar(20) NOT NULL
  COMMENT '密码',
  name      varchar(30)          DEFAULT NULL
  COMMENT '姓名',
  age       int(10)              DEFAULT NULL
  COMMENT '年龄',
  email     varchar(50)          DEFAULT NULL
  COMMENT '邮箱',
  PRIMARY KEY (id)
)
  ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = utf8;
INSERT INTO t_user
VALUES ('1', 'zhangsan', '123456', '张三', '18', 'test1@itcast.cn');
INSERT INTO t_user
VALUES ('2', 'lisi', '123456', '李四', '20', 'test2@itcast.cn');
INSERT INTO t_user
VALUES ('3', 'wangwu', '123456', '王五', '28', 'test3@itcast.cn');
INSERT INTO t_user
VALUES ('4', 'zhaoliu', '123456', '赵六', '21', 'test4@itcast.cn');
INSERT INTO t_user
VALUES ('5', 'sunqi', '123456', '孙七', '24', 'test5@itcast.cn');
ALTER TABLE t_user
  ADD COLUMN version int(10) NULL DEFAULT 1
COMMENT '乐观锁版本字段'
  AFTER email;
UPDATE t_user
SET version = '1';
ALTER TABLE t_user
  ADD COLUMN deleted int(1) NULL DEFAULT 0
COMMENT '1-被删除，0-未被删除'
  AFTER version;
UPDATE t_user
SET deleted = '0';
ALTER TABLE t_user
  ADD COLUMN sex int(1) NULL DEFAULT 1
COMMENT '1-男，2-女'
  AFTER deleted;
UPDATE t_user
SET sex = '1';