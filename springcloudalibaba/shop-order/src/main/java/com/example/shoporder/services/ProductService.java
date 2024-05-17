package com.example.shoporder.services;

import com.example.shopcommon.pojo.Product;
import com.example.shoporder.services.impl.ProductServiceFallBack;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author CJW
 * @since 2023/10/16
 */
@FeignClient(value = "service-product", fallback = ProductServiceFallBack.class)
public interface ProductService {
    @GetMapping("/product/{productId}")
    Product getOne(@PathVariable("productId") Integer productId);
}
