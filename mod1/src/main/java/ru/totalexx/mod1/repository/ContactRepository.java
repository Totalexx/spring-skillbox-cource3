package ru.totalexx.mod1.repository;

import org.springframework.stereotype.Component;
import ru.totalexx.mod1.model.Contact;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Component
public class ContactRepository {

    private final Map<String, Contact> contactByEmail = new HashMap<>();

    public void addContact(Contact contact) {
        contactByEmail.put(contact.getEmail(), contact);
    }

    public Set<Contact> getContacts() {
        return new HashSet<>(contactByEmail.values());
    }

    public void removeContact(String email) throws IllegalArgumentException {
        if (this.contactByEmail.containsKey(email))
            this.contactByEmail.remove(email);
        else
            throw new IllegalArgumentException("Контакт не найден");
    }
}
