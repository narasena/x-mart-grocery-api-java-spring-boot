package com.narasena.xmart_grocery_api.entity;
import java.util.UUID;

import com.narasena.xmart_grocery_api.enums.ProductStockMovementType;

import jakarta.persistence.*;

@Entity
@Table(name = "product_stock_history")
public class ProductStockLog extends BaseEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;
  @ManyToOne
  @JoinColumn(name = "product_stock_id", nullable = false)
  private ProductStock productStock;

  @Column(nullable = false)
  private Integer quantity;

  @Enumerated(EnumType.STRING)
  @Column(nullable = false)
  private ProductStockMovementType type;

  @Column(columnDefinition = "TEXT")
  private String description;

  @Column(columnDefinition = "TEXT", name="type_reference")
  private String typeReference;

  // Getters and setters
  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  public ProductStock getProductStock() {
    return productStock;
  }

  public void setProductStock(ProductStock productStock) {
    this.productStock = productStock;
  }
  public Integer getQuantity() {
    return quantity;
  }

  public void setQuantity(Integer quantity) {
    this.quantity = quantity;
  }

  public ProductStockMovementType getType() {
    return type;
  }

  public void setType(ProductStockMovementType type) {
    this.type = type;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }
  public String getTypeReference() {
    return typeReference;
  }

  public void setTypeReference(String typeReference) {
    this.typeReference = typeReference;
  }
}
