package com.example.springbootmybatisplus.mapper;

import com.example.springbootmybatisplus.po.Student;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 学生表 Mapper 接口
 * </p>
 *
 * @author CJW
 * @since 2024-06-12
 */
@Mapper
public interface StudentMapper extends BaseMapper<Student> {

}
