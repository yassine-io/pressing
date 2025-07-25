package com.pressing.models;

import com.pressing.enums.PosteEmploye;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "employes")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String nom;

    @Column(nullable = false)
    private String prenom;

    @Column(nullable = false)
    private String telephone;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private PosteEmploye poste;

    @ManyToOne
    @JoinColumn(name="gerant_id")
    private GerantEntity gerant ;


}
