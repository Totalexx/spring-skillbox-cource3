package ru.totalexx.mod4.web.api.model.request;

import lombok.Data;

@Data
public class UpdateNewsRequest {
    private Long id;
    private String title;
    private String content;
    private Long authorId;
    private Long categoryId;
    private String password;
}
