package ru.totalexx.mod3.web.dto.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import ru.totalexx.mod3.model.Contact;
import ru.totalexx.mod3.web.dto.ContactDto;
import ru.totalexx.mod3.web.dto.ContactListDto;
import ru.totalexx.mod3.web.request.AddContactRequest;
import ru.totalexx.mod3.web.request.EditContactRequest;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ContactMapper {

    ContactDto toDto(Contact contact);
    Contact toEntity(ContactDto contactDto);
    Contact toEntity(AddContactRequest request);
    Contact toEntity(EditContactRequest request);

    default ContactListDto toContactListDto(List<Contact> contacts) {
        return new ContactListDto(contacts.stream().map(this::toDto).toList());
    }
}
