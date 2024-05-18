package com.itheima.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.thymeleaf.exceptions.TemplateProcessingException;

import java.sql.SQLException;

@Controller
public class ExceptionController {
    @RequestMapping("/db")
    public void db() throws SQLException {
        throw new SQLException("数据库异常");
    }

    @RequestMapping("/template")
    public void template() throws TemplateProcessingException {
        throw new TemplateProcessingException("模板引擎异常");
    }

    @RequestMapping("/unknown")
    public void unknown() throws Exception {
        throw new Exception("未知异常");
    }
}
