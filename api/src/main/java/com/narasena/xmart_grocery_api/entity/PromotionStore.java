package com.narasena.xmart_grocery_api.entity;

import java.util.UUID;

import jakarta.persistence.*;

@Entity
@Table(name = "promotion_stores")
public class PromotionStore extends BaseEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;

  @ManyToOne
  @JoinColumn(name = "promotion_id", nullable = false)
  private Promotion promotion;

  @ManyToOne
  @JoinColumn(name = "store_id", nullable = false)
  private Store store;

  // Getters and setters
  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  public Promotion getPromotion() {
    return promotion;
  }

  public void setPromotion(Promotion promotion) {
    this.promotion = promotion;
  }
  public Store getStore() {
    return store;
  }

  public void setStore(Store store) {
    this.store = store;
  }
}
