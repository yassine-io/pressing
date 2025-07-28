package com.pressing.service.impl;

import com.pressing.dao.GerantDao;
import com.pressing.models.GerantEntity;
import com.pressing.service.GerantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GerantImpl implements GerantService {

    private final GerantDao gerantRepository;
    @Autowired
    public GerantImpl(GerantDao gerantRepository) {
        this.gerantRepository = gerantRepository;
    }

    @Override
    public GerantEntity saveGerant(GerantEntity gerant) {
        return gerantRepository.save(gerant);
    }

    @Override
    public List<GerantEntity> getAllGerant() {
        return gerantRepository.findAll();
    }

    @Override
    public Optional<GerantEntity> getGerantById(Integer id) {
        return gerantRepository.findById(id);
    }

    @Override
    public void deleteGerant(Integer id) {
        gerantRepository.deleteById(id);

    }
}
