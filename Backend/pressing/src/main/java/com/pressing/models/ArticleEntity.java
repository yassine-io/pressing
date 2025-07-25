package com.pressing.models;

import com.pressing.enums.TypeArticle;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "Articles")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ArticleEntity implements Serializable {

    @Id
    @GeneratedValue
    private int id;
    @Column(nullable = false)
    private String nom;
    @Column(nullable = false)
    private double prixBase;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TypeArticle Type ;

    @OneToMany(mappedBy = "article")
    private List<LigneArticle> lignesArticle;
}
