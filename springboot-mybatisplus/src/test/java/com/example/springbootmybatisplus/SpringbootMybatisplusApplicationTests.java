package com.example.springbootmybatisplus;

import com.example.springbootmybatisplus.mapper.BlogMapper;
import com.example.springbootmybatisplus.mapper.StudentMapper;
import com.example.springbootmybatisplus.po.Student;
import com.example.springbootmybatisplus.vo.BlogVO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringbootMybatisplusApplicationTests {
    @Autowired
    private StudentMapper studentMapper;
    @Autowired
    private BlogMapper blogMapper;
    @Test
    void contextLoads() {
        Student student = studentMapper.selectById(1800562236672995330L);
        student.setName("更改名字");
        studentMapper.updateById(student);
    }
    @Test
    void test(){
        BlogVO blogVO=blogMapper.selectBlogVO(1);
        System.out.println(blogVO);
    }
}
