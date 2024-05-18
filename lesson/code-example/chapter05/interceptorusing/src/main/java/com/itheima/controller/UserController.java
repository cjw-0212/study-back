package com.itheima.controller;

import com.itheima.po.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;

@Controller
public class UserController {
    @GetMapping("/login")   //向用户登录页面跳转
    public String toLogin() {
        return "login";
    }

    @GetMapping("/main") //向用户主页面跳转
    public String toMain() {
        return "main";
    }

    @GetMapping("/logout") //退出登录
    public String logout(HttpSession session) {
        session.invalidate();// 清除Session
        return "redirect:/login"; //重定向到登录页面的跳转方法
    }

    @PostMapping("/login")  //用户登录
    public String login(User user, Model model, HttpSession session) {
        String username = user.getUsername();
        String password = user.getPassword();
        // 此处模拟从数据库中获取用户名和密码后进行判断
        if (username != null && username.equals("xiaoxue")
                && password != null && password.equals("123456")) {
            session.setAttribute("user", user); // 将用户对象添加到Session
            return "redirect:/main";                // 重定向到主页面的跳转方法
        }
        model.addAttribute("msg", "用户名或密码错误，请重新登录！");
        return "login";
    }

}
