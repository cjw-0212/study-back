package com.scst.feignclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//调用payment-service微服务客户端
@FeignClient(name = "payment-service")
public interface PaymentFeignClient {
    //调用pay方法:http://[payment-service address]/payment/pay/{id}
    @GetMapping("/payment/pay/{id}")
    public String pay(@PathVariable("id") String accountId);
}
