package com.pressing.service.impl;

import com.pressing.dao.ClientDao;
import com.pressing.dto.*;
import com.pressing.models.ClientEntity;
import com.pressing.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class ClientServiceImpl implements ClientService {

    @Override
    public RegisterResponse register(RegisterRequest request) {
        return null;
    }

    @Override
    public AuthResponse authenticate(AuthRequest request) {
        return null;
    }

    @Override
    public NouvelleCommandeResponse passerCommande(NouvelleCommandeRequest request) {
        return null;
    }

    @Override
    public List<CommandeResponse> getMesCommandes(Integer clientId) {
        return List.of();
    }

    @Override
    public ProfilResponse getProfil(Integer clientId) {
        return null;
    }

    @Override
    public ProfilResponse updateProfil(Integer clientId, ProfilUpdateRequest request) {
        return null;
    }
}