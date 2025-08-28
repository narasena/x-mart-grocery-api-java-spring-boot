package com.narasena.xmart_grocery_api.dto;

import lombok.Data;

@Data
public class ProductSubCategoryDTO {
  private Integer id;
  private String name;
  private String slug;
  private String description;
  private Integer productCategoryId;
  private String productCategoryName;
}
