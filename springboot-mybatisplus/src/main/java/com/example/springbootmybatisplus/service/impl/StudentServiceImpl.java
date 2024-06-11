package com.example.springbootmybatisplus.service.impl;

import com.example.springbootmybatisplus.po.Student;
import com.example.springbootmybatisplus.mapper.StudentMapper;
import com.example.springbootmybatisplus.service.StudentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 学生表 服务实现类
 * </p>
 *
 * @author CJW
 * @since 2024-06-12
 */
@Service
public class StudentServiceImpl extends ServiceImpl<StudentMapper, Student> implements StudentService {

}
