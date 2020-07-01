package com.joe;


import com.alibaba.fastjson.JSON;
import com.joe.domain.Article;
import com.joe.domain.Comment;
import com.joe.service.ArticleService;
import com.joe.service.CommentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CommentTests {

    @Autowired
    CommentService commentService;

    @Autowired
    ArticleService articleService;


    @Test
    public void saveCommentTest(){
        Article article = articleService.findArticle(29L);

        Comment comment =new Comment();
        comment.setContent("關於被刪除這件事...");
        comment.setArticle(article);

        commentService.saveComment(comment);
    }

    @Test
    public void deleteCommentTest(){
        commentService.deleteComment(33L);
    }
}
