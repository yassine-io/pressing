package com.pressing.controllers;

import com.pressing.dto.*;
import com.pressing.service.GerantService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/articles")
public class AdminArticleController {

    private final GerantService gerantService;

    public AdminArticleController(GerantService gerantService) {
        this.gerantService = gerantService;
    }

    @PostMapping
    public ResponseEntity<ArticleResponse> creerArticle(@RequestBody ArticleRequest request) {
        return ResponseEntity.ok(gerantService.creerArticle(request));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ArticleResponse> modifierArticle(@PathVariable Integer id, @RequestBody ArticleRequest request) {
        return ResponseEntity.ok(gerantService.modifierArticle(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> supprimerArticle(@PathVariable Integer id) {
        gerantService.supprimerArticle(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<ArticleResponse>> listerArticles() {
        return ResponseEntity.ok(gerantService.afficherArticles());
    }
}

