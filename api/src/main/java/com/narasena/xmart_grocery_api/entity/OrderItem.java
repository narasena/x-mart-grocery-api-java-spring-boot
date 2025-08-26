package com.narasena.xmart_grocery_api.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name = "order_items")
public class OrderItem extends BaseEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;

  @ManyToOne
  @JoinColumn(name = "order_id", nullable = false)
  private Order order;

  @ManyToOne
  @JoinColumn(name = "product_id", nullable = false)
  private Product product;

  @Column(nullable = false)
  private Integer quantity;

  @Column(name = "base_price", nullable = false, precision = 10, scale = 2)
  private BigDecimal basePrice;

  @ManyToOne
  @JoinColumn(name = "promotion_product_id")
  private PromotionProduct promotionProduct;

  @Column(name = "discount_amount", precision = 10, scale = 2)
  private BigDecimal discountAmount;

  @Column(name = "final_price", nullable = false, precision = 10, scale = 2)
  private BigDecimal finalPrice;

  // Getters and setters
  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  public Order getOrder() {
    return order;
  }

  public void setOrder(Order order) {
    this.order = order;
  }
  public Product getProduct() {
    return product;
  }

  public void setProduct(Product product) {
    this.product = product;
  }

  public Integer getQuantity() {
    return quantity;
  }

  public void setQuantity(Integer quantity) {
    this.quantity = quantity;
  }

  public BigDecimal getBasePrice() {
    return basePrice;
  }

  public void setBasePrice(BigDecimal basePrice) {
    this.basePrice = basePrice;
  }

  public PromotionProduct getPromotionProduct() {
    return promotionProduct;
  }
  public void setPromotionProduct(PromotionProduct promotionProduct) {
    this.promotionProduct = promotionProduct;
  }

  public BigDecimal getDiscountAmount() {
    return discountAmount;
  }

  public void setDiscountAmount(BigDecimal discountAmount) {
    this.discountAmount = discountAmount;
  }

  public BigDecimal getFinalPrice() {
    return finalPrice;
  }

  public void setFinalPrice(BigDecimal finalPrice) {
    this.finalPrice = finalPrice;
  }
}
