package com.pressing.service;

import com.pressing.models.ArticleEntity;
import com.pressing.models.LigneArticle;

import java.util.List;
import java.util.Optional;

public interface LigneArticleService {

    LigneArticle saveLarticle(LigneArticle Larticle);

    List<LigneArticle> getAllLarticle();

    Optional<LigneArticle> getLarticleById(Integer id);

    void deleteLarticle(Integer id);



}
