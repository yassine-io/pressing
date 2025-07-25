package com.pressing.dao;

import com.pressing.models.ArticleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleDao extends JpaRepository<ArticleEntity,Integer> {


}
