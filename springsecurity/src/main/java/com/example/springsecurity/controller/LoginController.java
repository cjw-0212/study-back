package com.example.springsecurity.controller;

import com.example.springsecurity.pojo.User;
import com.example.springsecurity.service.LoginService;
import com.example.springsecurity.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author CJW
 * @since 2023/10/25
 */
@RestController
@RequestMapping("/user")
public class LoginController {
    @Autowired
    private LoginService loginService;

    @PostMapping("/login")
    public Result<String> login(@RequestBody User user) {
        return loginService.login(user);
    }

    @PostMapping("/logout")
    public Result<String> logout() {
        return loginService.logout();
    }
}
