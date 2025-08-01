package com.pressing.service.impl;

import com.pressing.dao.ClientDao;
import com.pressing.dao.CommandeDao;
import com.pressing.dto.*;
import com.pressing.models.ClientEntity;
import com.pressing.service.ClientService;
import com.pressing.service.CommandeService;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class ClientServiceImpl implements ClientService {
    private final ClientDao clientRepository;
    private final CommandeDao commandeRepository;
    private final ModelMapper modelMapper;
    private final CommandeService commandeService;

    public ClientServiceImpl(ClientDao clientRepository, CommandeDao commandeRepository, ModelMapper modelMapper, CommandeService commandeService) {
        this.clientRepository = clientRepository;
        this.commandeRepository = commandeRepository;
        this.modelMapper = modelMapper;
        this.commandeService = commandeService;
    }

    @Override
    public RegisterResponse register(RegisterRequest request) {
        // 1. Vérifier si le login est déjà utilisé
        if (clientRepository.existsByUsername(request.getUsername())) {
            throw new RuntimeException("Ce username est déjà utilisé !");
        }

        // 2. mapper le dto vers l'entity
        ClientEntity client = modelMapper.map(request,ClientEntity.class);


        //4 . sauvgarder dans la base
        ClientEntity saved = clientRepository.save(client);

        // 5. Créer la réponse
        RegisterResponse response = new RegisterResponse();
        response.setId(saved.getId());
        response.setMessage("Inscription réussie");

        return response;

    }

    @Override
    public AuthResponse authenticate(AuthRequest request) {
        // 1. Vérifier si l'utilisateur existe
        ClientEntity client = clientRepository.findByUsername(request.getUsername())
                .orElseThrow(() -> new RuntimeException("Nom d'utilisateur ou mot de passe incorrect !"));

        // 2. Vérifier le mot de passe
        if (!client.getPassword().equals(request.getPassword())) {
            throw new RuntimeException("Nom d'utilisateur ou mot de passe incorrect !");
        }

        // 3. Créer la réponse
        AuthResponse response = new AuthResponse();
        response.setId(client.getId());
        response.setNom(client.getNom());
        response.setPrenom(client.getPrenom());
        response.setMessage("Authentification réussie");

        return response;


    }

    @Override
    public NouvelleCommandeResponse passerCommande(NouvelleCommandeRequest request) {
        return commandeService.passerCommande(request);
    }

    @Override
    public List<CommandeResponse> getMesCommandes(Integer clientId) {
        return commandeService.getMesCommandes(clientId);
    }

    @Override
    public ProfilResponse getProfil(Integer clientId) {
        ClientEntity client = clientRepository.findById(clientId)
                .orElseThrow(() -> new RuntimeException("Client introuvable avec l'ID : " + clientId));

        ProfilResponse response = new ProfilResponse();
        response.setId(client.getId());
        response.setNom(client.getNom());
        response.setPrenom(client.getPrenom());
        response.setAdresse(client.getAdresse());
        response.setLogin(client.getUsername());
        response.setTel(client.getTel());

        return response;
    }


    @Override
    @Transactional
    public ProfilResponse updateProfil(Integer clientId, ProfilUpdateRequest request) {
        ClientEntity client = clientRepository.findById(clientId)
                .orElseThrow(() -> new RuntimeException("Client introuvable avec l'ID : " + clientId));

        client.setNom(request.getNom());
        client.setPrenom(request.getPrenom());
        client.setAdresse(request.getAdresse());
        client.setTel(request.getTel());

        // Aucun encodage, on enregistre directement le mot de passe
        if (request.getPassword() != null && !request.getPassword().isBlank()) {
            client.setPassword(request.getPassword());
        }

        return mapToProfilResponse(client);
    }

    private ProfilResponse mapToProfilResponse(ClientEntity client) {
        ProfilResponse response = new ProfilResponse();
        response.setId(client.getId());
        response.setNom(client.getNom());
        response.setPrenom(client.getPrenom());
        response.setAdresse(client.getAdresse());
        response.setLogin(client.getUsername());
        response.setTel(client.getTel());
        return response;
    }

}