package com.joe;


import com.alibaba.fastjson.JSON;
import com.joe.domain.Author;
import com.joe.domain.AuthorRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.List;

@SpringBootTest
public class AuthorTests {

    @Autowired
    private AuthorRepository authorRepository;

//    @Test
    public void saveAuthorTest(){
        Author author=new Author();
        author.setNickName("PizzaHot");
        author.setPhone("0228825252");
        author.setSignDate(new Date());
        authorRepository.save(author);
    }

    @Test
    public void findAuthorTest(){
//        List<Author> authors = authorRepository.findByPhoneAndNickName("0228825252","PizzaHot");
        List<Author> authors = authorRepository.findDistinctByNickNameIgnoreCaseOrPhoneOrderBySignDateDesc("PizzaHot","0228825252");

        System.out.println(JSON.toJSONString(authors,true));
    }
}
