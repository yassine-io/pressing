package com.pressing.dao;


import com.pressing.models.ClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientDao extends JpaRepository<ClientEntity,Integer> {

    ClientEntity findBynom(String nom) ;





}
