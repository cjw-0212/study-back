package com.itheima.controller;

import com.itheima.domain.User;
import com.itheima.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PagingController {
    @Autowired
    private UserService userService;

    //跳转到分页模板页pages.html
    @GetMapping("/toPaging")
    public String toPaging(Model model,
                           @RequestParam(value = "pageNum", defaultValue = "0") int pageNum,
                           @RequestParam(value = "pageSize", defaultValue = "5") int pageSize) {
        Page<User> users = userService.getUserPage(pageNum, pageSize);
        model.addAttribute("users", users);
        return "pages";
    }
}
