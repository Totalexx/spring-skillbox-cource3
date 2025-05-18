package ru.totalexx.mod3.service;

import ru.totalexx.mod3.model.Contact;

import java.util.List;
import java.util.UUID;

public interface ContactService {
    List<Contact> getContacts();
    Contact getContact(UUID id);
    void saveContact(Contact contact);
    void removeContact(UUID id);
}
