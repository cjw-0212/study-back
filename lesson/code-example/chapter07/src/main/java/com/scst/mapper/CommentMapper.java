package com.scst.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.scst.domain.Comment;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.scst.domain.CommentVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface CommentMapper extends BaseMapper<Comment> {

    @Select("SELECT c.id,c.content,u.user_name,a.title FROM t_comment c " +
            "LEFT JOIN t_user u ON c.u_id = u.id " +
            "LEFT JOIN t_article a ON c.a_id = a.id " +
            "${ew.customSqlSegment}")
    // 多表条件分页查询
    public IPage<CommentVO> selectCommentVOByPage(IPage<CommentVO> page, @Param(Constants.WRAPPER) Wrapper<CommentVO> wrapper);
}
