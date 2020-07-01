package com.joe.domain.repository;

import com.joe.domain.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface CommentRepository extends JpaRepository<Comment,Long> {


//    直接暴力刪除的話，會使數據關聯殘留
    @Transactional
    @Modifying
    @Query("delete from Comment c where c.id=?1")
    void deleteBy(Long id);
}
