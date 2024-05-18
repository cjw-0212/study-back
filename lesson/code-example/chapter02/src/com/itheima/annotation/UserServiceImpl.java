package com.itheima.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//添加一个业务类的Bean实例
@Service
public class UserServiceImpl implements UserService {
    //使用属性设值自动注入方式
    @Autowired
    private UserDao userDao;

    public void save() {
        this.userDao.save();
        System.out.println("userservice....save...");
    }
}
