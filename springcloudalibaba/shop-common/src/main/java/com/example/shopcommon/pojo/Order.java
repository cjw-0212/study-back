package com.example.shopcommon.pojo;

import lombok.Data;

/**
 * @author CJW
 * @since 2023/10/15
 */
@Data
public class Order {
    private Integer oid;
    private User user;
    private Product product;
}
