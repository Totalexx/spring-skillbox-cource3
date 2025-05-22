package ru.totalexx.mod4.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.totalexx.mod4.model.Comment;
import ru.totalexx.mod4.repository.access.OwnedResolver;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findAllByNewsId(Long id);
}

