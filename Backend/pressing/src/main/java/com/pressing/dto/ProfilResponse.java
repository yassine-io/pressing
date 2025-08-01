package com.pressing.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProfilResponse {
    private Integer id;
    private String nom;
    private String prenom;
    private String adresse;
    private String login;
    private String tel;
}
