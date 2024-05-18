package com.itheima;

import com.itheima.controller.HelloController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Chapter03ApplicationTests {

    @Test
    void contextLoads() {
    }

    @Autowired
    private HelloController helloController;

    @Test
    public void helloControllerTest() {
        String hello = helloController.hello();
        System.out.println(hello);
    }


}
