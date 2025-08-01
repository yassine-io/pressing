package com.pressing.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommandeResponse {
    private Integer id;
    private LocalDate dateCommande;
    private String statut;
    private List<ArticleCommandeDetailDto> articles;
}
