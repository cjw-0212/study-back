package com.example.springbootwebsocket.controller;

import com.example.springbootwebsocket.config.WebSocket1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author CJW
 * @since 2023/10/29
 */
@RestController
@RequestMapping("/websocketController")
public class WebsocketController {
    @Autowired
    private WebSocket1 webSocket1;

    @Scheduled(cron ="0/30 * * * * ?")
    @PostMapping("/jinDuTiao")
    public void jinDuTiao() throws InterruptedException {
        String msg = "";
        int a=0;
        for (int i = 0; i < 100; i++) {
            msg = String.valueOf(a);
            Thread.sleep(100);
            webSocket1.sendMessage(msg);
            a++;
        }
    }
}
