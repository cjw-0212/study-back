package com.scst;

import com.scst.service.impl.CommentServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Chapter07ApplicationTests {

    @Autowired
    private CommentServiceImpl commentService;

    @Test
    void testByPage() {
        commentService.selectCommentVOByPage();
    }

}
