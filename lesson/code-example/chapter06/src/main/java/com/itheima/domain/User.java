package com.itheima.domain;

import com.baomidou.mybatisplus.annotation.*;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.itheima.enums.SexEnum;
import lombok.Data;

import java.util.List;

@Data
public class User extends Model<User> {
    private Integer id;
    private String userName;
    //查询时不返回该字段的值. 插入数据时进行填充
    @TableField(select = false, fill = FieldFill.INSERT)
    private String password;
    private String name;
    private Integer age;
    //指定数据表中字段名
    @TableField(value = "email")
    private String mail;
    //乐观锁的版本字段
    @Version
    private Integer version;
    //逻辑删除字段 ，1-删除，0-未删除
    @TableLogic
    private Integer deleted;
    //性别，枚举类型
    private SexEnum sex;
    //数据库表中不存在相应字段
    @TableField(exist = false)
    private List<Comment> commentList;
}