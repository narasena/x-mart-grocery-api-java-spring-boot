package com.narasena.xmart_grocery_api.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.narasena.xmart_grocery_api.dto.ProductSubCategoryDTO;
import com.narasena.xmart_grocery_api.entity.ProductSubCategory;
import com.narasena.xmart_grocery_api.repository.ProductSubCategoryRepository;

@Service
public class ProductSubCategoryService {

  @Autowired
  private ProductSubCategoryRepository productSubCategoryRepository;

  public ProductSubCategory creatProductSubCategory(ProductSubCategory productSubCategory) {
    return productSubCategoryRepository.save(productSubCategory);
  }

  public List<ProductSubCategory> getAllProductSubCategories() {
    return productSubCategoryRepository.findAll();
  }

  public List<ProductSubCategoryDTO> getAllProductSubCategoryDTOs() {
    List<ProductSubCategory> subCategories = productSubCategoryRepository.findAll();
    List<ProductSubCategoryDTO> subCategoryDTOs = new ArrayList<>();

    for(ProductSubCategory subCategory: subCategories) {
      ProductSubCategoryDTO subCategoryDTO = new ProductSubCategoryDTO();
      subCategoryDTO.setId(subCategory.getId());
      subCategoryDTO.setName(subCategory.getName());
      subCategoryDTO.setSlug(subCategory.getSlug());
      subCategoryDTO.setDescription(subCategory.getDescription());
      subCategoryDTO.setProductCategoryId(subCategory.getCategory().getId());
      subCategoryDTO.setProductCategoryName(subCategory.getCategory().getName());
      subCategoryDTOs.add(subCategoryDTO);
    }

    return subCategoryDTOs;
  }

  public ProductSubCategory getProductSubCategoryById(Integer id) {
    return productSubCategoryRepository.findById(id).orElse(null);
  }

  public ProductSubCategory updateProductSubCategory(ProductSubCategory productSubCategory) {
    return productSubCategoryRepository.save(productSubCategory);
  }

  public void deleteProductSubCategory(Integer id) {
    productSubCategoryRepository.deleteById(id);
  }
}
