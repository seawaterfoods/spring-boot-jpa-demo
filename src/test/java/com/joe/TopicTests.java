package com.joe;


import com.alibaba.fastjson.JSON;
import com.joe.domain.Article;
import com.joe.domain.Comment;
import com.joe.domain.Topic;
import com.joe.service.ArticleService;
import com.joe.service.TopicService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TopicTests {

    @Autowired
    private TopicService topicService;

    @Test
    public void saveTopic(){
        Topic topic = new Topic();
        topic.setName("創意!");
        topicService.saveTopic(topic);
    }

    @Test
    public void updateTopic(){
        Topic topic = topicService.findTopic(34L);
        topic.setName("Art!");
        topicService.updateTopic(topic);
    }

    @Test
    public void includeArticle(){
        topicService.includeArticle(34L,29L);
    }

    @Test
    public void findTopic(){
        Topic topic = topicService.findTopic(34L);
//        topic.getArticles();
//        System.out.println(JSON.toJSONString(topic,true));
    }

    @Test
    public void unIncludeArticle(){
        topicService.unIncludeArticle(34L,29L);
    }

    @Test
    public void deleteTopic(){
        topicService.deleteTopic(34L);
    }
}
