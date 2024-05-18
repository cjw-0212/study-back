package com.itheima.aspectj;

import org.springframework.stereotype.Repository;

//添加一个持久类的Bean实例
@Repository
public class UserDaoImpl implements UserDao {
    public void addUser() {
        System.out.println("添加用户");
    }

    public void deleteUser() {
        System.out.println("删除用户");
    }
}
