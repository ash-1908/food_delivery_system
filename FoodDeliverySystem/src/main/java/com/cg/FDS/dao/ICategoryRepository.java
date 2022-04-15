package com.cg.FDS.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.FDS.model.Category;

@Repository
public interface ICategoryRepository extends JpaRepository<Category, String> {

}
