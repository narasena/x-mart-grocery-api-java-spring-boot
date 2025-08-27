package com.narasena.xmart_grocery_api.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "product_sub_categories")
public class ProductSubCategory extends BaseEntity {
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @ManyToOne
  @JoinColumn(name = "category_id")
  private ProductCategory category;

  @Column(columnDefinition = "TEXT", nullable = false, unique = true)
  private String name;

  @Column(columnDefinition = "TEXT", nullable = false, unique = true)
  private String slug;

  @Column(columnDefinition = "TEXT")
  private String description;

  @OneToMany(mappedBy = "productSubCategory", cascade = CascadeType.ALL)
  private java.util.List<Product> products;

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
    
    public ProductCategory getCategory() { return category; }
    public void setCategory(ProductCategory category) { this.category = category; }

    public java.util.List<Product> getProducts() {
        return products;
    }

    public void setProducts(java.util.List<Product> products) {
        this.products = products;
    }
}
