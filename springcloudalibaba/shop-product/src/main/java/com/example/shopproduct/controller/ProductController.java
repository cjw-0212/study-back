package com.example.shopproduct.controller;

import com.example.shopcommon.pojo.Product;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author CJW
 * @since 2023/10/16
 */
@RestController
@RequestMapping("/product")
public class ProductController {
    @GetMapping("/{productId}")
    public Product getOne(@PathVariable("productId") Integer productId) {
        Product product = new Product();
        product.setPid(productId);
        product.setPname("可口可乐");
        product.setPprice(3.0);
        product.setStock(100);
        return product;
    }
}
