package com.example.springsecurity;

import com.example.springsecurity.mapper.MenuMapper;
import com.example.springsecurity.utils.JwtUtils;
import io.jsonwebtoken.Claims;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.Map;

@SpringBootTest
class SpringsecurityApplicationTests {
    @Autowired
    private MenuMapper menuMapper;

    @Test
    void contextLoads() {
        Map<String, Object> map = new HashMap<>();
        map.put("name", "cjw");
        map.put("age", 20);
        String jwt = JwtUtils.createJwt(map);
        Claims claims = JwtUtils.parseJwt(jwt);
        System.out.println(claims.get("name"));
        System.out.println(claims.get("age"));
    }

}
