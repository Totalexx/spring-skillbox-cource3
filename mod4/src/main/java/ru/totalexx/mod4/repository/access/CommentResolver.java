package ru.totalexx.mod4.repository.access;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.totalexx.mod4.model.Comment;
import ru.totalexx.mod4.repository.CommentRepository;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class CommentResolver implements OwnedResolver<Comment> {

    private final CommentRepository commentRepository;

    @Override
    public Class<Comment> getEntityClass() {
        return Comment.class;
    }

    @Override
    public Optional<Comment> findById(Long id) {
        return commentRepository.findById(id);
    }
}
