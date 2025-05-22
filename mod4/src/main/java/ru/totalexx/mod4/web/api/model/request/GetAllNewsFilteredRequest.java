package ru.totalexx.mod4.web.api.model.request;

import lombok.Data;

@Data
public class GetAllNewsFilteredRequest {
    private int page;
    private int pageSize;
    private Long categoryId;
    private Long authorId;
}
