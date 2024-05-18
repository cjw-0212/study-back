package com.itheima.annotation;

import com.itheima.aspectj.AspectjAopConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AnnotationAssembleTest {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext =
                new AnnotationConfigApplicationContext(AnnotationAssembleConfig.class);
        //获取UserController类的Bean实例
        System.out.println("获取UserController类的Bean实例");
        UserController userController = applicationContext.getBean(UserController.class);
        userController.save();
        //获取UserService类的Bean实例
        System.out.println("获取UserService类的Bean实例");
        UserService userService = applicationContext.getBean(UserService.class);
        userService.save();
    }
}  
