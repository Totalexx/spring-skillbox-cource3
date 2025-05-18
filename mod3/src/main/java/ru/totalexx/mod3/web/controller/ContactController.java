package ru.totalexx.mod3.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ru.totalexx.mod3.model.Contact;
import ru.totalexx.mod3.service.ContactService;
import ru.totalexx.mod3.web.request.AddContactRequest;
import ru.totalexx.mod3.web.dto.ContactListDto;
import ru.totalexx.mod3.web.request.DeleteContactRequest;
import ru.totalexx.mod3.web.request.EditContactRequest;
import ru.totalexx.mod3.web.dto.mapper.ContactMapper;

import java.util.List;
import java.util.UUID;

@Controller
@RequiredArgsConstructor
public class ContactController {

    private final ContactService contactService;
    private final ContactMapper contactMapper;

    @GetMapping
    public String show(Model model) {
        List<Contact> contacts = contactService.getContacts();
        ContactListDto contactListDto = contactMapper.toContactListDto(contacts);
        model.addAttribute("contacts", contactListDto);

        return "show";
    }

    @GetMapping("add")
    public String add(Model model) {
        return "add-edit";
    }

    @PostMapping("add")
    public String add(AddContactRequest dto) {
        Contact contact = contactMapper.toEntity(dto);
        contactService.saveContact(contact);
        return "redirect:/";
    }

    @GetMapping("edit/{id}")
    public String edit(@PathVariable UUID id, Model model) {
        model.addAttribute("contact", contactService.getContact(id));
        return "add-edit";
    }

    @PostMapping("edit")
    public String edit(EditContactRequest dto) {
        Contact contact = contactMapper.toEntity(dto);
        contactService.saveContact(contact);
        return "redirect:/";
    }

    @PostMapping("delete")
    public String delete(DeleteContactRequest dto) {
        contactService.removeContact(dto.getId());
        return "redirect:/";
    }
}
