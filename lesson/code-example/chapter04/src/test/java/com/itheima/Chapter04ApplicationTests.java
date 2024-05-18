package com.itheima;

import com.itheima.domain.Person;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

@SpringBootTest
class Chapter04ApplicationTests {

    @Autowired
    private Person person;

    @Test
    public void personTest() {
        System.out.println(person);
    }

    @Autowired
    private ApplicationContext applicationContext;

    @Test
    public void iocTest() {
        System.out.println(applicationContext.containsBean("myService"));
    }
}
