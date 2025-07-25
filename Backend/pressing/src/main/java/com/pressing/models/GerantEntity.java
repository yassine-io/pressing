package com.pressing.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "Gerant")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GerantEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idGerant ;
    @Column(nullable = false)
    private String nom ;
    @Column(nullable = false)
    private String login ;
    @Column(nullable = false,name = "Password")
    private String motdepasse;

    @OneToMany(mappedBy = "gerant",cascade = CascadeType.ALL , fetch = FetchType.LAZY)
    private List<EmployeEntity> employes ;


}
