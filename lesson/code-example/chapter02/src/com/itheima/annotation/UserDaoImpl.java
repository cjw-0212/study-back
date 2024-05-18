package com.itheima.annotation;

import org.springframework.stereotype.Repository;

//添加一个持久类的Bean实例
@Repository
public class UserDaoImpl implements UserDao {
    public void save() {
        System.out.println("userdao...save...");
    }
}
