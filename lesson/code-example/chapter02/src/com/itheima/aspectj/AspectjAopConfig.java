package com.itheima.aspectj;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

//声明一个配置类
@Configuration
//通知Spring扫描指定包下所有类使用的注解
@ComponentScan("com.itheima.aspectj")
//开启Spring对AspectJ的支持
@EnableAspectJAutoProxy
public class AspectjAopConfig {
}
