package ru.totalexx.mod4.repository;

import org.springframework.data.jpa.domain.Specification;
import ru.totalexx.mod4.model.News;
import ru.totalexx.mod4.repository.model.NewsFilter;

public interface NewsSpecification {

    static Specification<News> withFilter(NewsFilter filter) {
        return Specification.where(withCategoryId(filter.getCategoryId()))
                .and(withAuthorId(filter.getAuthorId()));
    }

    static Specification<News> withCategoryId(Long categoryId) {
        return (root, query, cb) -> {
            if (categoryId == null) {
                return null;
            }
            return cb.equal(root.get("category").get("id"), categoryId);
        };
    }

    static Specification<News> withAuthorId(Long authorId) {
        return (root, query, cb) -> {
            if (authorId == null) {
                return null;
            }
            return cb.equal(root.get("author").get("id"), authorId);
        };
    }
}
