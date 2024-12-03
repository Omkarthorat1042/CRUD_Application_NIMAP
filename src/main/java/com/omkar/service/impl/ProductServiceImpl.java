package com.omkar.service.impl;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.omkar.entity.Category;
import com.omkar.entity.Product;
import com.omkar.repository.CategoryRepo;
import com.omkar.repository.ProductRepo;
import com.omkar.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private CategoryRepo categoryRepo;

	@Autowired
	private ProductRepo productRepo;

	@Override
	public Product createProduct(Product product) {
		
		if(product.getCategory() != null && product.getCategory().getId() != null) 
		{
			Optional<Category> c = categoryRepo.findById(product.getCategory().getId());
			
			if(c.isPresent()) {
				product.setCategory(c.get());
			}else {
				throw new NoSuchElementException("Category not found");
			}
	
			
		}
		return productRepo.save(product);
		
	}

	@Override
	public List<Product> getAllProducts(int page, int size) {

		Page<Product> all = productRepo.findAll(PageRequest.of(page, size));

		return all.getContent();
	}

	@Override
	public Product getProductById(Long id) {
		Optional<Product> byId = productRepo.findById(id);

		if (byId.isPresent()) {
			return byId.get();
		} else {
			throw new NoSuchElementException("Product not found");
		}

	}

	@Override
	public Product updateProduct(Long id, Product updatedproduct) {

		Optional<Product> optional = productRepo.findById(id);
		if (optional.isPresent()) {
			Product product = optional.get();

			product.setName(updatedproduct.getName());
			product.setPrice(updatedproduct.getPrice());

			if (updatedproduct.getCategory() != null && updatedproduct.getCategory().getId() != null) {
				Optional<Category> optionalCategory = categoryRepo.findById(updatedproduct.getCategory().getId());
				if (optionalCategory.isPresent()) {
					product.setCategory(optionalCategory.get());
				} else {
					throw new NoSuchElementException("category not found");
				}
			}
			return productRepo.save(product);
		} else {
			throw new NoSuchElementException("Product not found");

		}

	}

	@Override
	public void deleteProduct(Long id) {
		
		Optional<Product> productOptional = productRepo.findById(id);
		
		if(productOptional.isPresent()) {
			productRepo.delete(productOptional.get());
		}else {
			throw new NoSuchElementException("Product not found");
		}
		
		
		
	}

}

