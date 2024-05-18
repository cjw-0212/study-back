package com.scst.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.scst.domain.Comment;
import com.baomidou.mybatisplus.extension.service.IService;
import com.scst.domain.CommentVO;

public interface CommentService extends IService<Comment> {
    IPage<CommentVO> selectCommentVOByPage(Long currentPage, Long pageSize, CommentVO commentVO);
}
