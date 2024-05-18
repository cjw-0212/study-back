package com.scst.controller;

import com.scst.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/stock")
public class StockController {
    @Autowired
    private StockService stockService;

    @GetMapping("/deduct/{id}")
    public String deduct(@PathVariable("id") String productId) {
        boolean flag = stockService.deduct(productId);
        return "商品号："+productId+"，库存减扣成功！";
    }
}