package com.scst.domain;

import lombok.Data;
import com.baomidou.mybatisplus.extension.activerecord.Model;

@Data
public class Stock extends Model<Stock>{
    private Integer id;
    private String pId;
    private Integer count;
}
