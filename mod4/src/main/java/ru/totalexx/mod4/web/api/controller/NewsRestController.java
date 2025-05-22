package ru.totalexx.mod4.web.api.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.totalexx.mod4.model.News;
import ru.totalexx.mod4.model.User;
import ru.totalexx.mod4.service.NewsService;
import ru.totalexx.mod4.repository.model.NewsFilter;
import ru.totalexx.mod4.web.api.model.mapper.NewsMapper;
import ru.totalexx.mod4.web.api.model.request.*;
import ru.totalexx.mod4.web.api.model.response.GetAllNewsFilteredResponse;
import ru.totalexx.mod4.web.api.model.response.GetAllNewsResponse;
import ru.totalexx.mod4.web.api.model.response.NewsResponse;

import java.util.List;

@RestController
@RequestMapping("api/v1/news")
@RequiredArgsConstructor
public class NewsRestController {

    private final NewsService newsService;
    private final NewsMapper newsMapper;

    @GetMapping("get/all")
    public GetAllNewsResponse getAllNews(GetAllNewsRequest request) {
        Page<News> news = newsService.getNews(PageRequest.of(request.getPage(), request.getPageSize()));
        List<NewsResponse> newsResponses = newsMapper.toNewsListResponse(news.getContent());

        return new GetAllNewsResponse(newsResponses, news.getTotalElements());
    }

    @GetMapping("get/filtered")
    public GetAllNewsFilteredResponse getAllNews(GetAllNewsFilteredRequest request) {
        NewsFilter filter = new NewsFilter(request.getPage(), request.getPageSize(),
                request.getCategoryId(), request.getAuthorId());

        Page<News> news = newsService.getFilteredNews(filter);
        List<NewsResponse> newsResponses = newsMapper.toNewsListResponse(news.getContent());

        return new GetAllNewsFilteredResponse(newsResponses, news.getTotalElements());
    }

    @GetMapping("get")
    public NewsResponse getNews(NewsRequest request) {
        News news = newsService.getNewsById(request.getId());

        return newsMapper.toResponse(news);
    }

    @PostMapping("create")
    public ResponseEntity<Void> createNews(CreateNewsRequest request) {
        News news = newsMapper.toNews(request);
        newsService.createNews(news);

        return ResponseEntity.ok().build();
    }

    @PostMapping("update")
    public ResponseEntity<Void> updateNews(UpdateNewsRequest request) {
        User user = new User();
        user.setId(request.getAuthorId());
        user.setPassword(request.getPassword());

        News news = newsMapper.toNews(request);
        newsService.updateNews(news, user);

        return ResponseEntity.ok().build();
    }

    @PostMapping("delete")
    public ResponseEntity<Void> deleteNews(DeleteNewsRequest request) {
        User user = new User();
        user.setId(request.getAuthorId());
        user.setPassword(request.getPassword());

        newsService.removeNews(request.getId(), user);

        return ResponseEntity.ok().build();
    }
}
