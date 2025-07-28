package com.pressing.dao;

import com.pressing.models.EmployeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface EmployeDao extends JpaRepository<EmployeEntity,Integer> {
}
