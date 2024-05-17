package com.example.springbootjwt.controller;

import com.example.springbootjwt.utils.JwtUtils;
import com.example.springbootjwt.utils.Result;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * @author CJW
 * @since 2023/9/19
 */
@RestController
@RequestMapping("/user")
public class LoginController {
    @PostMapping("/login")
    public Result<String> login(@RequestParam String name) {
        if (name.equals("cjw")) {
            Map<String, Object> claims = new HashMap<>();
            claims.put("name", name);
            String token = JwtUtils.generateJwt(claims);
            return Result.success(token);
        }
        return Result.error("用户名或密码错误");
    }

    @GetMapping("/info")
    public Result<String> getInfo() {
        return Result.success("哈哈");
    }
}
