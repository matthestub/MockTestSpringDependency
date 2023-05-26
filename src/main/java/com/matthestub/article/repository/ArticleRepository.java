package com.matthestub.article.repository;

import com.matthestub.article.model.Article;
import com.matthestub.article.service.SimpleSlugService;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public class ArticleRepository {

    private final List<Article> articles;

    public ArticleRepository(SimpleSlugService simpleSlugService) {
        articles = List.of(
                new Article(1, "Hello World!", "Welcome to my new Blog!", simpleSlugService.slugify("Hello World!"), LocalDateTime.now()),
                new Article(2, "Spring Initializr", "About initializing spring projects", simpleSlugService.slugify("Spring Initializr"), LocalDateTime.now()),
                new Article(3, "Dependency Injection", "Rules with dependencies", simpleSlugService.slugify("Dependency Injection"), LocalDateTime.now())
        );
    }


    public List<Article> findAll() {
        return articles;
    }

    public Article findById(Integer id) {
        return articles.stream()
                .filter(article -> article.id().equals(id)).findFirst().orElse(null);
    }

}
