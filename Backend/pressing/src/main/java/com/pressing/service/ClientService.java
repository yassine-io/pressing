package com.pressing.service;

import com.pressing.dto.*;
import com.pressing.models.ArticleEntity;
import com.pressing.models.ClientEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public interface ClientService {

    // interface ClientService

    RegisterResponse register(RegisterRequest request);
    AuthResponse authenticate(AuthRequest request);

    NouvelleCommandeResponse passerCommande(NouvelleCommandeRequest request);
    List<CommandeResponse> getMesCommandes(Integer clientId);

    ProfilResponse getProfil(Integer clientId);
    ProfilResponse updateProfil(Integer clientId, ProfilUpdateRequest request);



}
