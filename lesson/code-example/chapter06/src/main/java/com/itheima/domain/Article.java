package com.itheima.domain;

import lombok.Data;

import java.util.List;

@Data
public class Article {
    private Integer id;
    private String title;
    private String content;
    private List<Comment> commentList;

    @Override
    public String toString() {
        return "Article{" + "id=" + id + ", title='" + title + '\'' + ", content='" + content + '\'' + ", commentList=" + commentList + '}';
    }
}
