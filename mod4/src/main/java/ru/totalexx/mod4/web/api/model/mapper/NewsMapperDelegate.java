package ru.totalexx.mod4.web.api.model.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.totalexx.mod4.model.News;
import ru.totalexx.mod4.service.CategoryService;
import ru.totalexx.mod4.service.UserService;
import ru.totalexx.mod4.web.api.model.request.CreateNewsRequest;
import ru.totalexx.mod4.web.api.model.request.UpdateNewsRequest;

@Component
public abstract class NewsMapperDelegate implements NewsMapper {

    @Autowired
    private UserService userService;
    @Autowired
    private CategoryService categoryService;

    public News toNews(CreateNewsRequest request) {
        News news = new News();
        news.setTitle(request.getTitle());
        news.setContent(request.getContent());
        news.setCategory(categoryService.getById(request.getCategoryId()));
        news.setAuthor(userService.getUserById(request.getAuthorId()));

        return news;
    }

    public News toNews(UpdateNewsRequest request) {
        News news = new News();
        news.setId(request.getId());
        news.setTitle(request.getTitle());
        news.setContent(request.getContent());
        news.setCategory(categoryService.getById(request.getCategoryId()));
        news.setAuthor(userService.getUserById(request.getAuthorId()));

        return news;
    }
}
