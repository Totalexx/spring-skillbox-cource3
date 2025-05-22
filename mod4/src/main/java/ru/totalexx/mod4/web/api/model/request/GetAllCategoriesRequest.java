package ru.totalexx.mod4.web.api.model.request;

import lombok.Data;

@Data
public class GetAllCategoriesRequest {
    private int page;
    private int pageSize;
}

