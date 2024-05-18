package com.scst.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.scst.controller.utils.R;
import com.scst.domain.Comment;
import com.scst.domain.CommentVO;
import com.scst.service.impl.CachedCommentService;
import com.scst.service.impl.CommentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/comment")
public class CommentController {

    @Autowired
    //private CommentServiceImpl commentService;
    private CachedCommentService commentService;

    @GetMapping("/{currentPage}/{pageSize}")
    public R getAll(@PathVariable Long currentPage, @PathVariable Long pageSize, CommentVO commentVO) {
        IPage page = commentService.selectCommentVOByPage(currentPage, pageSize, commentVO);
        //如果当前页码值大于了总页码值，那么重新执行查询操作，使用最大页码值作为当前页码值
        if (currentPage > page.getPages()) {
            page = commentService.selectCommentVOByPage(page.getPages(), pageSize, commentVO);
        }
        return new R(page != null, page);
    }

    @PostMapping
    public R save(@RequestBody Comment comment) throws IOException {
        if (comment.getContent().equals("123")) throw new IOException();
        boolean flag = commentService.save(comment);
        return new R(flag, flag ? "添加成功^_^" : "添加失败-_-!");
    }

    @GetMapping("/{id}")
    public R getById(@PathVariable Integer id) {
        Comment comment = commentService.getById(id);
        boolean flag = comment != null;
        return new R(flag, flag ? comment : "数据同步失败-_-!");
    }

    @PutMapping
    public R update(@RequestBody Comment comment) throws IOException {
        if (comment.getContent().equals("123")) throw new IOException();
        boolean flag = commentService.saveOrUpdate(comment);
        return new R(flag, flag ? "修改成功^_^" : "修改失败-_-!");
    }

    @DeleteMapping("/{id}")
    public R delete(@PathVariable Integer id) {
        boolean flag = commentService.removeById(id);
        return new R(flag, flag ? "删除成功^_^" : "删除失败-_-!");
    }
}

