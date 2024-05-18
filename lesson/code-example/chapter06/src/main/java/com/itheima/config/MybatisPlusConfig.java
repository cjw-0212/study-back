package com.itheima.config;

import com.baomidou.mybatisplus.core.parser.ISqlParser;
import com.baomidou.mybatisplus.extension.parsers.BlockAttackSqlParser;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.extension.plugins.SqlExplainInterceptor;
import com.baomidou.mybatisplus.extension.plugins.PerformanceInterceptor;
import com.baomidou.mybatisplus.extension.plugins.OptimisticLockerInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class MybatisPlusConfig {

    @Bean //配置分页插件
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }

    @Bean //配置乐观锁插件
    public OptimisticLockerInterceptor optimisticLockerInterceptor() {
        return new OptimisticLockerInterceptor();
    }

    @Bean //配置SQL性能分析插件，该插件只用于开发环境，不建议生产环境使用。
    public PerformanceInterceptor performanceInterceptor() {
        PerformanceInterceptor performanceInterceptor = new PerformanceInterceptor();
        //设置SQL是否格式化
        performanceInterceptor.setFormat(true);
        //设置SQL最大执行时间（ms），超过时间会抛出异常。
        performanceInterceptor.setMaxTime(100);
        return performanceInterceptor;
    }

    @Bean //配置SQL执行分析插件，该插件只用于开发环境，不建议生产环境使用。
    public SqlExplainInterceptor sqlExplainInterceptor() {
        SqlExplainInterceptor sqlExplainInterceptor = new SqlExplainInterceptor();
        List<ISqlParser> list = new ArrayList<>();
        //添加全表更新、删除的阻断器，在未开启逻辑删除时，当执行全表更新、删除会抛出异常，有效防止一些误操作。
        list.add(new BlockAttackSqlParser());
        sqlExplainInterceptor.setSqlParserList(list);
        return sqlExplainInterceptor;
    }

}
