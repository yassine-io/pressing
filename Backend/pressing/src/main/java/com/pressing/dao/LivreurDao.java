package com.pressing.dao;

import com.pressing.models.LivreurEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface LivreurDao extends JpaRepository<LivreurEntity,Integer> {

}
