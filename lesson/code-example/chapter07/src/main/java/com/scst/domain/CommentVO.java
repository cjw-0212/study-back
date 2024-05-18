package com.scst.domain;

import lombok.Data;

@Data
public class CommentVO {
    private Integer id;
    private String content;
    private String userName;
    private String title;
}
