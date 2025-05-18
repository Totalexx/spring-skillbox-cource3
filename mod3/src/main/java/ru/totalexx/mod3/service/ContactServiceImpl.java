package ru.totalexx.mod3.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.totalexx.mod3.model.Contact;
import ru.totalexx.mod3.repository.ContactRepository;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ContactServiceImpl implements ContactService {

    private final ContactRepository contactRepository;

    @Override
    public List<Contact> getContacts() {
        return contactRepository.findAll();
    }

    @Override
    public Contact getContact(UUID id) {
        return contactRepository.find(id).orElseThrow(() -> new RuntimeException("Contact not found"));
    }

    @Override
    public void saveContact(Contact contact) {
        contactRepository.save(contact);
    }

    @Override
    public void removeContact(UUID id) {
        contactRepository.delete(id);
    }
}
