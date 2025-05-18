package ru.totalexx.mod3.web.request;

import lombok.Data;

import java.util.UUID;

@Data
public class DeleteContactRequest {
    private UUID id;
}
