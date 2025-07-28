package com.pressing.service;

import com.pressing.models.ArticleEntity;
import com.pressing.models.EmployeEntity;

import java.util.List;
import java.util.Optional;

public interface EmployeService {

    EmployeEntity saveEmploye(EmployeEntity employe);

    List<EmployeEntity> getAllEmploye();

    Optional<EmployeEntity> getEmployeById(Integer id);

    void deleteEmploye(Integer id);


}
