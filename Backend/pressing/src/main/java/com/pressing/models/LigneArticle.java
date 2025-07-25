package com.pressing.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity
@Table(name = "LigneArticle")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LigneArticle implements Serializable {

    @Id
    @GeneratedValue
    private int idLigne;

    @Column(nullable = false)
    private int quantite;

    @Column(nullable = false)
    private double prixUnitaire;


    @ManyToOne
    @JoinColumn(name = "article_id")
    private ArticleEntity article;

    @ManyToOne
    @JoinColumn(name = "commande_id")
    private CommandeEntity commande;
}
