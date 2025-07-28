package com.pressing.service;

import com.pressing.models.ArticleEntity;
import com.pressing.models.FactureEntity;

import java.util.List;
import java.util.Optional;

public interface FactureService {

    FactureEntity saveFacture(FactureEntity facture);

    List<FactureEntity> getAllFacture();

    Optional<FactureEntity> getFactureById(Integer id);

    void deleteFacture(Integer id);

}
