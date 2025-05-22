package ru.totalexx.mod4.repository.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class NewsFilter {
    private int page;
    private int pageSize;
    private Long categoryId;
    private Long authorId;
}
