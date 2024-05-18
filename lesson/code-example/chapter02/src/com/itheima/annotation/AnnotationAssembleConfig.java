package com.itheima.annotation;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

//声明一个配置类
@Configuration
//通知Spring扫描指定包下所有Bean实例
@ComponentScan("com.itheima.annotation")
public class AnnotationAssembleConfig {
}
