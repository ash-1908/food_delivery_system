package com.cg.FDS.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cg.FDS.model.Category;

@Repository
public interface ICategoryRepository extends JpaRepository<Category, String> {

	@Query("FROM Category")
	List<Category> viewAllCategory();

}
