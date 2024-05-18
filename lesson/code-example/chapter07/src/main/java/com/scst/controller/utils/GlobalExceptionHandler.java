package com.scst.controller.utils;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

//声明一个增强式控制器类
@RestControllerAdvice
public class GlobalExceptionHandler {
    //声明一个异常统一处理方法，用于拦截所有异常
    @ExceptionHandler(Exception.class)
    public R handleException(Exception ex) {
        //省略（记录日志，发送消息给运维，发送邮件给开发人员，ex对象发送给开发人员）
        ex.printStackTrace();
        return new R(false, "服务器故障，请稍后再试！");
    }
}
