package com.pressing.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NouvelleCommandeResponse {
    private Integer commandeId;
    private String statut; // ex : "Commande enregistrée"
}
