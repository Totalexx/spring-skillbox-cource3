package ru.totalexx.mod4.web.api.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.totalexx.mod4.model.Category;
import ru.totalexx.mod4.service.CategoryService;
import ru.totalexx.mod4.web.api.model.mapper.CategoryMapper;
import ru.totalexx.mod4.web.api.model.request.*;
import ru.totalexx.mod4.web.api.model.response.CategoryResponse;
import ru.totalexx.mod4.web.api.model.response.GetAllCategoriesResponse;

import java.util.List;

@RestController
@RequestMapping("/api/v1/category")
@RequiredArgsConstructor
public class CategoryRestController {

    private final CategoryService categoryService;
    private final CategoryMapper categoryMapper;

    @GetMapping("get/all")
    public GetAllCategoriesResponse getAllCategories(GetAllCategoriesRequest request) {
        PageRequest pageRequest = PageRequest.of(request.getPage(), request.getPageSize());
        Page<Category> categories = categoryService.getAll(pageRequest);
        List<CategoryResponse> categoryResponses = categoryMapper.toCategoryResponses(categories.getContent());

        return new GetAllCategoriesResponse(categoryResponses, categories.getTotalPages());
    }

    @GetMapping("get")
    public CategoryResponse getCategory(CategoryRequest request) {
        Category category = categoryService.getById(request.getId());
        return categoryMapper.toDto(category);
    }

    @PostMapping("create")
    public ResponseEntity<Void> createCategory(CreateCategoryRequest request) {
        categoryService.create(categoryMapper.toEntity(request));

        return ResponseEntity.ok().build();
    }

    @PutMapping("update")
    public ResponseEntity<Void> updateCategory(UpdateCategoryRequest request) {
        categoryService.update(categoryMapper.toEntity(request));

        return ResponseEntity.ok().build();
    }

    @DeleteMapping("delete")
    public ResponseEntity<Void> deleteCategory(DeleteCategoryRequest request) {
        categoryService.delete(request.getId());

        return ResponseEntity.ok().build();
    }

}
