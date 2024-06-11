package com.scst;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ProducersApplicationTests {

    @Test
    void contextLoads() {

    }

    public static void main(String[] args) {
        System.out.println("-Xms:"+Runtime.getRuntime().totalMemory()/1024/1024+"M");
        System.out.println("-Xmx:"+Runtime.getRuntime().maxMemory()/1024/1024+"M");
    }

}
