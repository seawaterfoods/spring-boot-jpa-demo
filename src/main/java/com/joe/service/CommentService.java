package com.joe.service;

import com.joe.domain.Comment;

public interface CommentService {

    Comment saveComment(Comment comment);

    void deleteComment(Long id);
}
