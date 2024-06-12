package com.example.springbootmybatisplus.service.impl;

import com.example.springbootmybatisplus.po.Post;
import com.example.springbootmybatisplus.mapper.PostMapper;
import com.example.springbootmybatisplus.service.PostService;
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
public class PostServiceImpl extends ServiceImpl<PostMapper, Post> implements PostService {

}
