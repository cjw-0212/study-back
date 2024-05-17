package com.example.springbootmybatisplus.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.springbootmybatisplus.mapper.StudentMapper;
import com.example.springbootmybatisplus.pojo.Student;
import com.example.springbootmybatisplus.service.StudentService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 学生 服务实现类
 * </p>
 *
 * @author CJW
 * @since 2023-03-27
 */
@Service
public class StudentServiceImpl extends ServiceImpl<StudentMapper, Student> implements StudentService {

}
