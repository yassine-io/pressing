package com.pressing.service;

import com.pressing.models.ArticleEntity;
import com.pressing.models.GerantEntity;

import java.util.List;
import java.util.Optional;

public interface GerantService {

    GerantEntity saveGerant(GerantEntity gerant);

    List<GerantEntity> getAllGerant();

    Optional<GerantEntity> getGerantById(Integer id);

    void deleteGerant(Integer id);
}
