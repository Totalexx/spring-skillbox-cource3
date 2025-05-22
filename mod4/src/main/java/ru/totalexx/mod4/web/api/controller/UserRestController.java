package ru.totalexx.mod4.web.api.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.totalexx.mod4.model.User;
import ru.totalexx.mod4.service.UserService;
import ru.totalexx.mod4.web.api.model.request.UserRequest;
import ru.totalexx.mod4.web.api.model.mapper.UserMapper;
import ru.totalexx.mod4.web.api.model.request.CreateUserRequest;
import ru.totalexx.mod4.web.api.model.request.GetAllUsersRequest;
import ru.totalexx.mod4.web.api.model.request.DeleteUserRequest;
import ru.totalexx.mod4.web.api.model.request.UpdateUserRequest;
import ru.totalexx.mod4.web.api.model.response.GetAllUsersResponse;
import ru.totalexx.mod4.web.api.model.response.UserResponse;

@RestController
@RequestMapping("api/v1/user")
@RequiredArgsConstructor
public class UserRestController {

    private final UserService userService;
    private final UserMapper userMapper;


    @GetMapping("get/all")
    public GetAllUsersResponse getAllUsers(GetAllUsersRequest request) {
        PageRequest pageable = PageRequest.of(request.getPage(), request.getPageSize());
        Page<User> allUsers = userService.getAllUsers(pageable);

        return userMapper.toGetAllUserResponse(allUsers);
    }

    @GetMapping("get")
    public UserResponse getUserById(UserRequest request) {
        User user = userService.getUserById(request.getId());

        return userMapper.toResponse(user);
    }

    @PostMapping("create")
    public ResponseEntity<Void> createUser(CreateUserRequest request) {
        User user = userMapper.toUser(request);
        userService.createUser(user);

        return ResponseEntity.ok().build();
    }

    @PutMapping("update")
    public ResponseEntity<Void> updateUser(UpdateUserRequest request) {
        User user = userMapper.toUser(request);
        userService.updateUser(user);

        return ResponseEntity.ok().build();
    }

    @DeleteMapping("delete")
    public ResponseEntity<Void> deleteUser(DeleteUserRequest request) {
        userService.removeUser(request.getId());

        return ResponseEntity.ok().build();
    }
}
