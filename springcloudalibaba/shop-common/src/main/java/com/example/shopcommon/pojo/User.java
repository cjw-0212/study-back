package com.example.shopcommon.pojo;

import lombok.Data;

/**
 * @author CJW
 * @since 2023/10/15
 */
@Data
public class User {
    private Integer uid;
    private String username;
    private String password;
    private String telephone;
}
