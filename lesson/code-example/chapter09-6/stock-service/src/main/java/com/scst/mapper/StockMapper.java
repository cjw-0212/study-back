package com.scst.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.scst.domain.Stock;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface StockMapper extends BaseMapper<Stock> {
}

