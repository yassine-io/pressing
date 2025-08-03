package com.pressing.service.impl;

import com.pressing.dao.ArticleDao;
import com.pressing.dto.ArticleRequest;
import com.pressing.dto.ArticleResponse;
import com.pressing.models.ArticleEntity;
import com.pressing.service.ArticleService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ArticleImpl implements ArticleService {

    private final ArticleDao articleDao;
    private final ModelMapper modelMapper ;

    public ArticleImpl(ArticleDao articleRepository, ModelMapper modelMapper) {
        this.articleDao = articleRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public ArticleResponse ajouterArticle(ArticleRequest request) {
        ArticleEntity article = modelMapper.map(request, ArticleEntity.class);
        articleDao.save(article);
        return modelMapper.map(article, ArticleResponse.class);
    }

    @Override
    public ArticleResponse modifierArticle(Integer id, ArticleRequest request) {
        ArticleEntity article = articleDao.findById(id)
                .orElseThrow(() -> new RuntimeException("Article introuvable"));

        article.setNom(request.getNom());
        article.setPrixBase(request.getPrixBase());
        article.setType(request.getType());

        articleDao.save(article);
        return modelMapper.map(article, ArticleResponse.class);
    }

    @Override
    public void supprimerArticle(Integer id) {
        articleDao.deleteById(id);
    }

    @Override
    public List<ArticleResponse> listerArticles() {
        return articleDao.findAll().stream()
                .map(article -> modelMapper.map(article, ArticleResponse.class))
                .collect(Collectors.toList());
    }
}
