package com.scst.controller;

import com.scst.service.SecKillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SecKillController {
    @Autowired
    private SecKillService secKillService;
    private String topic = "order-topic";
    private String tag = "TagA";

    @GetMapping("/seckill")
    public void seckill() throws Exception{
        secKillService.secKill(topic, tag);
    }
}
