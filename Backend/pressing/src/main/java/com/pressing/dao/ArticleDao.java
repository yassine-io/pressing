package com.pressing.dao;

import com.pressing.models.ArticleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticleDao extends JpaRepository<ArticleEntity,Integer> {


}
