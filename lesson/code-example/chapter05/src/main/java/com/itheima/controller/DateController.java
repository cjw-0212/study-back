package com.itheima.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;

@Controller
public class DateController {

    //使用自定义转换器绑定日期数据
    @RequestMapping("/customDate")
    public String CustomDate(Date date) {
        System.out.println("date=" + date);
        return "login";
    }
}
