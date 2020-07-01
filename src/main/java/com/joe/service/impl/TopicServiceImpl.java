package com.joe.service.impl;

import com.alibaba.fastjson.JSON;
import com.joe.domain.Article;
import com.joe.domain.Topic;
import com.joe.domain.repository.ArticleRepository;
import com.joe.domain.repository.TopicRepository;
import com.joe.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class TopicServiceImpl implements TopicService {

    @Autowired
    private TopicRepository topicRepository;

    @Autowired
    private ArticleRepository articleRepository;


    @Transactional
    @Override
    public Topic saveTopic(Topic topic) {
        return topicRepository.save(topic);
    }

    @Transactional
    @Override
    public Topic findTopic(Long id) {
        Topic topic = topicRepository.findById(id).get();
        topic.getArticles();
        System.out.println(JSON.toJSONString(topic,true));
        return topic;
    }

    @Transactional
    @Override
    public Topic updateTopic(Topic topic) {
        return topicRepository.save(topic);
    }

    @Transactional
    @Override
    public Topic includeArticle(Long topicId, Long articleId) {
        Topic topic = topicRepository.findById(topicId).get();
        Article article = articleRepository.findById(articleId).get();
        topic.getArticles().add(article);
        return topic;
    }

    @Transactional
    @Override
    public Topic unIncludeArticle(Long topicId, Long articleId) {
        Topic topic = topicRepository.findById(topicId).get();
        Article article = articleRepository.findById(articleId).get();
        topic.getArticles().remove(article);
        return topic;
    }

    @Override
    public void deleteTopic(Long topicId) {
        topicRepository.deleteById(topicId);
    }
}
