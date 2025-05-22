package ru.totalexx.mod4.web.api.model.response;

import lombok.Data;

@Data
public class CommentResponse {
    private Long id;
    private String comment;
    private UserResponse author;
}
