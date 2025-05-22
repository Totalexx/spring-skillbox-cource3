package ru.totalexx.mod4.web.api.model.request;

import lombok.Data;

@Data
public class UpdateCommentRequest {
    private Long id;
    private Long newsId;
    private Long authorId;
    private String comment;
    private String password;
}
