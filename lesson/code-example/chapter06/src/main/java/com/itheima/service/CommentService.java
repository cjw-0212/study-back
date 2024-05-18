package com.itheima.service;

import com.itheima.domain.Comment;
import com.itheima.mapper.CommentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CommentService {
    @Autowired
    private CommentMapper commentMapper;

    //查找指定id的记录详细信息
    public void selectComment(Integer id) {
        Comment comment = commentMapper.findCommentById(id);
        System.out.println(comment);
    }

    //添加一条记录
    @Transactional
    public void addComment() {
        Comment comment = new Comment();
        comment.setContent("这篇文章值得收藏");
        comment.setUId(3);
        comment.setAId(2);
        int rows = commentMapper.insertComment(comment);
        if (rows > 0) {
            System.out.println("您成功插入了" + rows + "条数据！");
        } else {
            System.out.println("执行插入操作失败！");
        }
        //int k=1/0;
    }

    //修改指定id的记录字段值
    @Transactional
    public void updateComment(Integer id) {
        Comment comment = commentMapper.findCommentById(id);
        comment.setContent("这篇文章太精彩了");
        int rows = commentMapper.updateComment(comment);
        if (rows > 0) {
            System.out.println("您成功修改了" + rows + "条数据！");
        } else {
            System.out.println("执行修改操作失败！");
        }
    }

    //删除指定id的记录
    @Transactional
    public void deleteComment(Integer id) {
        int rows = commentMapper.deleteComment(id);
        if (rows > 0) {
            System.out.println("您成功删除了" + rows + "条数据！");
        } else {
            System.out.println("执行删除操作失败！");
        }
    }
}
