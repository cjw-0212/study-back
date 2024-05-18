package com.scst.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.scst.domain.Comment;
import com.scst.domain.CommentVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class CachedCommentService {

    @Autowired
    CommentServiceImpl commentService;

    // 多表条件分页查询
    @Cacheable(cacheNames = "comment",  unless = "#result==null")
    public IPage<CommentVO> selectCommentVOByPage(Long currentPage, Long pageSize, CommentVO commentVO) {
        return commentService.selectCommentVOByPage(currentPage, pageSize, commentVO);
    }

    //查找指定id的记录详细信息
    //只允许单线程查，防范缓存击穿
    @Cacheable(cacheNames = "comment",  sync = true)
    public Comment getById(Integer id) {
        return commentService.getById(id);
    }

    //存储记录
    public boolean save(Comment comment) {
        return commentService.save(comment);
    }

    //修改指定记录字段值
    @CachePut(cacheNames = "comment")
    public boolean saveOrUpdate(Comment comment) {
        return commentService.saveOrUpdate(comment);
    }

    //删除指定id的记录
    @CacheEvict(cacheNames = "comment")
    public boolean removeById(Integer id) {
        return commentService.removeById(id);
    }
}
