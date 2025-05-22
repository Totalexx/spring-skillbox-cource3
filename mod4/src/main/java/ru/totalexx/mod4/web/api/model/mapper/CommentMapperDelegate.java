package ru.totalexx.mod4.web.api.model.mapper;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.totalexx.mod4.model.Comment;
import ru.totalexx.mod4.repository.NewsRepository;
import ru.totalexx.mod4.repository.UserRepository;
import ru.totalexx.mod4.web.api.model.request.CreateCommentRequest;
import ru.totalexx.mod4.web.api.model.request.UpdateCommentRequest;

@Component
public abstract class CommentMapperDelegate implements CommentMapper {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private NewsRepository newsRepository;

    public Comment toEntity(CreateCommentRequest request) {
        Comment comment = new Comment();
        comment.setComment(request.getComment());
        comment.setNews(newsRepository.getReferenceById(request.getNewsId()));
        comment.setAuthor(userRepository.getReferenceById(request.getAuthorId()));

        return comment;
    }

    public Comment toEntity(UpdateCommentRequest request) {
        Comment comment = new Comment();
        comment.setId(request.getId());
        comment.setComment(request.getComment());
        comment.setNews(newsRepository.findById(request.getNewsId()).orElseThrow());
        comment.setAuthor(userRepository.findById(request.getAuthorId()).orElseThrow());

        return comment;
    }
}
