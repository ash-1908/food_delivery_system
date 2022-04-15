package com.cg.FDS.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.FDS.dao.ICategoryRepository;
import com.cg.FDS.exception.EmptyValuesException;
import com.cg.FDS.exception.category.CategoryAlreadyExistsException;
import com.cg.FDS.exception.category.CategoryNotFoundException;
import com.cg.FDS.model.Category;

@Service
public class ICategoryServiceImpl implements ICategoryService {

	@Autowired
	ICategoryRepository catRepo;

	@Override
	public Category addCategory(Category cat) {
		if (cat.getCatId() == null || cat.getCatId().length() == 0)
			throw new EmptyValuesException("Category Id cannot be empty.");
		if (cat.getCategoryName() == null || cat.getCategoryName().length() == 0)
			throw new EmptyValuesException("Category name cannot be empty.");
		if (catRepo.existsById(cat.getCatId()))
			throw new CategoryAlreadyExistsException("Category already exists.");

		catRepo.save(cat);
		return cat;
	}

	@Override
	public Category updateCategory(Category cat) {
		if (cat.getCatId() == null || cat.getCatId().length() == 0)
			throw new EmptyValuesException("Category Id cannot be empty.");
		if (cat.getCategoryName() == null || cat.getCategoryName().length() == 0)
			throw new EmptyValuesException("Category name cannot be empty.");
		if (!catRepo.existsById(cat.getCatId()))
			throw new CategoryNotFoundException("Category does not exist.");

		catRepo.save(cat);
		return cat;
	}

	@Override
	public Category removeCategory(Category cat) {
		if (cat.getCatId() == null || cat.getCatId().length() == 0)
			throw new EmptyValuesException("Category Id cannot be empty.");
		if (!catRepo.existsById(cat.getCatId()))
			throw new CategoryNotFoundException("Category does not exist.");

		cat = catRepo.findById(cat.getCatId()).get();
		catRepo.deleteById(cat.getCatId());
		return cat;
	}

	@Override
	public Category viewCategory(Category cat) {
		if (cat.getCatId() == null || cat.getCatId().length() == 0)
			throw new EmptyValuesException("Category Id cannot be empty.");

		if (!catRepo.existsById(cat.getCatId()))
			throw new CategoryNotFoundException("Category does not exist");

		cat = catRepo.findById(cat.getCatId()).get();

		return cat;
	}

	@Override
	public List<Category> viewAllCategory() {

		return catRepo.findAll();
	}

}
