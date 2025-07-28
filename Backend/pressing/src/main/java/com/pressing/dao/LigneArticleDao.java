package com.pressing.dao;

import com.pressing.models.LigneArticle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LigneArticleDao extends JpaRepository<LigneArticle,Integer> {

}
