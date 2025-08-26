package com.narasena.xmart_grocery_api.entity;

import jakarta.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "product_brands")
public class ProductBrand extends BaseEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;

  @OneToMany(mappedBy = "brand", cascade = CascadeType.ALL)
  private java.util.List<Product> products;

  @Column(nullable = false, unique = true)
  private String name;

  @Column(nullable = false, unique = true)
  private String slug;

  @Column(columnDefinition = "TEXT")
  private String description;

  @Column(name = "img_url")
  private String brandImgUrl;  // Generic URL - works with any CDN
  
  @Column(name = "resource_id")
  private String resourceId; // Provider-specific ID for deletion

  // Getters and setters
  public UUID getId() { return id; }
  public void setId(UUID id) { this.id = id; }
  public String getName() { return name; }
  public void setName(String name) { this.name = name; }
  public String getSlug() { return slug; }
  public void setSlug(String slug) { this.slug = slug; }
  public String getDescription() { return description; }
  public void setDescription(String description) { this.description = description; }
  public String getImageUrl() { return brandImgUrl; }
  public void setImageUrl(String imageUrl) { this.brandImgUrl = imageUrl; }
  public String getResourceId() { return resourceId; }
  public void setResourceId(String resourceId) { this.resourceId = resourceId; }
  public java.util.List<Product> getProducts() { return products; }
  public void setProducts(java.util.List<Product> products) { this.products = products; }
}
