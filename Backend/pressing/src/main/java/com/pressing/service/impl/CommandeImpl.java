package com.pressing.service.impl;

import com.pressing.dao.ArticleDao;
import com.pressing.dao.ClientDao;
import com.pressing.dao.CommandeDao;
import com.pressing.dto.*;
import com.pressing.enums.StatutCommande;
import com.pressing.enums.StatutLivraison;
import com.pressing.models.*;
import com.pressing.service.CommandeService;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CommandeImpl implements CommandeService {

    private final CommandeDao commandeRepository;
    private final ArticleDao articleRepository;
    private final ClientDao clientRepository;
    private final ModelMapper modelMapper;


    @Autowired
    public CommandeImpl(CommandeDao commandeRepository, ArticleDao articleRepository, ClientDao clientRepository, ModelMapper modelMapper) {
        this.commandeRepository = commandeRepository;
        this.articleRepository = articleRepository;
        this.clientRepository = clientRepository;
        this.modelMapper = modelMapper;
    }
/*
    @Override
    public CommandeEntity saveCommande(CommandeEntity commande) {
        return commandeRepository.save(commande);
    }

    @Override
    public List<CommandeEntity> getAllCommande() {
        return commandeRepository.findAll();
    }

    @Override
    public Optional<CommandeEntity> getArticleById(Integer id) {
        return commandeRepository.findById(id);
    }

    @Override
    public void deleteCommande(Integer id) {
        commandeRepository.deleteById(id);
    }

    @Override
    public double calculerTotal(Integer idCommande) {
        Optional<CommandeEntity> optional = commandeRepository.findById(idCommande);
        if (optional.isPresent()) {
            CommandeEntity commande = optional.get();
            double total = commande.getLigneArticleList().stream()
                    .mapToDouble(l -> l.getQuantite() * l.getPrixUnitaire())
                    .sum();
            commande.setTotal(total);
            commandeRepository.save(commande);
            return total;
        }
        throw new RuntimeException("Commande introuvable");
    }

    @Override
    public void changerStatut(Integer idCommande, StatutCommande nouveauStatut) {
        Optional<CommandeEntity> optional = commandeRepository.findById(idCommande);
        if (optional.isPresent()) {
            CommandeEntity commande = optional.get();
            commande.setStatut(nouveauStatut);
            commandeRepository.save(commande);
        } else {
            throw new RuntimeException("Commande introuvable");
        }
    }
    */
// new
    @Override
    @Transactional
    public NouvelleCommandeResponse passerCommande(NouvelleCommandeRequest request) {

        ClientEntity client = getClient(request.getClientId());
        CommandeEntity commande = initialiserCommande(request, client);
        List<LigneArticle> lignes = creerLignesCommande(request, commande);
        double total = calculerTotal(lignes);

        commande.setLigneArticleList(lignes);
        commande.setTotal(total);

        if (requiertLivraison(request)) {
            LivraisonEntity livraison = creerLivraison(request, commande);
            commande.setLivraison(livraison);
        }

        CommandeEntity saved = commandeRepository.save(commande);

        return new NouvelleCommandeResponse(saved.getIdCommande(), "Commande enregistrée");


    }


    @Override
    public List<CommandeEntity> getCommandesClient(Integer clientId) {
        return commandeRepository.findByClient_IdOrderByDateCommandeDesc(clientId);
    }

    @Override
    public Optional<CommandeEntity> getCommandeById(Integer idCommande) {
        return commandeRepository.findById(idCommande);
    }

    @Override
    @Transactional
    public CommandeEntity changerStatutCommande(Integer idCommande, StatutCommande nouveauStatut) {
        CommandeEntity commande = commandeRepository.findById(idCommande)
                .orElseThrow(() -> new RuntimeException("Commande introuvable"));
        commande.setStatut(nouveauStatut);
        return commandeRepository.save(commande);
    }

    @Override
    public double calculerTotalCommande(Integer idCommande) {
        CommandeEntity commande = commandeRepository.findById(idCommande)
                .orElseThrow(() -> new RuntimeException("Commande introuvable"));
        return commande.getLigneArticleList().stream()
                .mapToDouble(l -> l.getPrixUnitaire() * l.getQuantite())
                .sum();
    }

    @Override
    @Transactional
    public CommandeEntity annulerCommande(Integer idCommande) {
        CommandeEntity commande = commandeRepository.findById(idCommande)
                .orElseThrow(() -> new RuntimeException("Commande introuvable"));
        commande.setStatut(StatutCommande.ANNULEE);
        return commandeRepository.save(commande);
    }



    // 🔽 Méthodes privées pour la logique métier

        private ClientEntity getClient(Integer clientId) {
            return clientRepository.findById(clientId)
                    .orElseThrow(() -> new RuntimeException("Client introuvable"));
        }

    private CommandeEntity initialiserCommande(NouvelleCommandeRequest request, ClientEntity client) {
        CommandeEntity commande = new CommandeEntity();
        commande.setClient(client);
        commande.setDateCommande(new Date());
        commande.setStatut(StatutCommande.RECEPTIONNEE);
        commande.setModePaiement(request.getModePaiement());
        return commande;
    }

    private List<LigneArticle> creerLignesCommande(NouvelleCommandeRequest request, CommandeEntity commande) {
        List<LigneArticle> lignes = new ArrayList<>();

        for (CommandeArticleDto dto : request.getArticles()) {
            if (dto.getQuantite() <= 0) continue;

            ArticleEntity article = articleRepository.findById(dto.getArticleId())
                    .orElseThrow(() -> new RuntimeException("Article introuvable : " + dto.getArticleId()));

            LigneArticle ligne = new LigneArticle();
            ligne.setCommande(commande);
            ligne.setArticle(article);
            ligne.setQuantite(dto.getQuantite());
            ligne.setPrixUnitaire(article.getPrixBase());

            lignes.add(ligne);
        }

        if (lignes.isEmpty()) {
            throw new RuntimeException("Aucun article sélectionné");
        }

        return lignes;
    }

    private double calculerTotal(List<LigneArticle> lignes) {
        return lignes.stream()
                .mapToDouble(l -> l.getQuantite() * l.getPrixUnitaire())
                .sum();
    }

    private boolean requiertLivraison(NouvelleCommandeRequest request) {
        return request.getAdresseLivraison() != null && !request.getAdresseLivraison().isBlank();
    }

    private LivraisonEntity creerLivraison(NouvelleCommandeRequest request, CommandeEntity commande) {
        LivraisonEntity livraison = new LivraisonEntity();
        livraison.setCommande(commande);
        livraison.setAdresseLivraison(request.getAdresseLivraison());
        livraison.setStatutLivraison(StatutLivraison.EN_ATTENTE);
        return livraison;
    }




    public List<CommandeResponse> getMesCommandes(Integer clientId) {
        List<CommandeEntity> commandes = commandeRepository.findByClientId(clientId);

        return commandes.stream()
                .map(this::convertToCommandeResponse)
                .collect(Collectors.toList());
    }

    private CommandeResponse convertToCommandeResponse(CommandeEntity commande) {
        CommandeResponse dto = new CommandeResponse();
        dto.setId(commande.getIdCommande());
        dto.setDateCommande(commande.getDateCommande().toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate());
        dto.setStatut(commande.getStatut().name());

        // convertir ligneArticleList -> articles
        List<ArticleCommandeDetailDto> articles = commande.getLigneArticleList()
                .stream()
                .map(article -> modelMapper.map(article, ArticleCommandeDetailDto.class))
                .collect(Collectors.toList());
        dto.setArticles(articles);

        return dto;
    }






}
