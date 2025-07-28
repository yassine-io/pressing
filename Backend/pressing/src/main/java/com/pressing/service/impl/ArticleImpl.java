package com.pressing.service.impl;

import com.pressing.dao.ArticleDao;
import com.pressing.models.ArticleEntity;
import com.pressing.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ArticleImpl implements ArticleService {

    private final ArticleDao articleRepository;
    @Autowired
    public ArticleImpl(ArticleDao articleRepository) {
        this.articleRepository = articleRepository;
    }

    @Override
    public ArticleEntity saveArticle(ArticleEntity article) {
        return articleRepository.save(article);
    }

    @Override
    public List<ArticleEntity> getAllArticle() {
        return articleRepository.findAll();
    }

    @Override
    public Optional<ArticleEntity> getArticleById(Integer id) {
        return articleRepository.findById(id);
    }

    @Override
    public void deleteArticle(Integer id) {
        articleRepository.deleteById(id);
    }
}
