package ru.totalexx.mod3.web.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class ContactListDto {
    private List<ContactDto> contacts;
}
