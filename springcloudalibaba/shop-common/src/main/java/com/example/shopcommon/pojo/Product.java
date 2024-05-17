package com.example.shopcommon.pojo;

import lombok.Data;

/**
 * @author CJW
 * @since 2023/10/15
 */
@Data
public class Product {
    private Integer pid;
    private String pname;
    private Double pprice;
    private Integer stock;
}
