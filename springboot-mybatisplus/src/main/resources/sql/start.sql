create database if not exists mybatis_test
    default character set utf8;
use mybatis_test;


create table student
(
    id          bigint(20)       not null primary key comment '编号',
    name        varchar(20)      not null default '' comment '姓名',
    age         tinyint unsigned not null default 0 comment '年龄',
    address     varchar(200)     not null default '' comment '住址',
    is_deleted  tinyint          not null default 0 comment '逻辑删除字段',
    version     int unsigned     not null default 0 comment '乐观锁字段',
    create_time datetime         not null comment '插入时间',
    update_time datetime         not null comment '更新时间'
)
    comment '学生表';

