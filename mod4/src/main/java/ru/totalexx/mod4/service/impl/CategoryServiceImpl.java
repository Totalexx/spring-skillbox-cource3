package ru.totalexx.mod4.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import ru.totalexx.mod4.exception.ServiceException;
import ru.totalexx.mod4.model.Category;
import ru.totalexx.mod4.repository.CategoryRepository;
import ru.totalexx.mod4.service.CategoryService;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    @Override
    public Page<Category> getAll(Pageable pageable) {
        return categoryRepository.findAll(pageable);
    }

    @Override
    public Category getById(Long id) {
        return categoryRepository.findById(id)
                .orElseThrow(() -> new ServiceException(HttpStatus.NOT_FOUND, "Category not found"));
    }

    @Override
    public void create(Category category) {
        categoryRepository.save(category);
    }

    @Override
    public void update(Category category) {
        if (!categoryRepository.existsById(category.getId())) {
            throw new ServiceException(HttpStatus.BAD_REQUEST, "Category not found");
        }

        categoryRepository.save(category);
    }

    @Override
    public void delete(Long id) {
        if (!categoryRepository.existsById(id)) {
            throw new ServiceException(HttpStatus.BAD_REQUEST, "Category not found");
        }

        categoryRepository.deleteById(id);
    }
}
