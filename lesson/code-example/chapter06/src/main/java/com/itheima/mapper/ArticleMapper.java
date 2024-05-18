package com.itheima.mapper;

import com.itheima.domain.Article;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ArticleMapper {
    //查找指定id的文章记录详细信息（包括评论信息）
    public Article findArticleById(Integer id);

    //查找指定ids列表的文章记录详细信息（包括评论信息）
    public List<Article> findArticlesByIds(List<Integer> ids);

    //根据标题模糊查询文章记录列表的详细信息（包括评论信息）
    public List<Article> findArticlesByLikeTitle(String liketitle);

    //添加一条文章记录
    public int insertArticle(Article article);

    //更新一条文章记录
    public int updateArticle(Article article);

    //删除指定id的文章记录详细信息（包括评论信息）
    public int deleteArticle(Integer id);
}
