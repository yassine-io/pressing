package com.pressing.dto;

import com.pressing.enums.TypeArticle;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ArticleResponse {
    private Integer id;
    private String nom;
    private double prixBase;
    private TypeArticle type;
}
