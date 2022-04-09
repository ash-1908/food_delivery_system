package com.cg.FDS.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.cg.FDS.dao.ICategoryRepository;
import com.cg.FDS.model.Category;


public class ICategoryServiceImpl implements  ICategoryService {
	
	@Autowired
	ICategoryRepository catRepo;


	@Override
	public Category addCategory(Category cat) {
		// TODO Auto-generated method stub
		catRepo.save(cat);
		return cat;
	}

	@Override
	public Category updateCategory(Category cat) {
		// TODO Auto-generated method stub
		
		if(catRepo.existsById(cat.getCatId())) {
			catRepo.save(cat);
			return cat;
			
		}
		return null;
	}

	@Override
	public Category removeCategory(Category cat) {
		// TODO Auto-generated method stub
		if(catRepo.existsById(cat.getCatId())) {
			catRepo.deleteById(cat.getCatId());
			return cat;
		}
		
		return null;
	}
	

	@Override
	public Category viewCategory(Category cat) {
		// TODO Auto-generated method stub
		System.out.println(cat);
		return cat;
		
	}

	@Override
	public List<Category> viewAllCategory() {
		// TODO Auto-generated method stub
		List<Category> categoryList = catRepo.viewAllCategory();
		for(Category c: categoryList)
			System.out.println(c);
		return categoryList;
	
	}
	
	

}
