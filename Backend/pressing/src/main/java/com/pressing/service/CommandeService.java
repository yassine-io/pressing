package com.pressing.service;

import com.pressing.enums.StatutCommande;
import com.pressing.models.ArticleEntity;
import com.pressing.models.CommandeEntity;

import java.util.List;
import java.util.Optional;

public interface CommandeService {

    CommandeEntity saveCommande(CommandeEntity commande);

    List<CommandeEntity> getAllCommande();

    Optional<CommandeEntity> getArticleById(Integer id);

    void deleteCommande(Integer id);


    double calculerTotal(Integer idCommande);

    void changerStatut(Integer idCommande, StatutCommande nouveauStatut);
}
