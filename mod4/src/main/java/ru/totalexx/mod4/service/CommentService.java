package ru.totalexx.mod4.service;

import ru.totalexx.mod4.model.Comment;
import ru.totalexx.mod4.model.User;

import java.util.List;

public interface CommentService {
    Comment getCommentById(Long id);
    List<Comment> getCommentsByNewsId(Long id);
    void addComment(Comment comment);
    void updateComment(Comment comment, User actor);
    void removeComment(Long id, User actor);
}

