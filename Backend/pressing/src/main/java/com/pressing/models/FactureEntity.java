package com.pressing.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "Facture")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FactureEntity implements Serializable {

    @Id
    @GeneratedValue
    private int idFacture;

    @Column(nullable = false)
    private Date dateFacture;

    @Column(nullable = false)
    private Double montantTotal;

    @Column(nullable = true)
    private String formatPDF ;

    @OneToOne
    @JoinColumn(name = "commande_id")
    private CommandeEntity commande;
}
