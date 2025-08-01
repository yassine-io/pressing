package com.pressing.dao;

import com.pressing.models.CommandeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommandeDao extends JpaRepository<CommandeEntity,Integer> {

    // Trouver les commandes d’un client (triées par date décroissante)
    List<CommandeEntity> findByClient_IdOrderByDateCommandeDesc(Integer clientId);
    List<CommandeEntity> findByClientId(Integer clientId);


}
