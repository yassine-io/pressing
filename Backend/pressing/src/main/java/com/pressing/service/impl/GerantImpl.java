package com.pressing.service.impl;

import com.lowagie.text.*;
import com.lowagie.text.pdf.*;
import com.lowagie.text.Document ;
import com.pressing.dao.ClientDao;
import com.pressing.dao.CommandeDao;
import com.pressing.dto.ArticleRequest;
import com.pressing.dto.ArticleResponse;
import com.pressing.dto.CommandeResponse;
import com.pressing.dto.ProfilResponse;
import com.pressing.enums.StatutCommande;
import com.pressing.models.ClientEntity;
import com.pressing.models.CommandeEntity;
import com.pressing.models.LigneArticle;
import com.pressing.service.ArticleService;
import com.pressing.service.GerantService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class GerantImpl implements GerantService {

    private final ArticleService articleService;
    private final ClientDao clientDao ;
    private final ModelMapper modelMapper;
    private final CommandeDao commandeDao ;



    public GerantImpl(ArticleService articleService, ClientDao clientDao, ModelMapper modelMapper, CommandeDao commandeDao) {
        this.articleService = articleService;
        this.clientDao = clientDao;
        this.modelMapper = modelMapper;
        this.commandeDao = commandeDao;
    }

    // GestionArticles
    @Override
    public ArticleResponse creerArticle(ArticleRequest request) {
        return articleService.ajouterArticle(request);
    }

    @Override
    public ArticleResponse modifierArticle(Integer id, ArticleRequest request) {
        return articleService.modifierArticle(id, request);
    }

    @Override
    public void supprimerArticle(Integer id) {
        articleService.supprimerArticle(id);
    }

    @Override
    public List<ArticleResponse> afficherArticles() {
        return articleService.listerArticles();
    }



    //Gestion Client
    @Override
    public List<ProfilResponse> afficherTousLesClients() {
        List<ClientEntity> clients = clientDao.findAll();
        return clients.stream()
                .map(client -> modelMapper.map(client, ProfilResponse.class))
                .collect(Collectors.toList());
    }

    @Override
    public ProfilResponse consulterClientParId(Integer id) {
        ClientEntity client = clientDao.findById(id)
                .orElseThrow(() -> new RuntimeException("Client introuvable"));
        return modelMapper.map(client, ProfilResponse.class);
    }

    @Override
    public void supprimerClient(Integer id) {
        clientDao.deleteById(id);
    }

    //Gestion Commande
    @Override
    public List<CommandeResponse> listerToutesLesCommandes() {
        List<CommandeEntity> commandes = commandeDao.findAll();

        return commandes.stream().map(commande -> {
            CommandeResponse response = modelMapper.map(commande, CommandeResponse.class);
            response.setStatut(commande.getStatut().name()); // enum to string
            return response;
        }).collect(Collectors.toList());
    }

    @Override
    public CommandeResponse consulterCommandeParId(Integer id) {
        CommandeEntity commande = commandeDao.findById(id)
                .orElseThrow(() -> new RuntimeException("Commande introuvable"));

        CommandeResponse response = modelMapper.map(commande, CommandeResponse.class);
        response.setStatut(commande.getStatut().name());

        return response;
    }


    @Override
    public CommandeResponse mettreAJourStatutCommande(Integer idCommande, String nouveauStatut) {
        CommandeEntity commande = commandeDao.findById(idCommande)
                .orElseThrow(() -> new RuntimeException("Commande introuvable"));

        StatutCommande statut;
        try {
            statut = StatutCommande.valueOf(nouveauStatut.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new RuntimeException("Statut non valide !");
        }

        commande.setStatut(statut);
        commandeDao.save(commande);

        CommandeResponse response = modelMapper.map(commande, CommandeResponse.class);
        response.setStatut(commande.getStatut().name());

        return response;
    }
    @Override
    public List<CommandeResponse> listerCommandesParStatut(String statut) {
        StatutCommande statutCommande;

        try {
            statutCommande = StatutCommande.valueOf(statut.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new RuntimeException("Statut non valide !");
        }

        List<CommandeEntity> commandes = commandeDao.findByStatut(statutCommande);

        return commandes.stream()
                .map(commande -> {
                    CommandeResponse response = modelMapper.map(commande, CommandeResponse.class);
                    response.setStatut(commande.getStatut().name());
                    return response;
                })
                .collect(Collectors.toList());
    }

    @Override
    public byte[] genererFactureCommande(Integer idCommande) {
        CommandeEntity commande = commandeDao.findById(idCommande)
                .orElseThrow(() -> new RuntimeException("Commande introuvable"));

        try (ByteArrayOutputStream out = new ByteArrayOutputStream()) {
            Document document = new Document();
            PdfWriter.getInstance(document, out);
            document.open();

            // Titre
            Font titleFont = new Font(Font.HELVETICA, 18, Font.BOLD);
            document.add(new Paragraph("Facture Commande #" + commande.getIdCommande(), titleFont));
            document.add(new Paragraph("Date : " + commande.getDateCommande()));
            document.add(new Paragraph("Client : " + commande.getClient().getNom() + " " + commande.getClient().getPrenom()));
            document.add(Chunk.NEWLINE);

            // Tableau des articles
            PdfPTable table = new PdfPTable(4);
            table.setWidthPercentage(100);
            table.setWidths(new float[]{3, 1, 2, 2});

            table.addCell("Article");
            table.addCell("Qté");
            table.addCell("Prix Unitaire");
            table.addCell("Total");

            double total = 0.0;

            for (LigneArticle ligne : commande.getLigneArticleList()) {
                String nomArticle = ligne.getArticle().getNom();
                int qte = ligne.getQuantite();
                double prixU = ligne.getPrixUnitaire();
                double totalLigne = qte * prixU;
                total += totalLigne;

                table.addCell(nomArticle);
                table.addCell(String.valueOf(qte));
                table.addCell(prixU + " MAD");
                table.addCell(totalLigne + " MAD");
            }

            document.add(table);
            document.add(Chunk.NEWLINE);

            // Total général
            Font totalFont = new Font(Font.HELVETICA, 12, Font.BOLD);
            document.add(new Paragraph("Total à payer : " + total + " MAD", totalFont));

            document.add(Chunk.NEWLINE);
            document.add(new Paragraph("Merci pour votre confiance !"));

            document.close();
            return out.toByteArray();

        } catch (Exception e) {
            throw new RuntimeException("Erreur lors de la génération de la facture : " + e.getMessage());
        }
    }




}
