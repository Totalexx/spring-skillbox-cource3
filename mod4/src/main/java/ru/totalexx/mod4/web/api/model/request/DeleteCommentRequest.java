package ru.totalexx.mod4.web.api.model.request;

import lombok.Data;

@Data
public class DeleteCommentRequest {
    private Long id;
    private Long authorId;
    private String password;
}
