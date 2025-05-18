package ru.totalexx.mod3.web.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class ContactDto {
    private UUID id;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
}
