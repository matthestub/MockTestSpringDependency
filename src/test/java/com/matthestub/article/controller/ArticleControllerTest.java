package com.matthestub.article.controller;

import com.matthestub.article.model.Article;
import com.matthestub.article.repository.ArticleRepository;
import org.junit.jupiter.api.*;
import org.mockito.Mockito;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@WebMvcTest(ArticleController.class)
class ArticleControllerTest {

    private ArticleController articleController;
    private List<Article> articleList;

    @MockBean
    ArticleRepository articleRepository;

    @BeforeEach
    void setUp() {
        articleController = new ArticleController(articleRepository);
        articleList = List.of(
                new Article(1, "Hello World!", "Welcome to my new Blog!", "hello-World", LocalDateTime.now()),
                new Article(2, "Spring Initializr", "About initializing spring projects", "spring Initializr", LocalDateTime.now()),
                new Article(3, "Dependency Injection", "Rules with dependencies", "dependency-injection", LocalDateTime.now())
        );
    }


    @Test
    void shouldReturnAllArticles() {
        Mockito.when(articleController.getAllArticles()).thenReturn(articleList);
        assertEquals(3, articleList.spliterator().getExactSizeIfKnown());
    }

    @Test
    void shouldReturnOneArticle() {
        Mockito.when(articleController.getArticleById(2)).thenReturn(articleList.get(2));
        Article article = articleController.getArticleById(2);
        assertNotNull(article);
    }
}