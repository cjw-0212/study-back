package com.itheima.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

//添加一个控制器类的Bean实例
@Controller
public class UserController {
    private UserService userService;

    //使用属性构造自动注入方式
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    public void save() {
        this.userService.save();
        System.out.println("userController...save...");
    }
}
