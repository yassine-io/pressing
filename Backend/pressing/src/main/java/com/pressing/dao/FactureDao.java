package com.pressing.dao;

import com.pressing.models.FactureEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FactureDao extends JpaRepository<FactureEntity,Integer> {



}
