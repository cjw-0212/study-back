package com.itheima;

import com.itheima.service.ArticleService;
import com.itheima.service.CommentService;
import com.itheima.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Chapter06ApplicationTests {

    @Autowired
    private ArticleService articleService;

    @Test
    public void selectArticlesByIds() {
        this.articleService.selectArticlesByIds();
    }

    @Test
    public void addArticle() {
        this.articleService.addArticle();
    }

    @Test
    public void selectArticleById() {
        this.articleService.selectArticleById(3);
    }

    @Test
    public void selectArticlesByLikeTitle() {
        this.articleService.selectArticlesByLikeTitle("S");
    }

    @Test
    public void updateArticle() {
        this.articleService.updateArticle(3);
    }

    @Test
    public void deleteArticle() {
        this.articleService.deleteArticle(3);
    }

    @Autowired
    private CommentService commentService;

    @Test
    public void addComment() {
        this.commentService.addComment();
    }

    @Test
    public void selectComment() {
        this.commentService.selectComment(6);
    }

    @Test
    public void updateComment() {
        this.commentService.updateComment(6);
    }

    @Test
    public void deleteComment() {
        this.commentService.deleteComment(6);
    }

    @Autowired
    private UserService userService;

    @Test
    public void selectUserList() {
        this.userService.selectUserList();
    }

    @Test
    public void selectUserPage() {
        this.userService.selectUserPage();
    }

    @Test
    public void selectUserWithCommentsById() {
        this.userService.selectUserWithCommentsById(5);
    }

    @Test
    public void addUser() {
        this.userService.addUser();
    }

    @Test
    public void updateUser() {
        this.userService.updateUser(6);
    }

    @Test
    public void updateUserWithOptimisticLocker() {
        this.userService.updateUserWithOptimisticLocker(6);
    }

    @Test
    public void updateAllUser() {
        this.userService.updateAllUser();
    }

    @Test
    public void deleteUser() {
        this.userService.deleteUser(6);
    }

}
