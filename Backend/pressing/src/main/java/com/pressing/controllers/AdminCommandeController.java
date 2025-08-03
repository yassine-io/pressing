package com.pressing.controllers;

import com.pressing.service.GerantService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/admin/commandes")
@RequiredArgsConstructor

public class AdminCommandeController {



        private final GerantService gerantService;

        @GetMapping("/{id}/facture")
        public ResponseEntity<byte[]> getFacture(@PathVariable Integer id) {
            byte[] pdf = gerantService.genererFactureCommande(id);

            return ResponseEntity.ok()
                    .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=facture-" + id + ".pdf")
                    .contentType(MediaType.APPLICATION_PDF)
                    .body(pdf);
        }
    }

