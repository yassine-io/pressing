package com.pressing.dto;

import java.time.LocalDate;

public class CommandeResponse {
    private Integer id;
    private LocalDate dateCommande;
    private String statut;
    private List<ArticleCommandeDetailDto> articles;
}
