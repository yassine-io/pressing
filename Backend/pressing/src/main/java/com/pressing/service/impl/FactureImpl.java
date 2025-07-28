package com.pressing.service.impl;

import com.pressing.dao.FactureDao;
import com.pressing.models.FactureEntity;
import com.pressing.service.FactureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.PrivateKey;
import java.util.List;
import java.util.Optional;

@Service
public class FactureImpl implements FactureService {

    private final FactureDao factureRepository;

    @Autowired
    public FactureImpl(FactureDao factureRepository) {
        this.factureRepository = factureRepository;
    }

    @Override
    public FactureEntity saveFacture(FactureEntity facture) {
        return factureRepository.save(facture);    }

    @Override
    public List<FactureEntity> getAllFacture() {
        return factureRepository.findAll();
    }

    @Override
    public Optional<FactureEntity> getFactureById(Integer id) {
        return factureRepository.findById(id);
    }

    @Override
    public void deleteFacture(Integer id) {
        factureRepository.deleteById(id);
    }
}
