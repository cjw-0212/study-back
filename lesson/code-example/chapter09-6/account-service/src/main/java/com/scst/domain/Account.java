package com.scst.domain;

import lombok.Data;
import com.baomidou.mybatisplus.extension.activerecord.Model;

@Data
public class Account extends Model<Account>{
    private Integer id;
    private String aId;
    private float balance;
}
