package com.cg.FDS.service;

import java.util.List;

import com.cg.FDS.model.Category;

public interface ICategoryService {
	
	 Category addCategory(Category cat);
	 Category updateCategory(Category cat);
	 Category removeCategory(Category cat);
	 Category viewCategory(Category cat);
	 List<Category> viewAllCategory();

}
