package com.example.springbootmybatisplus.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.springbootmybatisplus.pojo.Student;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 * 学生 Mapper 接口
 * </p>
 *
 * @author CJW
 * @since 2023-03-27
 */
@Repository
public interface StudentMapper extends BaseMapper<Student> {
    @Select("SELECT user_name,user_age,user_address FROM student WHERE user_name=#{name}")
    List<Student> getOneByUserName(@Param("name") String name);
}
