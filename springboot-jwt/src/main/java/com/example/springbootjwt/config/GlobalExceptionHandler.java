package com.example.springbootjwt.config;

import com.example.springbootjwt.utils.Result;
//指定异常处理器处理的异常类型
import org.springframework.web.bind.annotation.ExceptionHandler;
//代表该类是全局统一异常处理器
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 全局统一异常处理
 *
 * @author CJW
 * @since 2023/9/20
 */
@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(Exception.class)
    public Result exceptionHandler(Exception e) {
        e.printStackTrace();
        return Result.error("对不起，操作失败，请联系管理员处理");
    }
}
