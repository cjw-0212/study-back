package com.scst.feignclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//调用account-service微服务客户端
@FeignClient(name = "account-service")
public interface AccountFeignClient {

    //调用reduce方法:http://[account-service address]/account/reduce/{id}
    @GetMapping("/account/reduce/{id}")
    public String reduce(@PathVariable("id") String accountId);
}
