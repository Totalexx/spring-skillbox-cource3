package ru.totalexx.mod4.web.api.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.totalexx.mod4.model.Comment;
import ru.totalexx.mod4.model.User;
import ru.totalexx.mod4.service.CommentService;
import ru.totalexx.mod4.web.api.model.mapper.CommentMapper;
import ru.totalexx.mod4.web.api.model.request.*;
import ru.totalexx.mod4.web.api.model.response.CommentResponse;
import ru.totalexx.mod4.web.api.model.response.NewsCommentsResponse;

import java.util.List;

@RestController
@RequestMapping("api/v1/comment")
@RequiredArgsConstructor
public class CommentRestController {

    private final CommentService commentService;
    private final CommentMapper commentMapper;

    @GetMapping("get")
    public CommentResponse getComment(CommentRequest request) {
        Comment comment = commentService.getCommentById(request.getId());
        return commentMapper.toResponse(comment);
    }

    @GetMapping("get/by/news")
    public NewsCommentsResponse getCommentsByNewsId(NewsCommentsRequest request) {
        List<Comment> comments = commentService.getCommentsByNewsId(request.getNewsId());
        List<CommentResponse> commentResponses = commentMapper.toResponse(comments);
        return new NewsCommentsResponse(commentResponses);
    }

    @PostMapping("add")
    public ResponseEntity<Void> addComment(CreateCommentRequest request) {
        Comment comment = commentMapper.toEntity(request);
        commentService.addComment(comment);
        return ResponseEntity.ok().build();
    }

    @PutMapping("update")
    public ResponseEntity<Void> updateComment(UpdateCommentRequest request) {
        User user = new User();
        user.setId(request.getAuthorId());
        user.setPassword(request.getPassword());

        Comment comment = commentMapper.toEntity(request);
        commentService.updateComment(comment, user);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("delete")
    public ResponseEntity<Void> deleteComment(DeleteCommentRequest request) {
        User user = new User();
        user.setId(request.getAuthorId());
        user.setPassword(request.getPassword());

        commentService.removeComment(request.getId(), user);
        return ResponseEntity.ok().build();
    }
}
