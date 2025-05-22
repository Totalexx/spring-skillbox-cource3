package ru.totalexx.mod4.web.api.model.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetAllUsersResponse {
    private List<UserResponse> users;
    private int totalPages;
}
