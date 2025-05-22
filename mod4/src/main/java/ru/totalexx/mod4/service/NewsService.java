package ru.totalexx.mod4.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import ru.totalexx.mod4.model.News;
import ru.totalexx.mod4.model.User;
import ru.totalexx.mod4.repository.model.NewsFilter;

public interface NewsService {
    void createNews(News news);
    void updateNews(News news, User actor);
    void removeNews(Long id, User actor);
    News getNewsById(Long id);
    Page<News> getNews(Pageable pageable);
    Page<News> getFilteredNews(NewsFilter filter);
}

