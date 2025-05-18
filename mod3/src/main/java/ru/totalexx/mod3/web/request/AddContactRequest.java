package ru.totalexx.mod3.web.request;

import lombok.Data;

import java.util.UUID;

@Data
public class AddContactRequest {
    private UUID id;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
}
