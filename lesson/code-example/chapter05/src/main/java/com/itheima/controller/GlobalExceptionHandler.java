package com.itheima.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.thymeleaf.exceptions.TemplateProcessingException;

import java.sql.SQLException;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(value = Exception.class)
    public String handlerException(Model model, Exception e) {
        if (e instanceof SQLException) {
            System.out.println("数据库异常处理");
        } else if (e instanceof TemplateProcessingException) {
            System.out.println("模板引擎异常处理");
        } else {
            System.out.println("未知异常处理");
        }
        model.addAttribute("exc", e);
        return "errorhandler"; //在errorhandler.html视图页面中显示异常e信息

    }
}
