package com.pressing.service;

import com.pressing.enums.StatutLivraison;
import com.pressing.models.ArticleEntity;
import com.pressing.models.LivraisonEntity;

import java.util.List;
import java.util.Optional;

public interface LivraisonService {

    LivraisonEntity saveLivraison(LivraisonEntity livraison);

    List<LivraisonEntity> getAllLivraison();

    Optional<LivraisonEntity> getLivraisonById(Integer id);

    void deleteLivraison(Integer id);


    void changerStatutLivraison(Integer idLivraison, StatutLivraison nouveauStatut);
}
