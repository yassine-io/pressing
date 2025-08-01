package com.pressing.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuthResponse {
    private Integer id;
    private String nom;
    private String prenom;
    private String message;
    //private String token; // si tu ajoutes JWT plus tard
}
