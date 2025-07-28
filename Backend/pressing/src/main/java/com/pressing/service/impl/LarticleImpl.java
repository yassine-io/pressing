package com.pressing.service.impl;

import com.pressing.dao.LigneArticleDao;
import com.pressing.models.LigneArticle;
import com.pressing.service.LigneArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LarticleImpl implements LigneArticleService {
    private final LigneArticleDao ligneArticleRepository;
    @Autowired
    public LarticleImpl(LigneArticleDao ligneArticleRepository) {
        this.ligneArticleRepository = ligneArticleRepository;
    }

    @Override
    public LigneArticle saveLarticle(LigneArticle ligne) {
        return ligneArticleRepository.save(ligne);
    }

    @Override
    public List<LigneArticle> getAllLarticle() {
        return ligneArticleRepository.findAll();
    }

    @Override
    public Optional<LigneArticle> getLarticleById(Integer id) {
        return ligneArticleRepository.findById(id);
    }

    @Override
    public void deleteLarticle(Integer id) {
        ligneArticleRepository.deleteById(id);
    }
}
