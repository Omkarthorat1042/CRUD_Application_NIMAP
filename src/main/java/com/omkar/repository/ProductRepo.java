package com.omkar.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.omkar.entity.Product;

public interface ProductRepo extends JpaRepository<Product, Long>{

}
