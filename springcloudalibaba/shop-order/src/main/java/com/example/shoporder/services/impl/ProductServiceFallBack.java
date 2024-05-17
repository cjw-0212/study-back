package com.example.shoporder.services.impl;

import com.example.shopcommon.pojo.Product;
import com.example.shoporder.services.ProductService;
import org.springframework.stereotype.Service;

/**
 * ProductServiceFeignClient调用的失败回滚类
 *
 * @author CJW
 * @since 2023/10/16
 */
@Service
public class ProductServiceFallBack implements ProductService {
    @Override
    public Product getOne(Integer productId) {
        Product product = new Product();
        product.setPname("失败回调");
        return product;
    }
}
