package ru.totalexx.mod4.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import ru.totalexx.mod4.aop.Authorized;
import ru.totalexx.mod4.exception.ServiceException;
import ru.totalexx.mod4.model.Comment;
import ru.totalexx.mod4.model.User;
import ru.totalexx.mod4.repository.CommentRepository;
import ru.totalexx.mod4.service.CommentService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepository;

    @Override
    public void addComment(Comment comment) {
        if(comment.getNews() == null) {
            throw new ServiceException(HttpStatus.BAD_REQUEST, "News cannot be null");
        }

        if(comment.getAuthor() == null) {
            throw new ServiceException(HttpStatus.BAD_REQUEST, "Author cannot be null");
        }

        commentRepository.save(comment);
    }

    @Override
    @Authorized(entityClass = Comment.class)
    public void updateComment(Comment comment, User actor) {
        if (comment.getId() == null) {
            throw new ServiceException(HttpStatus.BAD_REQUEST, "Comment ID cannot be null");
        }

        if (comment.getNews() == null) {
            throw new ServiceException(HttpStatus.BAD_REQUEST, "News cannot be null");
        }

        if (comment.getAuthor() == null) {
            throw new ServiceException(HttpStatus.BAD_REQUEST, "Author cannot be null");
        }

        commentRepository.save(comment);
    }

    @Override
    public Comment getCommentById(Long id) {
        return commentRepository
                .findById(id)
                .orElseThrow(() -> new ServiceException(HttpStatus.NOT_FOUND, "Comment not found"));
    }

    @Override
    @Authorized(entityClass = Comment.class)
    public void removeComment(Long id, User actor) {
        if (!commentRepository.existsById(id)) {
            throw new ServiceException(HttpStatus.NOT_FOUND, "Comment not found");
        }

        commentRepository.deleteById(id);
    }

    @Override
    public List<Comment> getCommentsByNewsId(Long id) {
        return commentRepository.findAllByNewsId(id);
    }
}

