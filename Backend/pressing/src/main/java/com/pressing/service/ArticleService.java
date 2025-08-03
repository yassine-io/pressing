package com.pressing.service;

import com.pressing.dto.ArticleRequest;
import com.pressing.dto.ArticleResponse;
import com.pressing.models.ArticleEntity;

import java.util.List;
import java.util.Optional;

public interface ArticleService {

        ArticleResponse ajouterArticle(ArticleRequest request);
        ArticleResponse modifierArticle(Integer id, ArticleRequest request);
        void supprimerArticle(Integer id);
        List<ArticleResponse> listerArticles();
    }

