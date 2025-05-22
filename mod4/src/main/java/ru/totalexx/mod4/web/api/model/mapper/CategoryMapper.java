package ru.totalexx.mod4.web.api.model.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import ru.totalexx.mod4.model.Category;
import ru.totalexx.mod4.web.api.model.request.CreateCategoryRequest;
import ru.totalexx.mod4.web.api.model.request.UpdateCategoryRequest;
import ru.totalexx.mod4.web.api.model.response.CategoryResponse;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CategoryMapper {

    Category toEntity(UpdateCategoryRequest request);

    Category toEntity(CreateCategoryRequest request);

    CategoryResponse toDto(Category category);

    default List<CategoryResponse> toCategoryResponses(List<Category> content) {
        return content.stream().map(this::toDto).toList();
    }
}
