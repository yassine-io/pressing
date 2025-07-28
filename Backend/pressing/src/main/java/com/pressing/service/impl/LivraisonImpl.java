package com.pressing.service.impl;

import com.pressing.dao.LivraisonDao;
import com.pressing.enums.StatutLivraison;
import com.pressing.models.LivraisonEntity;
import com.pressing.service.LivraisonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LivraisonImpl implements LivraisonService {

    private final LivraisonDao livraisonRepository;

    @Autowired
    public LivraisonImpl(LivraisonDao livraisonRepository) {
        this.livraisonRepository = livraisonRepository;
    }

    @Override
    public LivraisonEntity saveLivraison(LivraisonEntity livraison) {
        return livraisonRepository.save(livraison);    }

    @Override
    public List<LivraisonEntity> getAllLivraison() {
        return livraisonRepository.findAll();    }

    @Override
    public Optional<LivraisonEntity> getLivraisonById(Integer id) {
        return livraisonRepository.findById(id);
    }

    @Override
    public void deleteLivraison(Integer id) {
        livraisonRepository.deleteById(id);
    }

    @Override
    public void changerStatutLivraison(Integer idLivraison, StatutLivraison nouveauStatut) {
        Optional<LivraisonEntity> optional = livraisonRepository.findById(idLivraison);
        if (optional.isPresent()) {
            LivraisonEntity livraison = optional.get();
            livraison.setStatutLivraison(nouveauStatut);
            livraisonRepository.save(livraison);
        } else {
            throw new RuntimeException("Livraison introuvable");
        }
    }







}
