package com.pressing.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProfilUpdateRequest {
    private String nom;
    private String prenom;
    private String adresse;
    private String tel;
    private String password; // facultatif
}
