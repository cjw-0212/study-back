package com.example.springbootredis;

import com.example.springbootredis.pojo.User;
import com.example.springbootredis.util.RedisUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringbootRedisApplicationTests {
    @Autowired
    private RedisUtils redisUtil;
    @Test
    void contextLoads() {
        //User user=new User("陈佳炜",20,new Address("广东","汕头"));
        User user = (User) redisUtil.getObject("user", User.class);
        System.out.println(user);
    }
}
