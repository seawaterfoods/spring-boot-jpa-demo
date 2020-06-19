package com.joe;


import com.joe.domain.Author;
import com.joe.domain.AuthorRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

@SpringBootTest
public class AuthorTests {

    @Autowired
    private AuthorRepository authorRepository;

    @Test
    public void saveAuthorTest(){
        Author author=new Author();
        author.setNickName("PizzaHot");
        author.setPhone("0228825252");
        author.setSignDate(new Date());
        authorRepository.save(author);
    }
}
