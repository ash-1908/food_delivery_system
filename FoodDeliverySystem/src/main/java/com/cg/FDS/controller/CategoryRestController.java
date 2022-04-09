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

import com.cg.FDS.model.Category;
import com.cg.FDS.service.ICategoryServiceImpl;



@RestController
@CrossOrigin("*")
public class CategoryRestController {
	
	@Autowired
	ICategoryServiceImpl cserv;
	
	@PostMapping("/category/add")
	public Category addCategory(@RequestBody Category cat) {
		return cserv.addCategory(cat);
	}
	
	@PutMapping("/category/update")
	public Category updateCategory(@RequestBody Category cat) {
		return cserv.updateCategory(cat);
	}
	
	@DeleteMapping("/category/remove")
	public Category removeCategory(@RequestBody Category cat ) {
		return cserv.removeCategory(cat);
	}
	@GetMapping("/category/view")
	public Category viewCategory(@RequestBody Category cat) {
		return cserv.viewCategory(cat);
	}
	@GetMapping("/category/view/all")
	public List<Category> viewAllCategory() {
		return cserv.viewAllCategory();
	}
	
}
