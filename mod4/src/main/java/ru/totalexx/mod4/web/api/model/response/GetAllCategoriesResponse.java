package ru.totalexx.mod4.web.api.model.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.List;

@Data
@AllArgsConstructor
public class GetAllCategoriesResponse {
    private List<CategoryResponse> categories;
    private int totalPages;
}

