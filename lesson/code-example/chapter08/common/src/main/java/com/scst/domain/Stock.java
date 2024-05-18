package com.scst.domain;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class Stock {
    private String productId = "NO005";
    private String productName = "苹果";
    private Integer stockNum = 100;        //初始库存量
}
