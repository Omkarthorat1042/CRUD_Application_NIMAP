package com.omkar.service.impl;

import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.omkar.entity.Category;
import com.omkar.repository.CategoryRepo;
import com.omkar.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryRepo categoryRepo;

	@Override
	public Page<Category> getAllCategories(Pageable pageable) {

		return categoryRepo.findAll(pageable);
	}

	@Override
	public Category getCategoryById(Long id) {

		Optional<Category> optionalCategory = categoryRepo.findById(id);
		if (optionalCategory.isPresent()) {
			return optionalCategory.get();
		} else {
			throw new NoSuchElementException("Category not found");
		}

	}

	@Override
	public Category createCategory(Category category) {

		return categoryRepo.save(category);
	}

	@Override
	public Category updateCategory(Long id, Category category) {

	Category c = getCategoryById(id);
	c.setName(category.getName());

		return categoryRepo.save(c);
	}

	@Override
	public void deleteCategory(Long id) {

	}

}
