package com.pressing.dto;

import com.pressing.enums.ModePaiement;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NouvelleCommandeRequest {
    private Integer clientId;
    private List<CommandeArticleDto> articles;
    private ModePaiement modePaiement;
    private String adresseLivraison; // null si retrait
}
