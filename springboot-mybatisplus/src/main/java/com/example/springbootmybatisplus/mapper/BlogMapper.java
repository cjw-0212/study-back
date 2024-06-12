package com.example.springbootmybatisplus.mapper;

import com.example.springbootmybatisplus.po.Blog;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.springbootmybatisplus.vo.BlogVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author CJW
 * @since 2024-06-12
 */
@Mapper
public interface BlogMapper extends BaseMapper<Blog> {
    BlogVO selectBlogVO(@Param("blogId") Integer blogId);
}
