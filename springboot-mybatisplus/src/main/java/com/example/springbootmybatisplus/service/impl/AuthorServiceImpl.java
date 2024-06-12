package com.example.springbootmybatisplus.service.impl;

import com.example.springbootmybatisplus.po.Author;
import com.example.springbootmybatisplus.mapper.AuthorMapper;
import com.example.springbootmybatisplus.service.AuthorService;
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
public class AuthorServiceImpl extends ServiceImpl<AuthorMapper, Author> implements AuthorService {

}
