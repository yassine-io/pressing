package com.pressing.service;

import com.pressing.models.ArticleEntity;

import java.util.List;
import java.util.Optional;

public interface ArticleService {

    ArticleEntity saveArticle(ArticleEntity article);

    List<ArticleEntity> getAllArticle();

    Optional<ArticleEntity> getArticleById(Integer id);

    void deleteArticle(Integer id);
}
