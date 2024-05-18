package com.itheima.domain;

import lombok.Data;

@Data
public class Comment {
    private Integer id;
    private String content;
    private Integer uId;
    private Integer aId;

    @Override
    public String toString() {
        return "Comment{" + "id=" + id + ", content='" + content + '\'' + ", uId=" + uId + ", aId=" + aId + '}';
    }
}
