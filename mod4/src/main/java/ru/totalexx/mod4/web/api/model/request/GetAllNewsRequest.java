package ru.totalexx.mod4.web.api.model.request;

import lombok.Data;

@Data
public class GetAllNewsRequest {
    private int page;
    private int pageSize;
}
