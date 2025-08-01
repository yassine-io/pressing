package com.pressing.dao;


import com.pressing.models.ClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ClientDao extends JpaRepository<ClientEntity,Integer> {

    ClientEntity findBynom(String nom) ;
    boolean existsByUsername(String login);
    Optional<ClientEntity> findByUsername(String login);


}
