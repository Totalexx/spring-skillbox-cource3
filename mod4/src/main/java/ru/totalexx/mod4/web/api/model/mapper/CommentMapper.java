package ru.totalexx.mod4.web.api.model.mapper;

import org.mapstruct.DecoratedWith;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import ru.totalexx.mod4.model.Comment;
import ru.totalexx.mod4.web.api.model.request.CreateCommentRequest;
import ru.totalexx.mod4.web.api.model.request.UpdateCommentRequest;
import ru.totalexx.mod4.web.api.model.response.CommentResponse;

import java.util.List;

@DecoratedWith(CommentMapperDelegate.class)
@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        uses = {UserMapper.class}
)
public interface CommentMapper {

    CommentResponse toResponse(Comment comment);

    List<CommentResponse> toResponse(List<Comment> comments);

    Comment toEntity(CreateCommentRequest request);

    Comment toEntity(UpdateCommentRequest request);
}
