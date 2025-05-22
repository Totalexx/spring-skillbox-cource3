package ru.totalexx.mod4.repository;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import ru.totalexx.mod4.model.News;
import ru.totalexx.mod4.repository.access.OwnedResolver;

import java.util.Optional;

@Repository
public interface NewsRepository extends JpaRepository<News, Long>, JpaSpecificationExecutor<News>{

    @EntityGraph(attributePaths = {"comments", "author", "category"})
    Optional<News> findById(Long id);
}

