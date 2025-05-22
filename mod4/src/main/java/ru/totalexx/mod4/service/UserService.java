package ru.totalexx.mod4.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import ru.totalexx.mod4.model.User;

public interface UserService {
    Page<User> getAllUsers(Pageable pageable);
    User getUserById(Long id);
    void createUser(User user);

    void updateUser(User user);

    void removeUser(Long id);
}

