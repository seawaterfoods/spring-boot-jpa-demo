package com.joe;


import com.alibaba.fastjson.JSON;
import com.joe.domain.Article;
import com.joe.domain.Author;
import com.joe.domain.Comment;
import com.joe.domain.Wallet;
import com.joe.domain.repository.AuthorRepository;
import com.joe.domain.repository.WelletRepository;
import com.joe.service.ArticleService;
import com.joe.service.AuthorService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SpringBootTest
public class ArticleTests {

    @Autowired
    private ArticleService articleService;

//    @Test
    public void saveArticle(){
        Article article = new Article();
        article.setTitle("關於撲街");
        article.setContent("關於撲街的一些想法...");

        Comment comment1 =new Comment("評論內容1");
        Comment comment2 =new Comment("評論內容2");

        article.addComment(comment1);
        article.addComment(comment2);

        articleService.saveArticle(article);

    }

    @Test
    public void updateArticle(){
        Article article =articleService.findArticle(26L);
        article.setContent("很撲街...");
        articleService.updateArticle(article);
    }

    @Test
    public void findArticle(){
        Article article =articleService.findArticle(26L);
        System.out.println(JSON.toJSONString(article,true));
    }


    @Test
    public void deleteArticle(){
        articleService.deleteArticle(26L);
    }
}
