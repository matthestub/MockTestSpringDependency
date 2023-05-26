package com.matthestub.article.model;

import java.time.LocalDateTime;

public record Article(
        Integer id,
        String title,
        String description,
        String slug,
        LocalDateTime createdOn
) {
}
