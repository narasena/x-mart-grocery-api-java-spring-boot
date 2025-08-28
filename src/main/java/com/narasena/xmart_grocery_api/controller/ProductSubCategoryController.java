package com.narasena.xmart_grocery_api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.narasena.xmart_grocery_api.dto.ProductSubCategoryDTO;
import com.narasena.xmart_grocery_api.service.ProductSubCategoryService;


@RestController
@RequestMapping("api/product-categories/subs")
public class ProductSubCategoryController {
  
  @Autowired
  private ProductSubCategoryService productSubCategoryService;

  @GetMapping("/")
  public List<String> getAllProductSubCategories() {
      
      return List.of("Test");
  }

  @GetMapping("/all")
  public List<ProductSubCategoryDTO> getAllProductSubCategoriesDTOs() {
      
      return productSubCategoryService.getAllProductSubCategoryDTOs();
  }
  
}
