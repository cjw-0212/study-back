package com.scst.controller;

import com.scst.feignclient.AccountFeignClient;
import com.scst.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payment")
public class PaymentController {
    @Autowired
    private Environment environment;
    @Autowired
    private AccountFeignClient accountFeignClient;
    @Autowired
    private PaymentService paymentService;

    @GetMapping("/pay/{id}")
    public String pay(@PathVariable("id") String accountId) {
        String payResult=accountFeignClient.reduce(accountId);
        boolean flag = paymentService.pay(accountId);
        String serverPort=environment.getProperty("server.port");
        return payResult+" 支付服务端口："+serverPort;
    }
}