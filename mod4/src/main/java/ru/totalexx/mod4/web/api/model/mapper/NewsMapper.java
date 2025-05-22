package ru.totalexx.mod4.web.api.model.mapper;

import org.mapstruct.DecoratedWith;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import ru.totalexx.mod4.model.News;
import ru.totalexx.mod4.web.api.model.request.CreateNewsRequest;
import ru.totalexx.mod4.web.api.model.request.UpdateNewsRequest;
import ru.totalexx.mod4.web.api.model.response.NewsResponse;

import java.util.List;

@DecoratedWith(NewsMapperDelegate.class)
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE, uses = {CategoryMapper.class, UserMapper.class})
public interface NewsMapper {

    News toNews(CreateNewsRequest request);

    News toNews(UpdateNewsRequest request);

    NewsResponse toResponse(News news);

    default List<NewsResponse> toNewsListResponse(List<News> content) {
        return content.stream()
                .map(this::toResponse)
                .toList();
    }
}
