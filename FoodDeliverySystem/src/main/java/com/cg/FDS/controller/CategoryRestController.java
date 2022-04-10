package com.cg.FDS.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.FDS.dao.ICategoryRepository;
import com.cg.FDS.exception.category.CategoryAlreadyExists;
import com.cg.FDS.exception.category.CategoryNotFoundException;
import com.cg.FDS.exception.category.NullCategoryException;
import com.cg.FDS.exception.restaurant.NullRestaurantException;
import com.cg.FDS.exception.restaurant.RestaurantAlreadyExists;
import com.cg.FDS.exception.restaurant.RestaurantNotFoundException;
import com.cg.FDS.model.Category;
import com.cg.FDS.model.Restaurant;
import com.cg.FDS.service.ICategoryServiceImpl;



@RestController
@CrossOrigin("*")
public class CategoryRestController {
	
	@Autowired
	ICategoryServiceImpl cserv;
	
	ICategoryRepository catRepo;
	
	@PostMapping("/category/add")
	public Category addCategory(@RequestBody Category cat) {
try {
			
			if(catRepo.existsById(cat.getCatId())) {
				throw new CategoryAlreadyExists("Category Already exists");
				
			}
		}
	
			catch(CategoryAlreadyExists e) {
				System.out.println(e.getMessage());
			}
			return cserv.addCategory(cat);
	}
	
	@PutMapping("/category/update")
	public Category updateCategory(@RequestBody Category cat) {
		Category c=cat;
		try {
			
			if(catRepo.existsById(cat.getCatId())) {
				c = cserv.updateCategory(c);
				return c;
			}
			else {
				throw new CategoryNotFoundException("Category not found");
			}
			}
			catch(CategoryNotFoundException e) {
				System.out.println(e.getMessage());
			}
			return c;
	}
	
	@DeleteMapping("/category/remove")
	public Category removeCategory(@RequestBody Category cat ) {
		try {
			if(!catRepo.existsById(cat.getCatId())) {
				throw new CategoryNotFoundException("Category does not exists to remove");
			}
		}
		catch(CategoryNotFoundException e) {
			System.out.println(e.getMessage());
		}	
		return cserv.removeCategory(cat);
	
	}
	@GetMapping("/category/view")
	public Category viewCategory(@RequestBody Category cat) {
		Category c=cat;
		try {
			
			if(catRepo.existsById(cat.getCatId())) {
				c= cserv.viewCategory(c);
				return c;
			}
			else {
				throw new NullCategoryException("Category does not exists");
			}
			}
			catch(NullCategoryException e) {
				System.out.println(e.getMessage());
			}
			return c;
	}
	@GetMapping("/category/view/all")
	public List<Category> viewAllCategory() {
		return cserv.viewAllCategory();
	}
	
}
