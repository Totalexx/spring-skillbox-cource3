package ru.totalexx.mod3.repository;

import ru.totalexx.mod3.model.Contact;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ContactRepository {
    Optional<Contact> find(UUID id);
    List<Contact> findAll();
    Contact save(Contact contact);
    void delete(UUID id);
}
