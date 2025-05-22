package ru.totalexx.mod4.web.api.model.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.springframework.data.domain.Page;
import ru.totalexx.mod4.model.User;
import ru.totalexx.mod4.web.api.model.request.CreateUserRequest;
import ru.totalexx.mod4.web.api.model.request.UpdateUserRequest;
import ru.totalexx.mod4.web.api.model.response.GetAllUsersResponse;
import ru.totalexx.mod4.web.api.model.response.UserResponse;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface UserMapper {

    UserResponse toResponse(User user);

    default GetAllUsersResponse toGetAllUserResponse(Page<User> users) {
        List<UserResponse> userResponses = toUserResponse(users.getContent());
        return new GetAllUsersResponse(userResponses, users.getTotalPages());
    }

    default List<UserResponse> toUserResponse(List<User> users) {
        return users.stream().map(this::toResponse).toList();
    }

    User toUser(CreateUserRequest request);

    User toUser(UpdateUserRequest request);
}
