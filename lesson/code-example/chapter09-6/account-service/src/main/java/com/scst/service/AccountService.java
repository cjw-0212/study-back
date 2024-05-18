package com.scst.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.scst.domain.Account;
import org.springframework.stereotype.Service;

@Service
public class AccountService {

    public boolean reduce(String accountId){
        Account account = new Account();
        QueryWrapper<Account> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("a_id",accountId);
        Account acc = account.selectOne(queryWrapper);
        if(acc!=null){
            float balance =acc.getBalance()-100;
            acc.setBalance(balance);
            acc.updateById();
            return true;
        }
        return false;
    }
}
