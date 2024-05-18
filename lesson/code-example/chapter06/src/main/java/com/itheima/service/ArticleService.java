package com.itheima.service;

import com.itheima.domain.Article;
import com.itheima.mapper.ArticleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class ArticleService {
    @Autowired
    private ArticleMapper articleMapper;

    //查找指定id的文章记录详细信息（包括评论信息）
    public void selectArticleById(Integer id) {
        Article article = articleMapper.findArticleById(id);
        System.out.println(article);
    }

    //查找指定ids列表的文章记录详细信息（包括评论信息）
    public void selectArticlesByIds() {
        List<Integer> ids = new ArrayList<>();
        ids.add(1);
        ids.add(2);
        List<Article> articles = articleMapper.findArticlesByIds(ids);
        for (Article article : articles) {
            System.out.println(article);
        }
    }

    //据标题模糊查询文章记录列表的详细信息（包括评论信息）
    public void selectArticlesByLikeTitle(String liketitle) {
        List<Article> articles = articleMapper.findArticlesByLikeTitle(liketitle);
        for (Article article : articles) {
            System.out.println(article);
        }
    }

    //添加一条文章记录
    @Transactional
    public void addArticle() {
        Article article = new Article();
        article.setTitle("SSM应用开发教程");
        article.setContent("国家信息技术紧缺人才培养工程指定教材");
        int rows = articleMapper.insertArticle(article);
        if (rows > 0) {
            System.out.println("您成功插入了" + rows + "条数据！");
        } else {
            System.out.println("执行插入操作失败！");
        }
    }

    //修改指定id的文章记录标题和内容
    @Transactional
    public void updateArticle(Integer id) {
        Article article = articleMapper.findArticleById(id);
        article.setTitle("Spring Boot企业级开发教程");
        article.setContent("工业和信息化“十三五”人才培养规划教材");
        int rows = articleMapper.updateArticle(article);
        if (rows > 0) {
            System.out.println("您成功修改了" + rows + "条数据！");
        } else {
            System.out.println("执行修改操作失败！");
        }
    }

    //删除指定id的文章记录详细信息（包括评论信息）
    @Transactional
    public void deleteArticle(Integer id) {
        int rows = articleMapper.deleteArticle(id);
        if (rows > 0) {
            System.out.println("您成功删除了" + rows + "条数据！");
        } else {
            System.out.println("执行删除操作失败！");
        }
    }

}
