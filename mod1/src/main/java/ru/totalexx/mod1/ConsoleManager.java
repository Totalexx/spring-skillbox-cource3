package ru.totalexx.mod1;

import org.springframework.stereotype.Component;
import ru.totalexx.mod1.model.Contact;
import ru.totalexx.mod1.service.ContactService;

import java.util.Map;
import java.util.Scanner;

@Component
public class ConsoleManager {

    private final Map<String, Runnable> commands = Map.of(
            "print", this::printContacts,
            "help", this::printHelp,
            "add", this::addContact,
            "remove", this::removeContact,
            "save", this::saveToFile
    );  

    private final Scanner scanner = new Scanner(System.in);

    private final ContactService contactService;

    public ConsoleManager(ContactService contactService) {
        this.contactService = contactService;
    }

    public void process() {
        printGreetings();
        printHelp();
        while (true) {
            parseCommand();
        }
    }

    private void parseCommand() {
        String command = scanner.nextLine();
        if (commands.containsKey(command)) {
            try {
                commands.get(command).run();
            } catch (RuntimeException e) {
                System.out.println("Произошла ошибка при выполнении команды:");
                System.out.println(e.getMessage());
            }
        } else {
            System.out.println("Неизвестная команда: " + command);
        }
    }

    private void printGreetings() {
        System.out.println("---- Приложение КОНТАКТЫ ----");
    }

    private void printHelp() {
        System.out.println("Помощь по командам:");
    }

    private void printContacts() {
        contactService.printContacts();
    }

    private void addContact() {
        System.out.println("Введите контакт в формате: ФИО;Телефон;Email");
        String contactData = scanner.nextLine();
        String[] data = contactData.split(";");

        if (data.length != 3) {
            System.out.println("Неправильный формат ввода. Отмена операции.");
            return;
        }

        Contact contact = new Contact(data[0], data[1], data[2]);
        contactService.addContact(contact);
        System.out.println("Добавлен новый контакт");
    }

    private void removeContact() {
        System.out.println("Введите email контакта для удаления");
        String email = scanner.nextLine();
        contactService.removeContact(email);
        System.out.println("Контакт удалён");
    }

    private void saveToFile(){
        System.out.println("Сохранение в файл...");
        contactService.saveContactsToFile();
        System.out.println("Сохранено");
    }
}
