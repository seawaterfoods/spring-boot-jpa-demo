package com.joe.service.impl;

import com.joe.domain.Comment;
import com.joe.domain.repository.CommentRepository;
import com.joe.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentRepository commentRepository;

    @Transactional
    @Override
    public Comment saveComment(Comment comment) {


        return commentRepository.save(comment);
    }

    @Transactional
    @Override
    public void deleteComment(Long id) {
        Comment comment =commentRepository.findById(id).get();
//        解除該評論與該文章的關聯
        comment.clearComment();
        commentRepository.deleteById(id);
    }
}
