package com.cg.FDS.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cg.FDS.model.Category;


public interface ICategoryRepository extends JpaRepository<Category,String>{
	

	
	
	@Query("select c.categoryName from Category c ")
	public List<Category> viewAllCategory();

}
