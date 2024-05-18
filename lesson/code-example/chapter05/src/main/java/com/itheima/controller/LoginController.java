package com.itheima.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.Calendar;

@Controller
public class LoginController {
    //跳转到登录页login.html
    @GetMapping("/toLoginPage")
    public String toLoginPage() {
        return "login";
    }

    @ModelAttribute("currentYear")
    public int getCurrentYear() {
        return Calendar.getInstance().get(Calendar.YEAR);
    }

    @ModelAttribute("institute")
    public String getInstitute() {
        return "广东财经大学";
    }

}
