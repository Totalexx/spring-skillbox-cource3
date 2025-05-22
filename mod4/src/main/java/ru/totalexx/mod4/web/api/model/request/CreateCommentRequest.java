package ru.totalexx.mod4.web.api.model.request;

import lombok.Data;

@Data
public class CreateCommentRequest {
    private Long newsId;
    private Long authorId;
    private String comment;
}
