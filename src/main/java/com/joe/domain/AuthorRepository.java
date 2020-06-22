package com.joe.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AuthorRepository extends JpaRepository<Author,Long> {

//    可以自訂自己要的方法
    List<Author> findByPhoneAndNickName(String phone,String nickName);

    List<Author> findDistinctByNickNameIgnoreCaseOrPhoneOrderBySignDateDesc(String nickName,String phone);

    List<Author> findByNickNameLike(String nickName);

}
