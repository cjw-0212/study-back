package com.example.springbootmybatisplus.mapper;

import com.example.springbootmybatisplus.po.Post;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author CJW
 * @since 2024-06-12
 */
@Mapper
public interface PostMapper extends BaseMapper<Post> {
    List<Post> getByObject(@Param("post") Post post);

    void updateByObject(@Param("post") Post post);
}
