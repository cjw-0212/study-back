package com.example.shopuser.controller;

import com.example.shopcommon.pojo.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author CJW
 * @since 2023/10/16
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @GetMapping("/{userId}")
    public User getOne(@PathVariable("userId") Integer userId) {
        User user = new User();
        user.setUid(userId);
        user.setUsername("陈佳炜");
        user.setPassword("123456");
        user.setTelephone("13794114925");
        return user;
    }
}
