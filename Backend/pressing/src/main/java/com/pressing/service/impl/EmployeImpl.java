package com.pressing.service.impl;

import com.pressing.dao.EmployeDao;
import com.pressing.models.EmployeEntity;
import com.pressing.service.EmployeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeImpl implements EmployeService {

    private final EmployeDao employeRepository;

    @Autowired
    public EmployeImpl(EmployeDao employeRepository) {
        this.employeRepository = employeRepository;
    }

    @Override
    public EmployeEntity saveEmploye(EmployeEntity employe) {
        return employeRepository.save(employe);
    }

    @Override
    public List<EmployeEntity> getAllEmploye() {
        return employeRepository.findAll();
    }

    @Override
    public Optional<EmployeEntity> getEmployeById(Integer id) {
        return employeRepository.findById(id);
    }

    @Override
    public void deleteEmploye(Integer id) {
        employeRepository.deleteById(id);
    }
}
