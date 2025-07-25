package com.pressing.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "Livreur")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LivreurEntity implements Serializable {

    @Id
    @GeneratedValue
    private int idLivreur;

    @Column(nullable = false)
    private String nom;

    @Column(nullable = false)
    private String prenom;

    @Column(nullable = false, unique = true)
    private String telephone;

    @OneToMany(mappedBy = "livreur")
    private List<LivraisonEntity> livraisons;
}
