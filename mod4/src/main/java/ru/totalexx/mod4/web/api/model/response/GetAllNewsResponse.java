package ru.totalexx.mod4.web.api.model.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllNewsResponse {
    private List<NewsResponse> news;
    private Long totalCount;
}
