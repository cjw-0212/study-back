package com.scst.feignclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//调用stock-service微服务客户端
@FeignClient(name = "stock-service")
public interface StockFeignClient {

    //调用deduct方法:http://[stock-service address]/stock/deduct/{id}
    @GetMapping("/stock/deduct/{id}")
    public String deduct(@PathVariable("id") String productId);
}
