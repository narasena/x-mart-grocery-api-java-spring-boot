package com.narasena.xmart_grocery_api.entity;

import jakarta.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "promotion_products")
public class PromotionProduct extends BaseEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    
    @ManyToOne
    @JoinColumn(name = "promotion_id", nullable = false)
    private Promotion promotion;
    
    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    @OneToMany(mappedBy = "promotionProduct", cascade = CascadeType.ALL)
    private java.util.List<OrderItem> orderItems;
    
    // Getters and setters
    public UUID getId() { return id; }
    public void setId(UUID id) { this.id = id; }
    
    public Promotion getPromotion() { return promotion; }
    public void setPromotion(Promotion promotion) { this.promotion = promotion; }
    
    public Product getProduct() { return product; }

    public void setProduct(Product product) {
        this.product = product;
    }

    public java.util.List<OrderItem> getOrderItems() { return orderItems; }
    public void setOrderItems(java.util.List<OrderItem> orderItems) { this.orderItems = orderItems; }
}