package com.narasena.xmart_grocery_api.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "product_categories")
public class ProductCategory extends BaseEntity {
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
  private java.util.List<ProductSubCategory> subCategories;

  @Column(nullable = false, unique = true)
  private String name;

  @Column(nullable = false, unique = true)
  private String slug;

  @Column(columnDefinition = "TEXT")
  private String description;

    // Getters and setters
    public Integer getId() { return id; }

    public void setId(Integer id) {
      this.id = id;
    }
    
    public String getName() { return name; }

    public void setName(String name) {
      this.name = name;
    }
    
    
    public String getSlug() { return slug; }

    public void setSlug(String slug) {
      this.slug = slug;
    }
    
    public String getDescription() { return description; }

    public void setDescription(String description) {
      this.description = description;
    }
    
    public java.util.List<ProductSubCategory> getSubCategories() { return subCategories; }
    public void setSubCategories(java.util.List<ProductSubCategory> subCategories) { this.subCategories = subCategories; }
}
