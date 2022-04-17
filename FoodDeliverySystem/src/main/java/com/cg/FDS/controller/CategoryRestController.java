package com.cg.FDS.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cg.FDS.model.Category;
import com.cg.FDS.service.ICategoryServiceImpl;

@RestController
@CrossOrigin("*")
public class CategoryRestController {

	@Autowired
	ICategoryServiceImpl catServ;

	@PostMapping("/category/new")
	public ResponseEntity<Category> addCategory(@RequestBody Category cat) {

		return new ResponseEntity<Category>(catServ.addCategory(cat), HttpStatus.OK);
	}

	@PutMapping("/category/update")
	public ResponseEntity<Category> updateCategory(@RequestBody Category cat) {

		return new ResponseEntity<Category>(catServ.updateCategory(cat), HttpStatus.OK);
	}

	@DeleteMapping("/category/remove")
	public ResponseEntity<Category> removeCategory(@RequestParam String catId) {

		return new ResponseEntity<Category>(catServ.removeCategory(catId), HttpStatus.OK);
	}

	@GetMapping("/category/view")
	public ResponseEntity<Category> viewCategory(@RequestParam String catId) {

		return new ResponseEntity<Category>(catServ.viewCategory(catId), HttpStatus.OK);
	}

	@GetMapping("/category/view/all")
	public ResponseEntity<List<Category>> viewAllCategory() {

		return new ResponseEntity<List<Category>>(catServ.viewAllCategory(), HttpStatus.OK);
	}

}
