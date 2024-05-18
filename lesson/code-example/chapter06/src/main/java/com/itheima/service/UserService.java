package com.itheima.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.itheima.domain.Comment;
import com.itheima.domain.User;
import com.itheima.enums.SexEnum;
import com.itheima.mapper.CommentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService {

    //根据实体条件查询所有用户记录
    public void selectUserList() {
        User user = new User();
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.ge("age", "20");
        user.selectList(queryWrapper).forEach(System.out::println);
    }

    //根据分页设置和实体条件查询用户记录
    public void selectUserPage() {
        User user = new User();
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.gt("age", 20); //年龄大于20岁
        Page<User> page = new Page<>(1, 2); //设置当前页号和分页大小
        //根据分页设置和实体条件查询数据
        IPage<User> iPage = user.selectPage(page, wrapper);
        System.out.println("数据总条数：" + iPage.getTotal());
        System.out.println("总页数：" + iPage.getPages());
        List<User> users = iPage.getRecords(); //获取当前页中的记录
        for (User u : users) {
            System.out.println("user = " + u);
        }
    }

    @Autowired
    CommentMapper commentMapper;

    //查找指定id的用户记录详细信息（包括评论信息）
    public void selectUserWithCommentsById(Integer id) {
        User user = new User();
        User u = user.selectById(id);
        List<Comment> list = commentMapper.findCommentsByUserId(id);
        u.setCommentList(list);
        System.out.println(u);
    }

    //添加一条用户记录
    @Transactional
    public void addUser() {
        User user = new User();
        user.setName("刘备");
        user.setAge(30);
        user.setUserName("liubei");
        user.setMail("liubei@itcast.cn");
        user.setSex(SexEnum.MAN);
        boolean result = user.insert();
        if (result) {
            System.out.println("您成功插入数据！");
        } else {
            System.out.println("执行插入操作失败！");
        }
    }

    //修改指定id的用户记录年龄
    @Transactional
    public void updateUser(Integer id) {
        User user = new User();
        user.setId(id);
        user.setAge(35);
        boolean result = user.updateById();
        if (result) {
            System.out.println("您成功修改了数据！");
        } else {
            System.out.println("执行修改操作失败！");
        }
    }

    //不需事务处理，基于乐观锁修改指定id的用户记录年龄
    public void updateUserWithOptimisticLocker(Integer id) {
        User user = new User();
        User u1 = user.selectById(id);
        User u2 = user.selectById(id);
        u1.setAge(35);
        u2.setAge(25);
        boolean result2 = u2.updateById();
        boolean result1 = u1.updateById();
        if (result2 && !result1) {
            System.out.println("您成功修改了2号数据，但执行1号修改操作失败！");
        }
    }

    //在开启逻辑删除下进行全表更新或删除（不受配置的SQL执行分析插件拦截)
    @Transactional
    public void updateAllUser() {
        User user = new User();
        //user.delete(null);
        user.setAge(50);
        user.update(null);
    }

    //逻辑删除指定id的用户记录详细信息
    @Transactional
    public void deleteUser(Integer id) {
        User user = new User();
        user.setId(id);
        boolean result = user.deleteById();
        if (result) {
            System.out.println("您成功删除了数据！");
        } else {
            System.out.println("执行删除操作失败！");
        }
    }
}
