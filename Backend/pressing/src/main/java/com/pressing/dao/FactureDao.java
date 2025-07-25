package com.pressing.dao;

import com.pressing.models.FactureEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FactureDao extends JpaRepository<FactureEntity,Integer> {



}
