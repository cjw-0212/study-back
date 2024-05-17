package com.example.springsecurity.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.springsecurity.pojo.User;
import org.springframework.stereotype.Repository;

/**
 * <p>
 * 用户表 Mapper 接口
 * </p>
 *
 * @author CJW
 * @since 2023-10-23
 */
@Repository
public interface UserMapper extends BaseMapper<User> {

}
