package com.pressing.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommandeArticleDto {
    private Integer articleId;
    private Integer quantite;
}
