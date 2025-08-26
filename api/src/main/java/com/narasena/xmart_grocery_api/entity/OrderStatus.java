package com.narasena.xmart_grocery_api.entity;

import jakarta.persistence.*;

import java.util.UUID;


@Entity
@Table(name = "order_status")
public class OrderStatus extends BaseEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;

  @ManyToOne
  @JoinColumn(name = "order_id", nullable = false)
  private Order order;

  @Enumerated(EnumType.STRING)
  private OrderStatus status;
  
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

  public OrderStatus getStatus() {
    return status;
  }

  public void setStatus(OrderStatus status) {
    this.status = status;
  }
}
