package com.narasena.xmart_grocery_api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.narasena.xmart_grocery_api.entity.ProductSubCategory;

public interface ProductSubCategoryRepository extends JpaRepository<ProductSubCategory, Integer> {
  List  <ProductSubCategory> findByName(String name);

  List<ProductSubCategory> findBySlug(String slug);

  List<ProductSubCategory> findByNameContaining(String keyword);
  
}
