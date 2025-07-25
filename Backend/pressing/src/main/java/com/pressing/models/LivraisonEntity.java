package com.pressing.models;

import com.pressing.enums.StatutLivraison;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.IdGeneratorType;

import java.io.Serializable;
import java.util.Date;
@Entity
@Table(name = "Livraison")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LivraisonEntity implements Serializable {

    @Id
    @GeneratedValue
    private int idLivraison;

    @Column(nullable = false)
    private Date dateLivraison;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private StatutLivraison statutLivraison;

    @Column(nullable = false)
    private String adresseLivraison;

    @OneToOne
    @JoinColumn(name = "commande_id")
    private CommandeEntity commande;

    @ManyToOne
    @JoinColumn(name = "livreur_id")
    private LivreurEntity livreur;
}
