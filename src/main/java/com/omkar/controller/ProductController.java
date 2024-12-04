package com.omkar.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.omkar.entity.Product;
import com.omkar.service.CategoryService;
import com.omkar.service.ProductService;

@RestController
@RequestMapping("/api/products")
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@Autowired
	private CategoryService categoryService;
	
	@PostMapping
	public Product createProduct(@RequestBody Product product) {
	
		return productService.createProduct(product);
	}
	
	
	@GetMapping
	public List<Product> getAllProducts(@RequestParam(defaultValue = "0") int page, 
		@RequestParam(defaultValue = "10")	int size){
		
		return productService.getAllProducts(page, size);
	}
	
	@GetMapping("/{id}")
	public Product getProductById(@PathVariable Long id) {
		
		return productService.getProductById(id);
	}
	
	@PutMapping("/{id}")
	public Product updateProduct(@PathVariable Long id, @RequestBody Product updatedproduct) {
		
		return productService.updateProduct(id, updatedproduct);
	}
	
	@DeleteMapping("/{id}")
	public String deleteProduct(@PathVariable Long id) {
		productService.deleteProduct(id);
		return "Product deleted successfully";
		
	}
	
	
	
	
	
	
	
	
	
}
