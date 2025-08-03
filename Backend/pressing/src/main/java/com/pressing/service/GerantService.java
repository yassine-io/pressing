package com.pressing.service;

import com.pressing.dto.ArticleRequest;
import com.pressing.dto.ArticleResponse;
import com.pressing.dto.CommandeResponse;
import com.pressing.dto.ProfilResponse;
import com.pressing.models.ArticleEntity;
import com.pressing.models.GerantEntity;

import java.util.List;
import java.util.Optional;

public interface GerantService {

    // Gerant_Articles
    ArticleResponse creerArticle(ArticleRequest request);
    ArticleResponse modifierArticle(Integer id, ArticleRequest request);
    void supprimerArticle(Integer id);
    List<ArticleResponse> afficherArticles();

    // Gerant_Clients

    List<ProfilResponse> afficherTousLesClients();
    ProfilResponse consulterClientParId(Integer id);
    void supprimerClient(Integer id);

    //Gerant_Commandes
    List<CommandeResponse> listerToutesLesCommandes();

    CommandeResponse consulterCommandeParId(Integer id);

    CommandeResponse mettreAJourStatutCommande(Integer idCommande, String nouveauStatut);

    List<CommandeResponse> listerCommandesParStatut(String statut);

    //Genaration_Facture
    byte[] genererFactureCommande(Integer idCommande);




}
