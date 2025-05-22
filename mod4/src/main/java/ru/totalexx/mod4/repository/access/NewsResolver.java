package ru.totalexx.mod4.repository.access;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.totalexx.mod4.model.News;
import ru.totalexx.mod4.repository.NewsRepository;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class NewsResolver implements OwnedResolver<News> {

    private final NewsRepository newsRepository;

    @Override
    public Class<News> getEntityClass() {
        return News.class;
    }

    @Override
    public Optional<News> findById(Long id) {
        return newsRepository.findById(id);
    }
}
