package com.joe;


import com.alibaba.fastjson.JSON;
import com.joe.domain.Author;
import com.joe.domain.repository.AuthorRepository;
import com.joe.domain.Wallet;
import com.joe.domain.repository.WelletRepository;
import com.joe.service.AuthorService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.math.BigDecimal;
import java.util.Date;

@SpringBootTest
public class AuthorTests {

    @Autowired
    private AuthorService authorService;

    @Autowired
    private WelletRepository welletRepository;

    @Autowired
    private AuthorRepository authorRepository;

//    @Test
    public void saveAuthorTest(){
        Author author1=new Author();
//        Author author2=new Author();
//        Author author3=new Author();
//        Author author4=new Author();
//
        author1.setNickName("student");
        author1.setPhone("0204886588");
        author1.setSignDate(new Date());
        author1.setWallet(new Wallet(new BigDecimal(188.23)));
        authorRepository.save(author1);
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

//    @Test
    public void updateAuthor(){
        Author author = authorService.findAuthor(21L);
        author.setPhone("0202888999");
        Wallet wallet = author.getWallet();
        wallet.setBalance(new BigDecimal(288.88));
        author.setWallet(wallet);

        authorService.updateAuthor(author);
    }

//    @Test
    public void findAuthorTest(){
        Author author =authorService.findAuthor(21L);
        System.out.println(JSON.toJSONString(author,true));
    }

//    @Test
    public void findAuthorForPageTest(){
        Sort sort =Sort.by(Sort.Direction.DESC,"id");
        Pageable pageable =PageRequest.of(0,4,sort);
        Page<Author> page = authorRepository.findAll(pageable);

        System.out.println(JSON.toJSONString(page,true));
    }

//    @Test
    public void teansactionalTest(){
        authorService.updateAuthor();
    }

//    @Test
    public void deleteAuthorTest(){
        authorService.deleteAuthor(21L);
    }

    @Test
    public void findWalletTest(){
        Wallet wallet = welletRepository.findById(22L).get();
        System.out.println(JSON.toJSONString(wallet,true));
    }
}
