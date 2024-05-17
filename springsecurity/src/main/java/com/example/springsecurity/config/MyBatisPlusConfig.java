package com.example.springsecurity.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author CJW
 */
@Configuration
@MapperScan("com.example.springsecurity.mapper")
public class MyBatisPlusConfig {

}
