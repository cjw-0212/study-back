package com.itheima.mapper;

import com.itheima.domain.Comment;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface CommentMapper {
    @Select("SELECT * FROM t_comment WHERE id =#{id}")
    public Comment findCommentById(Integer id);

    @Select("SELECT * FROM t_comment WHERE u_id =#{id}")
    public List<Comment> findCommentsByUserId(Integer id);

    @Insert("INSERT INTO t_comment(content,u_id,a_id) " + "values (#{content},#{uId},#{aId})")
    public int insertComment(Comment comment);

    @Update("UPDATE t_comment SET content=#{content} WHERE id=#{id}")
    public int updateComment(Comment comment);

    @Delete("DELETE FROM t_comment WHERE id=#{id}")
    public int deleteComment(Integer id);
}
