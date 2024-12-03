package com.omkar.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.omkar.entity.Category;

public interface CategoryRepo extends JpaRepository<Category, Long>{

}
