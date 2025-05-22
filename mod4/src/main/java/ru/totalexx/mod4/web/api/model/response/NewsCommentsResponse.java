package ru.totalexx.mod4.web.api.model.response;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class NewsCommentsResponse {
    private List<CommentResponse> comments;
}
