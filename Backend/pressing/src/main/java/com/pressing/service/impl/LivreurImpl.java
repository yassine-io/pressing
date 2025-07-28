package com.pressing.service.impl;

import com.pressing.dao.LivraisonDao;
import com.pressing.dao.LivreurDao;
import com.pressing.models.LivreurEntity;
import com.pressing.service.LivreurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LivreurImpl implements LivreurService {
    private final LivreurDao livreurRepository;

    @Autowired
    public LivreurImpl(LivreurDao livreurRepository) {
        this.livreurRepository = livreurRepository;
    }

    @Override
    public LivreurEntity saveLivreur(LivreurEntity livreur) {
        return livreurRepository.save(livreur);
    }

    @Override
    public List<LivreurEntity> getAllLivreur() {
        return livreurRepository.findAll();
    }

    @Override
    public Optional<LivreurEntity> getLivreurById(Integer id) {
        return livreurRepository.findById(id);
    }

    @Override
    public void deleteLivreur(Integer id) {
        livreurRepository.deleteById(id);
    }
}
