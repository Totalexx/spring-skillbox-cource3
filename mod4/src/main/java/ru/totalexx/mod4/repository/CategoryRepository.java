package ru.totalexx.mod4.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.totalexx.mod4.model.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
}

