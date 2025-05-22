package ru.totalexx.mod4.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import ru.totalexx.mod4.model.Category;
import java.util.List;

public interface CategoryService {
    Page<Category> getAll(Pageable pageable);
    Category getById(Long id);
    void create(Category category);
    void update(Category category);
    void delete(Long id);
}

