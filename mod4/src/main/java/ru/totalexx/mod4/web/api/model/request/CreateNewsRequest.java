package ru.totalexx.mod4.web.api.model.request;

import lombok.Data;

@Data
public class CreateNewsRequest {
    private String title;
    private String content;
    private Long categoryId;
    private Long authorId;
}
