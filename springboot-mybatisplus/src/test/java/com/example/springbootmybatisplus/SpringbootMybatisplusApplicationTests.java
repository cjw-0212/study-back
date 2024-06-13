package com.example.springbootmybatisplus;

import com.example.springbootmybatisplus.mapper.BlogMapper;
import com.example.springbootmybatisplus.mapper.CommentMapper;
import com.example.springbootmybatisplus.mapper.PostMapper;
import com.example.springbootmybatisplus.mapper.StudentMapper;
import com.example.springbootmybatisplus.po.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class SpringbootMybatisplusApplicationTests {
    @Autowired
    private StudentMapper studentMapper;
    @Autowired
    private BlogMapper blogMapper;
    @Autowired
    private PostMapper postMapper;
    @Autowired
    private CommentMapper commentMapper;

    @Test
    void contextLoads() {
        Student student = studentMapper.selectById(1800562236672995330L);
        student.setName("更改名字");
        studentMapper.updateById(student);
    }

    @Test
    void test() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        System.out.println(commentMapper.getByIdList(list));
    }
}
