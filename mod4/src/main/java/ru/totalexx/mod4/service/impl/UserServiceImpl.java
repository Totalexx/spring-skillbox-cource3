package ru.totalexx.mod4.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import ru.totalexx.mod4.exception.ServiceException;
import ru.totalexx.mod4.model.User;
import ru.totalexx.mod4.repository.UserRepository;
import ru.totalexx.mod4.service.UserService;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public Page<User> getAllUsers(Pageable pageable) {
        return userRepository.findAll(pageable);
    }

    @Override
    public User getUserById(Long id) {
        return userRepository
                .findById(id)
                .orElseThrow(() -> new ServiceException(HttpStatus.NOT_FOUND, "User with id " + id + " not found"));
    }

    @Override
    public void createUser(User user) {
        userRepository.save(user);
    }

    @Override
    public void updateUser(User user) {
        if (!userRepository.existsById(user.getId())) {
            throw new ServiceException(HttpStatus.BAD_REQUEST, "User with id " + user.getId() + " not found");
        }

        userRepository.save(user);
    }

    @Override
    public void removeUser(Long id) {
        if (!userRepository.existsById(id)) {
            throw new ServiceException(HttpStatus.BAD_REQUEST, "User with id " + id + " not found");
        }

        userRepository.deleteById(id);
    }
}
