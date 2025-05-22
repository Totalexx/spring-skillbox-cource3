package ru.totalexx.mod4.repository.access;

import ru.totalexx.mod4.model.access.Owned;

import java.util.Optional;

public interface OwnedResolver<T extends Owned> {
    Class<T> getEntityClass();
    Optional<T> findById(Long id);
}
