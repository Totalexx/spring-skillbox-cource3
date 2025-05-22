package ru.totalexx.mod4.web.api.model.request;

import lombok.Data;

@Data
public class UpdateUserRequest {
    private Long id;
    private String username;
    private String email;
}

