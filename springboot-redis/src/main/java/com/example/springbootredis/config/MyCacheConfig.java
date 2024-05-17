package com.example.springbootredis.config;

import com.alibaba.fastjson.support.spring.FastJsonRedisSerializer;
import org.springframework.boot.autoconfigure.cache.CacheProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.CacheKeyPrefix;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * @author CJW
 * @since 2023/11/28
 */
@Configuration
@EnableCaching
//引入配置类
@EnableConfigurationProperties(CacheProperties.class)
public class MyCacheConfig {
    @Bean
    public RedisCacheConfiguration redisCacheConfiguration(CacheProperties cacheProperties) {
        RedisCacheConfiguration config = RedisCacheConfiguration.defaultCacheConfig();
        config = config.serializeKeysWith(RedisSerializationContext.SerializationPair.fromSerializer(new StringRedisSerializer()));
        config = config.serializeValuesWith(RedisSerializationContext.SerializationPair.fromSerializer(new FastJsonRedisSerializer<>(Object.class)));
        //获取配置文件的配置
        CacheProperties.Redis redisProperties = cacheProperties.getRedis();
        if (redisProperties.getTimeToLive() != null) {
            config = config.entryTtl(redisProperties.getTimeToLive());
        }
        if (redisProperties.getKeyPrefix() != null) {
            config = config.prefixCacheNameWith(redisProperties.getKeyPrefix());
        }
        if (!redisProperties.isCacheNullValues()) {
            config = config.disableCachingNullValues();
        }
        if (!redisProperties.isUseKeyPrefix()) {
            config = config.disableKeyPrefix();
        }
        //自定义key的连接方式
        config = config.computePrefixWith(buildPrefix(redisProperties.getKeyPrefix()));
        return config;
    }

    //重新构建key的连接格式
    private CacheKeyPrefix buildPrefix(String keyPrefix) {
        return (name) -> {
            StringBuffer str = new StringBuffer();
            str.append(keyPrefix);
            str.append(":");
            str.append(name);
            str.append(":");
            return str.toString();
        };
    }
}
