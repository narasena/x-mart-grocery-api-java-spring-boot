package com.narasena.xmart_grocery_api.entity;

import java.util.UUID;

import jakarta.persistence.*;

@Entity
@Table(name = "product_stocks")
public class ProductStock extends BaseEntity {
  
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;
  
  // Many-to-One: Many stocks belong to one product
  @ManyToOne
  @JoinColumn(name = "product_id", nullable = false)
  private Product product;
  
  // Many-to-One: Many stocks belong to one store
  @ManyToOne
  @JoinColumn(name = "store_id", nullable = false)
  private Store store;
  
  @Column(nullable = false)
  private Integer quantity;
  
  @Column(name = "min_stock_level", nullable = false)
  private Integer minStockLevel;
  
  
  // Getters and setters
  public java.util.UUID getId() { return id; }
  public void setId(java.util.UUID id) { this.id = id; }
  
  public Product getProduct() { return product; }
  public void setProduct(Product product) { this.product = product; }
  
  public Store getStore() { return store; }
  public void setStore(Store store) { this.store = store; }
  
  public Integer getQuantity() { return quantity; }
  public void setQuantity(Integer quantity) { this.quantity = quantity; }
  
  public Integer getMinStockLevel() { return minStockLevel; }
  public void setMinStockLevel(Integer minStockLevel) { this.minStockLevel = minStockLevel; }
}
