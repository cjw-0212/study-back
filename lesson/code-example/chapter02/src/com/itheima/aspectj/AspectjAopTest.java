package com.itheima.aspectj;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AspectjAopTest {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext =
                new AnnotationConfigApplicationContext(AspectjAopConfig.class);
        System.out.println("获取UserDao类的Bean实例");
        UserDao userDao = applicationContext.getBean(UserDao.class);
        userDao.addUser();
        applicationContext.close();
    }
}
