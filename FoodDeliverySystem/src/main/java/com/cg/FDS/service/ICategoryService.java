package com.cg.FDS.service;

import java.util.List;

import com.cg.FDS.model.Category;

public interface ICategoryService {

	Category addCategory(Category cat);

	Category updateCategory(Category cat);

	Category removeCategory(String catId);

	Category viewCategory(String catId);

	List<Category> viewAllCategory();

}
