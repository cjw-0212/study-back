package com.example.springbootmybatisplus.service.impl;

import com.example.springbootmybatisplus.po.Comment;
import com.example.springbootmybatisplus.mapper.CommentMapper;
import com.example.springbootmybatisplus.service.CommentService;
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
public class CommentServiceImpl extends ServiceImpl<CommentMapper, Comment> implements CommentService {

}
