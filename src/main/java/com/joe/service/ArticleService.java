package com.joe.service;

import com.joe.domain.Article;
import org.springframework.stereotype.Service;

public interface ArticleServic {

    public Article saveArticle(Article article);

    public Article updateArticle(Article article);

    public Article findArticle(Long id);

    public void deleteArticle(Long id);
}
