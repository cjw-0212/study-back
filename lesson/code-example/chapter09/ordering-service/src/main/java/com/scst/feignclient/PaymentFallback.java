package com.scst.feignclient;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

//容错类，要求必须实现被容错的接口,并为每个方法实现容错方案
@Component
public class PaymentFallback implements PaymentFeignClient {
    @Override
    public String pay(String accountId){
        return "FeignClient调用payment-service微服务失败："+ HttpStatus.INTERNAL_SERVER_ERROR;
    }
}
