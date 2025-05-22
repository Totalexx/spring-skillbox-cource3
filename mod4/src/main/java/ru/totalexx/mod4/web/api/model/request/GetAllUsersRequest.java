package ru.totalexx.mod4.web.api.model.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllUsersRequest {
    private int page;
    private int pageSize = 10;
}

