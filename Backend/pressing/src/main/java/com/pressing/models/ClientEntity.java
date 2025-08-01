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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_client")
    private Integer id ;
    @Column(nullable = false)
    private String nom ;
    @Column(nullable = false)
    private String prenom ;
    @Column(nullable = false)
    private String tel ;
    @Column(nullable = false , name= "login")
    private String username ;
    @Column(nullable = false)
    private String adresse ;
    @Column(nullable = false , name = "password")
    private String password ;

    @OneToMany(mappedBy = "client" ,cascade = CascadeType.ALL , fetch = FetchType.LAZY )
    private List<CommandeEntity> comandes ;

}
