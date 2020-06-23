package com.joe.service.impl;

import com.joe.domain.Author;
import com.joe.domain.AuthorRepository;
import com.joe.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service
public class AuthorServiceImpl implements AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    @Transactional
    @Override
    public Author updateAuthor() {
        Author author = new Author();
        author.setPhone("2131231231");
        author.setNickName("freeeeeedom");
        author.setSignDate(new Date());
        Author author1=authorRepository.save(author);


        author1.setPhone("9999999999");
        Author author2 = authorRepository.save(author1);

        return author2;
    }
}
