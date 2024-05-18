package com.scst.controller;

import com.scst.feignclient.PaymentFeignClient;
import com.scst.feignclient.StockFeignClient;
import com.scst.service.OrderingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/ordering")
@RefreshScope
public class OrderingController {
    @Autowired
    private Environment environment;
    @Autowired
    private PaymentFeignClient paymentFeignClient;
    @Autowired
    private StockFeignClient stockFeignClient;
    @Autowired
    private OrderingService orderingService;

    @GetMapping("/configs")
    public String getConfigInfo() {
        String serverPort=environment.getProperty("server.port");
        //同一个微服务不同环境之间的共享配置
        String serviceShared=environment.getProperty("config.serviceshared");
        //同组中所有微服务的共享配置
        String allShared=environment.getProperty("config.allshared");
        return "服务端口："+serverPort+" 共享配置："+serviceShared+" / "+allShared;
    }

    @GetMapping("/purchase/{pid}/{aid}")
    public String purchase(@PathVariable("pid") String productId, @PathVariable("aid") String accountId) {
        String deductResult = stockFeignClient.deduct(productId);
        String payResult = paymentFeignClient.pay(accountId);
        boolean flag = orderingService.purchase(productId,accountId);
        return deductResult+payResult;
    }
}