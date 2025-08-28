package com.narasena.xmart_grocery_api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.narasena.xmart_grocery_api.entity.ProductCategory;
import com.narasena.xmart_grocery_api.repository.ProductCategoryRepository;

@Service
public class ProductCategoryService {
  
  @Autowired
  private ProductCategoryRepository productCategoryRepository;

  public ProductCategory creatProductCategory(ProductCategory productCategory) {
    return productCategoryRepository.save(productCategory);
  }

  public List<ProductCategory> getAllProductCategories() {
    return productCategoryRepository.findAll();
  }

  public ProductCategory getProductCategoryById(Integer id) {
    return productCategoryRepository.findById(id).orElse(null);
  }

  public ProductCategory updateProductCategory(ProductCategory productCategory) {
    return productCategoryRepository.save(productCategory);
  }

  public void deleteProductCategory(Integer id) {
    productCategoryRepository.deleteById(id);
  }
}
