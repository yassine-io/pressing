package com.pressing.dao;

import com.pressing.models.CommandeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommandeDao extends JpaRepository<CommandeEntity,Integer> {


}
