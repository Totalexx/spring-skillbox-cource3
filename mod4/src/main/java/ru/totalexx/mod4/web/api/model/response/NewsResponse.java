package ru.totalexx.mod4.web.api.model.response;

import lombok.Data;

import java.util.List;

@Data
public class NewsResponse {
    private Long id;
    private String title;
    private String content;
    private CategoryResponse category;
    private UserResponse author;
//    private List<CommentResponse> comments;
//    private Integer commentsCount;
}
