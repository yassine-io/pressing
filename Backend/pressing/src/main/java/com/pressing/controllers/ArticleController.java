package com.pressing.controllers;

import com.pressing.models.ArticleEntity;
import com.pressing.models.ClientEntity;
import com.pressing.service.ArticleService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/article")
public class ArticleController {


    private final ArticleService articleService ;


    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }

    @GetMapping
    public List<ArticleEntity> getAllArticles() {
        return articleService.getAllArticle();
    }
    @PostMapping
    public ArticleEntity addArticle(@RequestBody ArticleEntity article) {
        return articleService.saveArticle(article);
    }

    @DeleteMapping("/{id}")
    public void deleteArticle(@PathVariable Integer id) {
        articleService.deleteArticle(id);
    }


}
