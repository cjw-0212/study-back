package com.example.springbootredis.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author CJW
 * @since 2023/10/28
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Address {
    String province;
    String city;
}
