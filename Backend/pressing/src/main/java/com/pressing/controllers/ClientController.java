package com.pressing.controllers;


import com.pressing.dto.*;
import com.pressing.models.ClientEntity;
import com.pressing.service.ClientService;
import com.pressing.service.CommandeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/client")
public class ClientController {

    private final ClientService clientService;

    public ClientController(ClientService clientService, CommandeService commandeService) {
        this.clientService = clientService;

    }

    @GetMapping("/{clientId}/mes-commandes")
    public ResponseEntity<List<CommandeResponse>> getMesCommandes(@PathVariable Integer clientId) {
        return ResponseEntity.ok(clientService.getMesCommandes(clientId));
    }

    @GetMapping("/{clientId}/profil")
    public ResponseEntity<ProfilResponse> getProfil(@PathVariable Integer clientId) {
        return ResponseEntity.ok(clientService.getProfil(clientId));
    }

    @PutMapping("/{clientId}/profil")
    public ResponseEntity<ProfilResponse> updateProfil(
            @PathVariable Integer clientId,
            @RequestBody ProfilUpdateRequest request
    ) {
        return ResponseEntity.ok(clientService.updateProfil(clientId, request));
    }
    @PostMapping("/commande/nouvelle")
    public ResponseEntity<NouvelleCommandeResponse> passerCommande(
            @RequestBody NouvelleCommandeRequest request) {
        NouvelleCommandeResponse response = clientService.passerCommande(request);
        return ResponseEntity.ok(response);
    }

    // Inscription
    @PostMapping("/register")
    public ResponseEntity<RegisterResponse> register(@RequestBody RegisterRequest request) {
        RegisterResponse response = clientService.register(request);
        return ResponseEntity.ok(response);
    }
    // Authentification
    @PostMapping("/login")
    public ResponseEntity<AuthResponse> authenticate(@RequestBody AuthRequest request) {
        AuthResponse response = clientService.authenticate(request);
        return ResponseEntity.ok(response);
    }


}
