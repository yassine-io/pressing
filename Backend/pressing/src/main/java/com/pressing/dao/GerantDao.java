package com.pressing.dao;

import com.pressing.models.GerantEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GerantDao extends JpaRepository<GerantEntity,Integer> {

}
