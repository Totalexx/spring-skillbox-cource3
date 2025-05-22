package ru.totalexx.mod4.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import ru.totalexx.mod4.aop.Authorized;
import ru.totalexx.mod4.exception.ServiceException;
import ru.totalexx.mod4.model.Comment;
import ru.totalexx.mod4.model.News;
import ru.totalexx.mod4.model.User;
import ru.totalexx.mod4.repository.CategoryRepository;
import ru.totalexx.mod4.repository.NewsRepository;
import ru.totalexx.mod4.repository.NewsSpecification;
import ru.totalexx.mod4.repository.UserRepository;
import ru.totalexx.mod4.service.CategoryService;
import ru.totalexx.mod4.service.NewsService;
import ru.totalexx.mod4.repository.model.NewsFilter;

@Service
@RequiredArgsConstructor
public class NewsServiceImpl implements NewsService {

    private final NewsRepository newsRepository;
    private final UserRepository userRepository;
    private final CategoryRepository categoryRepository;


    @Override
    public void createNews(News news) {
        if (news.getAuthor() == null) {
            throw new ServiceException(HttpStatus.BAD_REQUEST, "Author cannot be null");
        }

        if (!userRepository.existsById(news.getAuthor().getId())) {
            throw new ServiceException(HttpStatus.BAD_REQUEST, "Author with id " + news.getAuthor().getId() + " does not exist");
        }

        if (news.getCategory() == null) {
            throw new ServiceException(HttpStatus.BAD_REQUEST, "Category cannot be null");
        }

        if (!categoryRepository.existsById(news.getCategory().getId())) {
            throw new ServiceException(HttpStatus.BAD_REQUEST, "Category with id " + news.getCategory().getId() + " does not exist");
        }

        newsRepository.save(news);
    }

    @Override
    @Authorized(entityClass = News.class)
    public void updateNews(News news, User actor) {
        if (!newsRepository.existsById(news.getId())) {
            throw new ServiceException(HttpStatus.NOT_FOUND, "News with id " + news.getId() + " does not exist");
        }

        newsRepository.save(news);
    }

    @Override
    @Authorized(entityClass = News.class)
    public void removeNews(Long id, User actor) {
        if (!newsRepository.existsById(id)) {
            throw new ServiceException(HttpStatus.NOT_FOUND, "News with id " + id + " does not exist");
        }

        newsRepository.deleteById(id);
    }

    @Override
    public News getNewsById(Long id) {
        return newsRepository.findById(id)
                .orElseThrow(() -> new ServiceException(HttpStatus.NOT_FOUND, "News with id " + id + " does not exist"));
    }

    @Override
    public Page<News> getNews(Pageable pageable) {
        return newsRepository.findAll(pageable);
    }

    @Override
    public Page<News> getFilteredNews(NewsFilter filter) {
        PageRequest pageable = PageRequest.of(filter.getPage(), filter.getPageSize());
        return newsRepository.findAll(NewsSpecification.withFilter(filter), pageable);
    }
}
