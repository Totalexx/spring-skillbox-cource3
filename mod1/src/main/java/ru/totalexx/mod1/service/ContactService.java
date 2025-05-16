package ru.totalexx.mod1.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import ru.totalexx.mod1.model.Contact;
import ru.totalexx.mod1.repository.ContactRepository;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Set;

@Component
public class ContactService {

    @Value("${save_folder}")
    private String saveFolder;

    private final ContactRepository contactRepository;

    public ContactService(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    public void printContacts() {
        System.out.println("Контакты:");
        contactRepository.getContacts().forEach(c -> {
            System.out.println(formatContact(c));
        });
    }

    public void addContact(Contact contact) {
        contactRepository.addContact(contact);
    }

    public void removeContact(String email) {
        contactRepository.removeContact(email);
    }

    public void saveContactsToFile() {
        try {
            Set<Contact> contacts = contactRepository.getContacts();

            String fileName = String.format("contacts-%s.txt", System.currentTimeMillis());
            File saveFolder = new File(this.saveFolder);
            saveFolder.mkdirs();

            String filePath = Path.of(this.saveFolder, fileName).toString();
            FileWriter fileWriter = new FileWriter(filePath);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            for (Contact contact : contacts) {
                bufferedWriter.write(formatContact(contact));
                bufferedWriter.newLine();
            }

            bufferedWriter.close();
            fileWriter.close();
        } catch (IOException e) {
            throw new RuntimeException("Произошла ошибка при записи файла.", e);
        }
    }

    private String formatContact(Contact contact) {
        return String.format("%s;%s;%s", contact.getFullName(), contact.getPhone(), contact.getEmail());
    }
}
