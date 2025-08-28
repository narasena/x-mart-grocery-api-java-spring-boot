package com.narasena.xmart_grocery_api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.narasena.xmart_grocery_api.entity.ProductCategory;


public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Integer> {
  List<ProductCategory> findByName(String name);

  List<ProductCategory> findBySlug(String slug);
  List<ProductCategory> findByNameContaining(String keyword);
}
