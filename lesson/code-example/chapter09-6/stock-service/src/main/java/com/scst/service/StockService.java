package com.scst.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.scst.domain.Stock;
import org.springframework.stereotype.Service;

@Service
public class StockService {

    public boolean deduct(String productId){
        Stock stock = new Stock();
        QueryWrapper<Stock> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("p_id",productId);
        Stock stk = stock.selectOne(queryWrapper);
        if(stk!=null){
            Integer count =stk.getCount()-10;
            stk.setCount(count);
            stk.updateById();
            return true;
        }
        return false;
    }
}
