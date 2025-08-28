package com.narasena.xmart_grocery_api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.narasena.xmart_grocery_api.entity.ProductCategory;
import com.narasena.xmart_grocery_api.service.ProductCategoryService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("api/product-categories")
public class ProductCategoryController {
  
  @Autowired
  private ProductCategoryService productCategoryService;

  @PostMapping("/create")
  public String createProductCategory(@RequestBody ProductCategory productCategory) {
      //TODO: process POST request
      
      return productCategoryService.creatProductCategory(productCategory).getName();
  }
  
}
