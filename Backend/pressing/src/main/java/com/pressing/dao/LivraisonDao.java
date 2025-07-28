package com.pressing.dao;

import com.pressing.models.LivraisonEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LivraisonDao extends JpaRepository<LivraisonEntity,Integer> {

}
