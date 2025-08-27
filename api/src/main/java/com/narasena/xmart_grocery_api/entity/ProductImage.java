package com.narasena.xmart_grocery_api.entity;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "product_images")
public class ProductImage extends BaseEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;

  @ManyToOne
  @JoinColumn(name = "product_id")
  private Product product;

  @Column(columnDefinition = "TEXT", name = "img_url")
  private String imgUrl;

  @Column(columnDefinition = "TEXT")
  private String resourceId; // Provider-specific ID for deletion

  @Column
  private Boolean isMainImg = false;

  // Getters and setters
  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  public Product getProduct() {
    return product;
  }

  public void setProduct(Product product) {
    this.product = product;
  }

  public String getImgUrl() {
    return imgUrl;
  }

  public void setImgUrl(String imgUrl) {
    this.imgUrl = imgUrl;
  }
  public String getResourceId() {
    return resourceId;
  }

  public void setResourceId(String resourceId) {
    this.resourceId = resourceId;
  }

  public Boolean getMainImg() {
    return isMainImg;
  }

  public void setMainImg(Boolean mainImg) {
    isMainImg = mainImg;
  }
}
