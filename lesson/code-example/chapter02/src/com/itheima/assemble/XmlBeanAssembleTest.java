package com.itheima.assemble;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class XmlBeanAssembleTest {
    public static void main(String[] args) {
        // 定义配置文件路径
        String xmlPath = "com/itheima/assemble/autowirebeans.xml";
        // 加载配置文件
        ApplicationContext applicationContext =
                new ClassPathXmlApplicationContext(xmlPath);
        // 获取UserController1实例
        UserController userController1 =
                (UserController) applicationContext.getBean("userController1");
        userController1.save();
        // 获取userController2实例
        UserController userController2 =
                (UserController) applicationContext.getBean("userController2");
        userController2.save();
    }
}
