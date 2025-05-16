package ru.totalexx.mod1.service;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import ru.totalexx.mod1.model.Contact;

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class ContactLoader {

    private final ContactService contactService;

    @Value("${load_file}")
    private String loadFile;

    public ContactLoader(ContactService contactService) {
        this.contactService = contactService;
    }

    @PostConstruct
    public void loadContacts() {
        ClassPathResource resource = new ClassPathResource(loadFile);
        try(Scanner file = new Scanner(new FileReader(resource.getFile()))) {
            while (file.hasNextLine()) {
                String contactLine = file.nextLine();
                String[] contactInfo = contactLine.split(";");
                Contact contact = new Contact(contactInfo[0], contactInfo[1], contactInfo[2]);
                contactService.addContact(contact);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
