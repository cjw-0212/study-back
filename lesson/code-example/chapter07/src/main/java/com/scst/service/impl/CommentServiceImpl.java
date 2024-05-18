package com.scst.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.scst.domain.Comment;
import com.scst.domain.CommentVO;
import com.scst.mapper.CommentMapper;
import com.scst.service.CommentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl extends ServiceImpl<CommentMapper, Comment> implements CommentService {
    @Autowired
    CommentMapper commentMapper;

    // 多表条件分页查询
    public IPage<CommentVO> selectCommentVOByPage(Long currentPage, Long pageSize, CommentVO commentVO) {
        IPage<CommentVO> page = new Page<>(currentPage, pageSize);  //设置当前页号和分页大小
        QueryWrapper<CommentVO> wrapper = new QueryWrapper<>();
        String title = commentVO.getTitle();
        String userName = commentVO.getUserName();
        String content = commentVO.getContent();
        if (Strings.isNotEmpty(title)) wrapper.like("a.title", title);
        if (Strings.isNotEmpty(userName)) wrapper.like("u.user_name", userName);
        if (Strings.isNotEmpty(content)) wrapper.like("c.content", content);
        return commentMapper.selectCommentVOByPage(page, wrapper);
    }

    public void selectCommentVOByPage() {
        CommentVO commentVO = new CommentVO();
        commentVO.setContent("很");
        commentVO.setTitle("Spring");
        commentVO.setUserName("zhang");
        IPage<CommentVO> page = this.selectCommentVOByPage(1L, 2L, commentVO);
        System.out.println("数据总条数：" + page.getTotal());
        System.out.println("总页数：" + page.getPages());
        List<CommentVO> comments = page.getRecords(); //获取当前页中的记录
        for (CommentVO c : comments) {
            System.out.println("comment = " + c);
        }
    }
}
