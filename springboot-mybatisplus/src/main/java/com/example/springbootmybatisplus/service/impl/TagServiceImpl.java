package com.example.springbootmybatisplus.service.impl;

import com.example.springbootmybatisplus.po.Tag;
import com.example.springbootmybatisplus.mapper.TagMapper;
import com.example.springbootmybatisplus.service.TagService;
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
public class TagServiceImpl extends ServiceImpl<TagMapper, Tag> implements TagService {

}
