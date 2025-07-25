package com.pressing.dao;

import com.pressing.models.EmployeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeDao extends JpaRepository<EmployeEntity,Integer> {
}
