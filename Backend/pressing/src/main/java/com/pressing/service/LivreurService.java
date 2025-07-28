package com.pressing.service;


import com.pressing.models.ArticleEntity;
import com.pressing.models.LivreurEntity;

import java.util.List;
import java.util.Optional;

public interface LivreurService {

    LivreurEntity saveLivreur(LivreurEntity livreur);

    List<LivreurEntity> getAllLivreur();

    Optional<LivreurEntity> getLivreurById(Integer id);

    void deleteLivreur(Integer id);
}
