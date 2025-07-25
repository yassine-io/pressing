package com.pressing.models;


import jakarta.persistence.*;
import lombok.*;

import java.util.List;
@Entity
@Table(name = "Clients")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class ClientEntity {

    @Id
    private int idClient ;
    @Column(nullable = false)
    private String nom ;
    @Column(nullable = false)
    private String prenom ;
    @Column(nullable = false)
    private String tel ;
    @Column(nullable = false , name= "login")
    private String email ;
    @Column(nullable = false)
    private String adresse ;
    @Column(nullable = false , name = "password")
    private String motdepasse ;

    @OneToMany(mappedBy = "client" ,cascade = CascadeType.ALL , fetch = FetchType.LAZY )
    private List<CommandeEntity> comandes ;

}
