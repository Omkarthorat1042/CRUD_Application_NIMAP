package com.omkar.service;

import java.util.List;

import com.omkar.entity.Product;

public interface ProductService {

	Product createProduct(Product product);
	
	List<Product> getAllProducts(int page, int size);
	
	Product getProductById(Long id);
	
	Product updateProduct(Long id, Product product);
	
	void deleteProduct(Long id);
	
	
	
	
	
}
