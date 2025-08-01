package com.pressing.service;

import com.pressing.dto.CommandeResponse;
import com.pressing.dto.NouvelleCommandeRequest;
import com.pressing.dto.NouvelleCommandeResponse;
import com.pressing.enums.StatutCommande;
import com.pressing.models.ArticleEntity;
import com.pressing.models.CommandeEntity;
import com.pressing.models.LigneArticle;

import java.util.List;
import java.util.Optional;

public interface CommandeService {

    /*
    CommandeEntity saveCommande(CommandeEntity commande);

    List<CommandeEntity> getAllCommande();

    Optional<CommandeEntity> getArticleById(Integer id);

    void deleteCommande(Integer id);


    double calculerTotal(Integer idCommande);


   void changerStatut(Integer idCommande, StatutCommande nouveauStatut);
  */


    // 1. Passer une nouvelle commande (depuis l’espace client)
    NouvelleCommandeResponse passerCommande(NouvelleCommandeRequest request);

    // 2. Récupérer toutes les commandes d’un client
    List<CommandeEntity> getCommandesClient(Integer clientId);

    // 3. Récupérer une commande par son ID
    Optional<CommandeEntity> getCommandeById(Integer idCommande);

    // 4. Changer le statut d’une commande (REÇUE → EN_LAVAGE → etc.)
    CommandeEntity changerStatutCommande(Integer idCommande, StatutCommande nouveauStatut);

    // 5. Calculer le total d’une commande (peut être déjà fait dans le setter aussi)
    double calculerTotalCommande(Integer idCommande);

    // 6. Annuler une commande
    CommandeEntity annulerCommande(Integer idCommande);

    List<CommandeResponse> getMesCommandes(Integer clientId);


}

