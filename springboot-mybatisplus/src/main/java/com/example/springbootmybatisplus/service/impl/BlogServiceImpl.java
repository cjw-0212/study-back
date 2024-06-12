package com.example.springbootmybatisplus.service.impl;

import com.example.springbootmybatisplus.po.Blog;
import com.example.springbootmybatisplus.mapper.BlogMapper;
import com.example.springbootmybatisplus.service.BlogService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author CJW
 * @since 2024-06-12
 */
@Service
public class BlogServiceImpl extends ServiceImpl<BlogMapper, Blog> implements BlogService {

}
