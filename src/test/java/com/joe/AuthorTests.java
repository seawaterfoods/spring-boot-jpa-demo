package com.joe;


import com.alibaba.fastjson.JSON;
import com.joe.domain.Author;
import com.joe.domain.AuthorRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Sort;

import java.util.Date;
import java.util.List;

@SpringBootTest
public class AuthorTests {

    @Autowired
    private AuthorRepository authorRepository;

//    @Test
    public void saveAuthorTest(){
//        Author author1=new Author();
//        Author author2=new Author();
//        Author author3=new Author();
//        Author author4=new Author();
//
//        author1.setNickName("tkkinc");
//        author1.setPhone("0226599247");
//        author1.setSignDate(new Date());
//        authorRepository.save(author1);
//
//        author2.setNickName("SubWay");
//        author2.setPhone("0226579298");
//        author2.setSignDate(new Date());
//        authorRepository.save(author2);
//
//        author3.setNickName("BurgerKing");
//        author3.setPhone("0221753018");
//        author3.setSignDate(new Date());
//        authorRepository.save(author3);
//
//        author4.setNickName("WindyBurger");
//        author4.setPhone("0222227777");
//        author4.setSignDate(new Date());
//        authorRepository.save(author4);
    }

    @Test
    public void findAuthorTest(){
//        List<Author> authors = authorRepository.findBySql("o");
//        List<Author> authors = authorRepository.findByPhone("0226");
//        List<Object[]> arry =authorRepository.findArry("piz");

//        List<Author> authors = authorRepository.findByNickName("bur",
//                Sort.by(Sort.Direction.DESC,"signDate"));
        int i =authorRepository.setNickName("PizzaHot","0228825252");
//        System.out.println(JSON.toJSONString(authors,true));
    }
}
