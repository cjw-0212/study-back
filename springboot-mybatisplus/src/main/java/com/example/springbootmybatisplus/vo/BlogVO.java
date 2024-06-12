package com.example.springbootmybatisplus.vo;

import com.example.springbootmybatisplus.po.Author;
import lombok.Data;

/**
 * @author CJW
 * @since 2024/6/12
 */
@Data
public class BlogVO {
    private Integer blogId;

    private String blogTitle;

    private Author author;
}
